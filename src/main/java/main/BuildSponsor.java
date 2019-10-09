package main;

import model.Sponsor;

import org.dom4j.Element;


public class BuildSponsor {

    public static Sponsor build(Element node) {
        Sponsor sponsor = new Sponsor();
        sponsor.setAgency(node.elementTextTrim("agency"));
        sponsor.setAgencyClass(node.elementTextTrim("agency_class"));
        return sponsor;

    }
}
