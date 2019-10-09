package main;

import model.Contact;
import org.dom4j.Element;


public class BuildContact {

    public static Contact buildContact(Element node) {
        Element element = node.element("point_of_contact");

        if (element == null) {
            return null;
        }

        Contact contact = new Contact();
        contact.setEmail(element.elementText("email"));
        contact.setName(element.elementText("name_or_title"));
        contact.setOrganization(element.elementText("organization"));
        contact.setPhone(element.elementText("phone"));

        return contact;
    }
}
