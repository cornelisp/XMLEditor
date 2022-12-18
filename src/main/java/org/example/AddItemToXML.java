package org.example;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
public class AddItemToXML {

    public static void main(String[] args) {
        try {


            File inputFile = new File("C:\\Users\\korne\\IdeaProjects\\XML\\StoreItems.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            Element newItem = doc.createElement("Item");

            Element name = doc.createElement("Name");
            name.setTextContent("Lampka");
            newItem.appendChild(name);

            Element price = doc.createElement("Price");
            price.setTextContent("100");
            newItem.appendChild(price);

            Element quantity = doc.createElement("Quantity");
            quantity.setTextContent("2");
            newItem.appendChild(quantity);

            doc.getDocumentElement().appendChild(newItem);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "storeitems.dtd");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("C:\\Users\\korne\\IdeaProjects\\XML\\StoreItems.xml"));
            transformer.transform(source, result);

            System.out.println("Przedmiot dodany pomyślnie.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}