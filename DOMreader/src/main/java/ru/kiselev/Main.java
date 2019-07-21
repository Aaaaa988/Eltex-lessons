package ru.kiselev;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Msg> msgs = new ArrayList<>();
    public static void main(String[] args) throws ParserConfigurationException, IOException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("src/main/resources/input.xml"));
        NodeList msgElements = document.getDocumentElement().getElementsByTagName("msg");
        for (int i = 0; i < msgElements.getLength(); i++) {
            Node msg = msgElements.item(i);
            NamedNodeMap attributes = msg.getAttributes();
            String Text = msg.getTextContent();
            msgs.add(new Msg(attributes.getNamedItem("to").getNodeValue(), attributes.getNamedItem("from").getNodeValue(), Text ));
        }
        for (Msg msg : msgs)
            System.out.println(msg.getMsg());
    }
}
