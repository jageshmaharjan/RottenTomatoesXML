package com.example;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by jugs on 9/29/16.
 */
public class XMLFileCreate1
{
    public static void main(String[] args)
    {
        try
        {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            Document doc = dBuilder.newDocument();

            Element rootElement = doc.createElement("Company");
            doc.appendChild(rootElement);

            Element staff = doc.createElement("staff");
            rootElement.appendChild(staff);
            staff.setAttribute("id","1");

            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("jugs"));
            staff.appendChild(firstname);

            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("ma"));
            staff.appendChild(lastname);

            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("shaggy"));
            staff.appendChild(nickname);

            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode("Beijing"));
            staff.appendChild(address);

            Element telephones = doc.createElement("telephones");
            staff.appendChild(telephones);

            Element tel1 = doc.createElement("tel");
            tel1.appendChild(doc.createTextNode("+86-188131315qq"));
            telephones.appendChild(tel1);

            Element tel2 = doc.createElement("tel");
            tel2.appendChild(doc.createTextNode("+977-98415617@@"));
            telephones.appendChild(tel2);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("CompanyStaff.xml"));

            transformer.transform(source,result);
            System.out.println("File Saved");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
