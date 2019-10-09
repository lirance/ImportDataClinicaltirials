package main;

import model.LocationStudy;
import org.dom4j.Element;


public class BuildLocationStudy {

    public static LocationStudy build(Element location, String nctId) {
        Element facility = location.element("facility");
        if (facility == null) {
            return null;
        }
        LocationStudy locationStudy = new LocationStudy();
        locationStudy.setName(facility.elementTextTrim("name"));
        Element add = facility.element("address");
        if (add != null) {
            String zip = add.elementText("zip");
            if (zip == null) {
                return null;
            }
            try{
                locationStudy.setZip(Integer.parseInt(zip));
            }catch (Exception e){
                return null;
            }

        }

        locationStudy.setNctId(nctId);
        return locationStudy;
    }

}
