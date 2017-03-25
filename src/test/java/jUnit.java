import org.json.JSONObject;
import org.junit.Test;
import services.FutureWindSpeedService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eric Boot on 25-03-17.
 */
public class jUnit {
    FutureWindSpeedService futureWindSpeedService = new FutureWindSpeedService();

    @Test
    public void testKmH(){
        JSONObject data = new JSONObject();
        JSONObject item = new JSONObject();
        item.put("longitude", 52);
        item.put("latitude", 12);
        item.put("date", "2017-01-01");
        item.put("time", "12:01:00");

        data.put("data",item);

        String message = data.toString();

        assertEquals("De data is gelijk aan verwacht",
                "{\"unit\":\"km/h\",\"windspeed\":5.681951219512196}",
                futureWindSpeedService.getKmH(message).getEntity());;

    }

    @Test
    public void testMS(){
        JSONObject data = new JSONObject();
        JSONObject item = new JSONObject();
        item.put("longitude", -12);
        item.put("latitude", -55);
        item.put("date", "2017-04-08");
        item.put("time", "04:01:00");

        data.put("data",item);

        String message = data.toString();

        assertEquals("De data is gelijk aan verwacht",
                "{\"unit\":\"m/s\",\"windspeed\":1.5054200542005418}",
                futureWindSpeedService.getMS(message).getEntity());

    }
}
