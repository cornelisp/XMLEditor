package org.example;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class ReadXMLFile {

    public static void main(String[] args) {
        try {
            File inputFile = new File("C:\\Users\\korne\\IdeaProjects\\XML\\StoreItems.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Odczytywanie pliku XML pod nazwą: " + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Item");
            System.out.println("----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("");
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Nazwa przedmiotu: "
                            + eElement
                            .getElementsByTagName("Name")
                            .item(0)
                            .getTextContent());
                    System.out.println("Cena: "
                            + eElement
                            .getElementsByTagName("Price")
                            .item(0)
                            .getTextContent());
                    System.out.println("Ilość: "
                            + eElement
                            .getElementsByTagName("Quantity")
                            .item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

