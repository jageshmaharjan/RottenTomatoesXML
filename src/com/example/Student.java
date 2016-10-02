package com.example;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.List;

/**
 * Created by jugs on 9/29/16.
 */
@XmlRootElement(name = "com.example.Student")
public class Student
{
    List<StudentModel> studentModels;

    public static void main(String[] args)
    {
        File file = new File("data/myObjFile.txt");
        File xml =new File("myXmlFile.xml");
        FileReader fr4;
        BufferedReader br4;
        FileWriter fw2;
        String readFile;
        String[] line ;
        if( !xml.exists() )
        {
            try
            {
                fr4 = new FileReader(file);
                br4 = new BufferedReader(fr4);

                while( (readFile = br4.readLine()) != null )
                {
                    line = readFile.split(",");

                    StudentModel toXml = new StudentModel(line[0],line[1],  Integer.parseInt(line[2]),
                            Integer.parseInt(line[3]), line[4], line[5], line[6], line[7],
                            line[8], line[9], line[10], Integer.parseInt(line[11]));

                    JAXBContext context;
                    context = JAXBContext.newInstance(StudentModel.class);
                    Marshaller marshal = context.createMarshaller();
                    marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                            Boolean.TRUE);

                    fw2 = new FileWriter(xml, true);
                    marshal.marshal(toXml, fw2);
                }
            } catch (JAXBException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File not created");
        }
    }
}
