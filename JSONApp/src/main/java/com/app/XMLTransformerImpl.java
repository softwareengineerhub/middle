package com.app;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Администратор on 09.07.2017.
 */
public class XMLTransformerImpl implements Transformer {

    public String from(List<Person> prsons) {
        StringBuilder sb = new StringBuilder();
        sb.append("<persons>\n");
        for(Person p: prsons) {
            sb.append("<person>\n");
            sb.append("<name>");
            sb.append(p.getName());
            sb.append("</name>\n");
            sb.append("<age>");
            sb.append(p.getAge());
            sb.append("</age>\n");
            sb.append("</person>\n");
        }
        sb.append("</persons>");
        return sb.toString();
    }

    public List<Person> to(String str) {
        final List<Person> persons = new ArrayList<Person>();
        SAXParserFactory factory=SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = factory.newSAXParser();
            ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
            saxParser.parse(in, new DefaultHandler(){
                private Person person;
                private boolean inAge;
                private boolean inName;

                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if("person".equals(qName)){
                        person = new Person();
                    }
                    if("age".equals(qName)){
                        inAge=true;
                    }
                    if("name".equals(qName)){
                        inName=true;
                    }
                }

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    String val = new String(ch, start, length);
                    if(!val.trim().isEmpty()){
                        if(inName){
                            person.setName(val);
                        }
                        if(inAge){
                            person.setAge(Integer.parseInt(val));
                        }
                    }
                }

                @Override
                public void endElement(String uri, String localName, String qName) throws SAXException {
                    if("person".equals(qName)){
                        persons.add(person);
                    }
                    if("age".equals(qName)){
                        inAge=false;
                    }
                    if("name".equals(qName)){
                        inName=false;
                    }
                }


            });
            return persons;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
