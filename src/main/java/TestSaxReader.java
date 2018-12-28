import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class TestSaxReader {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        TestSaxParser saxp = new TestSaxParser();


        parser.parse(new File("src/main/resources/test.xml"), saxp);
        System.out.println("saxp" + saxp.getLastname());
    }
}

class TestSaxParser extends DefaultHandler{
    private String lastname;
    private String elementName;
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println( " uri : " + uri);
        System.out.println( " localname :" + localName);
        System.out.println( " lastname :" + lastname);
        System.out.println( "qname : " +qName);
        System.out.println( "attributes: " + attributes);
        System.out.println("starting " +qName);
        elementName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if("ФИО".equals(elementName)){
            lastname = new String(ch,start,length);
        }
        if("Фамилия".equals(elementName)){
            lastname = new String(ch,start,length);
        }


        System.out.println("Value " + new String(ch,start,length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println( " uri : " + uri);
        System.out.println( " localname :" + localName);
        System.out.println( " lastname :" + lastname);
        System.out.println( "qname : " +qName);
        System.out.println( "attributes: " );
        System.out.println("Ending of " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End");
    }
}
