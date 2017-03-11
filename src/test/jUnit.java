package test;

import customer.*;
import org.junit.Test;
import producer.WindServiceImpl;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Eric Boot on 11-03-17.
 */
public class jUnit {

    @Test
    public void doTest1() throws Fault_Exception, DatatypeConfigurationException, ParseException {
        Request request = new Request();
        DateTime dateTime = new DateTime();
        Location location = new Location();

        //set dateTime
        DateFormat dformat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dformat.parse("2017-02-02");
        GregorianCalendar cDate = new GregorianCalendar();
        cDate.setTime(date);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cDate);

        DateFormat tformat = new SimpleDateFormat("hh:mm:ss");
        Date time = tformat.parse("09:00:00");
        GregorianCalendar cTime = new GregorianCalendar();
        cTime.setTime(time);
        XMLGregorianCalendar time2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cTime);

        dateTime.setDate(date2);
        dateTime.setTime(time2);

        request.setDateTime(dateTime);

        //set location
        location.setLatitude(89.111);
        location.setLongitude(-11.11);

        request.setLocation(location);

        WindServiceImpl windService = new WindServiceImpl();
        Response response = windService.getWindSpeed(request);


        System.out.println(response.getWindspeed().toString() + response.getUnit().toString());

    }

    @Test
    public void doTest2() throws Fault_Exception, DatatypeConfigurationException, ParseException {
        Request request = new Request();
        DateTime dateTime = new DateTime();
        Location location = new Location();

        //set dateTime
        DateFormat dformat = new SimpleDateFormat("yyyy-mm-dd");
        Date date = dformat.parse("2017-12-02");
        GregorianCalendar cDate = new GregorianCalendar();
        cDate.setTime(date);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cDate);

        DateFormat tformat = new SimpleDateFormat("hh:mm:ss");
        Date time = tformat.parse("19:00:00");
        GregorianCalendar cTime = new GregorianCalendar();
        cTime.setTime(time);
        XMLGregorianCalendar time2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cTime);

        dateTime.setDate(date2);
        dateTime.setTime(time2);

        request.setDateTime(dateTime);

        //set location
        location.setLatitude(1.111);
        location.setLongitude(-111.11);

        request.setLocation(location);

        WindServiceImpl windService = new WindServiceImpl();
        Response response = windService.getWindSpeed(request);

        System.out.println(response.getWindspeed().toString() + response.getUnit().toString());


    }

}
