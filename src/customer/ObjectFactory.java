
package customer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the customer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Windspeedresponse_QNAME = new QName("http://futureweather/windspeed/response", "windspeedresponse");
    private final static QName _Windspeedrequest_QNAME = new QName("http://futureweather/windspeed/request", "windspeedrequest");
    private final static QName _Faulthandling_QNAME = new QName("http://futureweather/windspeed/fault", "faulthandling");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: customer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Request }
     * 
     */
    public Request createRequest() {
        return new Request();
    }

    /**
     * Create an instance of {@link DateTime }
     * 
     */
    public DateTime createDateTime() {
        return new DateTime();
    }

    /**
     * Create an instance of {@link Location }
     * 
     */
    public Location createLocation() {
        return new Location();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link Fault }
     * 
     */
    public Fault createFault() {
        return new Fault();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://futureweather/windspeed/response", name = "windspeedresponse")
    public JAXBElement<Response> createWindspeedresponse(Response value) {
        return new JAXBElement<Response>(_Windspeedresponse_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Request }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://futureweather/windspeed/request", name = "windspeedrequest")
    public JAXBElement<Request> createWindspeedrequest(Request value) {
        return new JAXBElement<Request>(_Windspeedrequest_QNAME, Request.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://futureweather/windspeed/fault", name = "faulthandling")
    public JAXBElement<Fault> createFaulthandling(Fault value) {
        return new JAXBElement<Fault>(_Faulthandling_QNAME, Fault.class, null, value);
    }

}
