package main;

import model.Location;
import org.dom4j.Element;


public class BuildLocation {

    public static Location build(Element location) {
        Element facility = location.element("facility");
        if (facility == null) {
            return null;
        }
        Element address = facility.element("address");
        Location lo = new Location();
        lo.setCity(address.elementTextTrim("city"));

        if (address != null) {
            String zip = address.elementText("zip");
            if (zip == null) {
//                lo.setZip(Integer.parseInt(zip));
                return null;
            }
        }
        try {
            lo.setZip(Integer.parseInt(address.elementTextTrim("zip")));
        } catch (Exception e) {
            return null;
        }
        lo.setCountry(address.elementTextTrim("country"));
        lo.setState(address.elementTextTrim("state"));

        return lo;
    }
}
