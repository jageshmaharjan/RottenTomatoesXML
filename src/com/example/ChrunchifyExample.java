package com.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by jugs on 9/29/16.
 */
public class ChrunchifyExample
{
    public static void main(String[] args)
    {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try
        {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElementNS("http://crunchify.com/CrunchifyCreateXMLDOM","companies");
            doc.appendChild(mainRootElement);

            mainRootElement.appendChild(getCompany(doc, "1","paypal","payment","10000"));
            mainRootElement.appendChild(getCompany(doc, "2","ebay","Shopping","15000"));
            mainRootElement.appendChild(getCompany(doc, "1","paypal","payment","10000"));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source,console);

            System.out.println(doc);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private static Node getCompany(Document doc, String id, String name, String age, String role)
    {
        Element company = doc.createElement("company");
        company.appendChild(getCompanyElements(doc,company,"Name", name));
        company.appendChild(getCompanyElements(doc,company,"Type", age));
        company.appendChild(getCompanyElements(doc,company,"Employees", role));

        return company;
    }

    private static Node getCompanyElements(Document doc, Element element, String name, String values)
    {
        Element node = doc.createElement(name);
        node.appendChild(doc.createElement(values));

        return node;
    }
}
