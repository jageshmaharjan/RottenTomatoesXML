package com.RottenTomatoesXML;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jugs on 9/29/16.
 */
public class RottenTomatoesXMLCreator implements RottenTomatoesConstants
{
    List<RottenTomatoesObject> movieData ;
    Document dom;
    int i = 0;

    public RottenTomatoesXMLCreator() throws Exception
    {
        movieData = new ArrayList<>();

        loadData();

        createDocument();
    }

    private void createDocument()
    {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.newDocument();
        }
        catch (ParserConfigurationException e)
        {
            System.out.println(e);
        }
    }

    private void loadData() throws Exception
    {
        RottebTomatoesJSONCrawler rtmovieData = new RottebTomatoesJSONCrawler();
        movieData = rtmovieData.getJSONFromURL();
    }

    public void runProgram()
    {
        System.out.println("Started .. ");
        createDOMTree();
        printToFile();
        System.out.println("Generated file successfully.");
    }

    private void createDOMTree()
    {
        Element rootEle = dom.createElement("rottentomatoes.com");
        dom.appendChild(rootEle);

        Iterator it = movieData.iterator();
        while (it.hasNext())
        {
            RottenTomatoesObject rt = (RottenTomatoesObject) it.next();

            Element movieEle = createMovieDocument(rt);
            rootEle.appendChild(movieEle);
        }
    }

    private Element createMovieDocument(RottenTomatoesObject rt)
    {

        Element movieEle = dom.createElement("RottenTomatoes");

        makeId(movieEle,rt);

        makeTitle(movieEle,rt);

        makeReleaseDate(dom,movieEle,rt);

        makeDuration(dom,movieEle,rt);

        makeStoryLine(dom,movieEle,rt);

        makerating(dom,movieEle,rt);

        makeGenres(dom,movieEle,rt);

        makeActors(dom,movieEle,rt);

        makeDirectors(dom,movieEle,rt);

        makeRevies(dom,movieEle,rt);

        return movieEle;
    }

    private void makeId(Element movieEle, RottenTomatoesObject rt)
    {

        try
        {
            movieEle.setAttribute("id", String.valueOf(rt.getId()));

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally
        {
            movieEle.setAttribute("id", String.valueOf(i));
            i++;
        }
    }

    private void makeRevies(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try {
            Element reviewsEle = dom.createElement("Reviews");
            for (String review : rt.getReviews())
            {
                Element reviewEle = dom.createElement("Review");
                Text reviewTxt = dom.createTextNode(review);
                reviewEle.appendChild(reviewTxt);
                reviewsEle.appendChild(reviewEle);
            }
            movieEle.appendChild(reviewsEle);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeDirectors(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try {
            Element directorsEle = dom.createElement("Directors");
            for (String director : rt.getDirectors()) {
                Element direEle = dom.createElement("Director");
                Text dirTxt = dom.createTextNode(director);
                direEle.appendChild(dirTxt);
                directorsEle.appendChild(direEle);
            }
            movieEle.appendChild(directorsEle);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeActors(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element actorsEle = dom.createElement("Actors");
            for (String actor : rt.getActors())
            {
                Element actorEle = dom.createElement("actor");
                Text actortxt = dom.createTextNode(actor);
                actorEle.appendChild(actortxt);
                actorsEle.appendChild(actorEle);
            }
            movieEle.appendChild(actorsEle);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeGenres(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element genresEle = dom.createElement("Genres");
            for (String genre : rt.getGenre())
            {
                Element genreEle = dom.createElement("Genre");
                Text genreTxt = dom.createTextNode(genre);
                genreEle.appendChild(genreTxt);
                genresEle.appendChild(genreEle);
            }
            movieEle.appendChild(genresEle);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makerating(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element ratingEle = dom.createElement("Rating");
            Text ratingTxt = dom.createTextNode(rt.getRating());
            ratingEle.appendChild(ratingTxt);
            movieEle.appendChild(ratingEle);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeStoryLine(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element storylineEle = dom.createElement("StoryLine");
            Text storylineTxt = dom.createTextNode(rt.getStoryline());
            storylineEle.appendChild(storylineTxt);
            movieEle.appendChild(storylineEle);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeDuration(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element durationEle = dom.createElement("Duration");
            Text durationTxt = dom.createTextNode(rt.getDuration());
            durationEle.appendChild(durationTxt);
            movieEle.appendChild(durationEle);

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeReleaseDate(Document dom, Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element dateEle = dom.createElement("ReleaseDate");
            Text dateTxt = dom.createTextNode(rt.getDate());
            dateEle.appendChild(dateTxt);
            movieEle.appendChild(dateEle);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void makeTitle( Element movieEle, RottenTomatoesObject rt)
    {
        try
        {
            Element titleEle = dom.createElement("Title");
            Text titleTxt = dom.createTextNode(rt.getTitle());
            titleEle.appendChild(titleTxt);
            movieEle.appendChild(titleEle);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void printToFile()
    {
        try
        {
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            //to generate output to console use this serializer
            //XMLSerializer serializer = new XMLSerializer(System.out, format);


            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("output/RottenTomatoesMovies_" + STARTPAGE + ".xml")), format);

            serializer.serialize(dom);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception
    {
        RottenTomatoesXMLCreator rtXmlCreate = new RottenTomatoesXMLCreator();

        rtXmlCreate.runProgram();
    }
}
