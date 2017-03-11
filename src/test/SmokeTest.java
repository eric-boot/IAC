package test;

import customer.Request;
import org.junit.Ignore;
import org.junit.Test;
import producer.WindServiceImpl;

import static com.sun.tools.ws.wsdl.parser.Util.fail;


/**
 * Created by Eric Boot on 11-03-17.
 */
public class SmokeTest {

    @Ignore
    @Test
    public void doTest1()  {
        WindServiceImpl windService = new WindServiceImpl();

        try {
            Request request = new Request();
            windService.getWindSpeed(request);
            Thread.sleep(6000);
        } catch (Exception e) {
            fail(e.getMessage());
        }


    }

}
