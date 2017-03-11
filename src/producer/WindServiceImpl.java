package producer;

import customer.*;

import javax.jws.WebService;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Eric Boot on 07-03-17.
 */
@WebService( endpointInterface= "customer.WSInterface")
public class WindServiceImpl implements WSInterface {
    Random random = new Random();
    BigInteger actualWindspeed =  null;
    Unit unit = null;

    @Override
    public Response getWindSpeed(Request request) throws Fault_Exception {
        ObjectFactory factory = new ObjectFactory();
        Response response = factory.createResponse();

        Double windspeed = getLocationFactor(request) * getDateTimeFactor(request);


        //set the unit and windspeed
        if (random.nextBoolean()) {
            actualWindspeed = BigInteger.valueOf(windspeed.longValue());
            unit = Unit.KM_H;
        } else {
            windspeed = windspeed / 3.6;
            actualWindspeed = BigInteger.valueOf(windspeed.longValue());
            unit = Unit.M_S;
        }

        response.setWindspeed(actualWindspeed);
        response.setUnit(unit);

        //return the response
        return response;
    }

    public double getDateTimeFactor(Request request) throws Fault_Exception {

        double factor = 0;

        try {

            //Date -> spring=0.25, summer=0.5, autumn=2, winter=1
            int m = request.getDateTime().getDate().getMonth();
            if (m == 3 || m == 4 || m == 5) {
                factor = 0.25;
            } else if (m == 6 || m == 7 || m == 8) {
                factor = 0.5;
            } else if (m == 9 || m == 10 || m == 11) {
                factor = 2;
            } else if (m == 12 || m == 1 || m == 2) {
                factor += 1;
            }

            int h = request.getDateTime().getTime().getHour();
            if (h >= 0 && h < 6) {
                factor += 0.01;
            } else if (h >= 6 && h < 12) {
                factor += 0.05;
            } else if (h >= 12 && h < 18) {
                factor += 0.12;
            } else if (h >= 18 && h <= 24) {
                factor += 0.08;
            }

        }catch (Exception e){
            throw new Fault_Exception("Something has been wrong with your date and/or time.",null);
        }


        return factor;
    }

    public double getLocationFactor(Request request) throws Fault_Exception {

        double location;

        try {
            //make latitude positive
            Double latitude = request.getLocation().getLatitude();
            if(latitude < 0){
                latitude = -1*latitude;
            }

            //make longitude positive
            Double longitude = request.getLocation().getLongitude();
            if(longitude < 0){
                longitude = -1*longitude;
            }

            //far from the equator = high number
            location = (latitude/123) * longitude;
        }catch (Exception e){
            throw new Fault_Exception("Something has been wrong with your location.",null);
        }

        return location;
    }
}
