package com.geekaca.test.homework;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestReadBooks {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        File file = new File("books.xml");
        Document doucment = saxReader.read(file);

        Element rootElement = doucment.getRootElement();
        System.out.println(rootElement.getName());
        List<Element> elementList = rootElement.elements("book");
        List<Contact> contactList = new ArrayList<>();

        for (Element contact : elementList) {
            Contact ctt = new Contact();
            ctt.setName(contact.elementTextTrim("name"));
            ctt.setAuthor(contact.elementTextTrim("author"));
            ctt.setPrice(contact.elementTextTrim("sale"));
            contactList.add(ctt);

            Attribute idAttri = contact.attribute("id");
            String value = idAttri.getValue();
            System.out.println("id值：" + value);
            String name = contact.elementText("name");
            System.out.println(name);
        }

        contactList.forEach( (contact -> {
            System.out.println(contact);
        }) );
    }
}