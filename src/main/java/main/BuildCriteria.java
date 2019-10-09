package main;

import model.Criteria;
import org.dom4j.Element;


public class BuildCriteria {

    public static Criteria buildCriteria(Element node) {

        Criteria criteria = new Criteria();
        Element texNode = node.element("criteria");

        if (texNode != null) {
            criteria.setCriteriaiText(texNode.elementText("textblock"));
        }

        criteria.setGender(node.elementText("gender"));
        criteria.setMaximumAge(node.elementText("maximum_age"));
        criteria.setMinimumAge(node.elementText("minimum_age"));

        return criteria;
    }
}
