
package customer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unit.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="unit">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="m/s"/>
 *     &lt;enumeration value="km/h"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "unit", namespace = "http://futureweather/windspeed/response")
@XmlEnum
public enum Unit {

    @XmlEnumValue("m/s")
    M_S("m/s"),
    @XmlEnumValue("km/h")
    KM_H("km/h");
    private final String value;

    Unit(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Unit fromValue(String v) {
        for (Unit c: Unit.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
