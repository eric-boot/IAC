package services;

import org.json.JSONObject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Path("/futurewindspeed")
public class FutureWindSpeedService {

    @POST
    @Path("/getkmh")
    @Consumes("application/json")
    public Response getKmH(String JSONObj) {
        String message;

        try {
            JSONObject jObject  = new JSONObject(JSONObj.toString()); // json
            JSONObject data = jObject.getJSONObject("data"); // get data object

            String dateString = data.getString("date");
            DateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
            Date date =  df1.parse(dateString);

            String timeString = data.getString("time");
            DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
            Date time =  df2.parse(timeString);

            double longitude = data.getInt("longitude");
            double latitude = data.getInt("latitude");

            Double windspeed = getDateTimeFactor(date, time) * getLocationFactor(longitude, latitude);

            JSONObject item = new JSONObject();
            item.put("windspeed", windspeed);
            item.put("unit", "km/h");

            message = item.toString();


        } catch (Exception e) {
            System.out.println("Error Parsing: - " + e.toString() + "");
            return Response.status(300).entity("Something went wrong while parsing your JSON Array. " +
                    "Please check your JSON Array").build();

        }
        System.out.println("Data Received: " + JSONObj.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(message).build();
    }

    @POST
    @Path("/getms")
    @Consumes("application/json")
    public Response getMS(String JSONObj) {
        String message;

        try {
            JSONObject jObject  = new JSONObject(JSONObj.toString()); // json
            JSONObject data = jObject.getJSONObject("data"); // get data object

            String dateString = data.getString("date");
            DateFormat df1 = new SimpleDateFormat("yyyy-mm-dd");
            Date date =  df1.parse(dateString);

            String timeString = data.getString("time");
            DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
            Date time =  df2.parse(timeString);

            double longitude = data.getInt("longitude");
            double latitude = data.getInt("latitude");

            Double windspeed = getDateTimeFactor(date, time) * getLocationFactor(longitude, latitude)/3.6;

            JSONObject item = new JSONObject();
            item.put("windspeed", windspeed);
            item.put("unit", "m/s");

            message = item.toString();


        } catch (Exception e) {
            System.out.println("Error Parsing: - " + e.toString() + "");
            return Response.status(300).entity("Something went wrong while parsing your JSON Array. " +
                    "Please check your JSON Array").build();

        }
        System.out.println("Data Received: " + JSONObj.toString());

        // return HTTP response 200 in case of success
        return Response.status(200).entity(message).build();
    }


    public double getDateTimeFactor(Date date, Date time) {

        double factor = 0;

        //Date -> spring=0.25, summer=0.5, autumn=2, winter=1
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int m = cal.get(Calendar.MONTH)+1; //+1 because it starts with 0
        if (m == 3 || m == 4 || m == 5) {
            factor = 0.25;
        } else if (m == 6 || m == 7 || m == 8) {
            factor = 0.5;
        } else if (m == 9 || m == 10 || m == 11) {
            factor = 2;
        } else if (m == 12 || m == 1 || m == 2) {
            factor += 1;
        }

        cal.setTime(time);
        int h = cal.get(Calendar.HOUR_OF_DAY);
        if (h >= 0 && h < 6) {
            factor += 0.01;
        } else if (h >= 6 && h < 12) {
            factor += 0.05;
        } else if (h >= 12 && h < 18) {
            factor += 0.12;
        } else if (h >= 18 && h <= 24) {
            factor += 0.08;
        }

        return factor;
    }

    public double getLocationFactor(double longitude, double latitude) {

        //make latitude positive
        if(latitude < 0){
            latitude = -1*latitude;
        }

        //make longitude positive
        if(longitude < 0){
            longitude = -1*longitude;
        }

        //far from the equator = high number
        double location = (latitude/123) * longitude;


        return location;
    }
}
