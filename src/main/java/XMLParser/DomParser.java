package XMLParser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class DomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "Dom.xml");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        Document document = builder.parse(file);
        Element root = document.getDocumentElement();
        NodeList list = root.getChildNodes().item(1).getChildNodes();
        System.out.println(root.getTagName());
        for (int i = 0; i < list.getLength(); i++){
            Node node = list.item(i);
            if(node instanceof Element){
                System.out.println(node.getTextContent());
            }
        }
    }

}
