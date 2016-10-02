package com.RottenTomatoesXML;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jugs on 9/29/16.
 */
public class RottebTomatoesJSONCrawler implements RottenTomatoesConstants
{
    public List<RottenTomatoesObject> getJSONFromURL() throws Exception
    {
        List<RottenTomatoesObject> rtbjectList = new ArrayList<>();

        int startpage = STARTPAGE;

        URL url = new URL(JSONURL1 + startpage + JSONURL2);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
        String jsonData = null;
        while ((jsonData = br.readLine()) != null)
        {
            rtbjectList = parseJSON(jsonData);
        }
        return rtbjectList;
    }

    private List<RottenTomatoesObject> parseJSON(String jsonData) throws Exception
    {
        List<RottenTomatoesObject> rtMovieList = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try
        {
            RottenTomatoesObject rtMovies = null;

            Object obj = (Object) parser.parse(jsonData);
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray lists = new JSONArray();
            lists = (JSONArray) jsonObject.get("results");
            String runtime = (String) jsonObject.get("url");
            for (Object list : lists)
            {
                JSONObject jsnobj = (JSONObject) list;

                long id = (long) jsnobj.get("id");
                String url = (String) jsnobj.get("url");
                String title = (String) jsnobj.get("title");
                String storyline = (String) jsnobj.get("synopsis");
                // String releaseDate = (String) jsnobj.get("theaterReleaseDate");
                //String length = (String) jsnobj.get("runtime");
                JSONArray jsonActors = (JSONArray) jsnobj.get("actors");
                String[] actors = getStringActor(jsonActors);

                rtMovies =  getMoreDetails(url,actors,title,storyline,id);
                rtMovieList.add(rtMovies);
            }

        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return rtMovieList;
    }

    private RottenTomatoesObject getMoreDetails(String url, String[] actors, String title, String storyline,long id) throws Exception
    {
        RottenTomatoesObject rtobject = null;

        try
        {
            Connection connection = Jsoup.connect(DOMAIN+url);
            connection.userAgent("Mozilla/5.0");
            Document docs = connection.get();


            String[] director = null;
            String[] genre = null;
            String date = null;
            String length = null;

            int infoSize = docs.getElementsByClass("info").select("div").size();
//
            for (int i = 1; i < infoSize; i=i+2)
            {
                String tag = docs.getElementsByClass("info").select("div").get(i).text();
                if (tag.equals("Directed By:"))
                    director = getDirectors(docs.getElementsByClass("info").select("div").get(i + 1).text());
                else if (tag.equals("In Theaters:"))
                    date = getDate(docs.getElementsByClass("info").select("div").get(i + 1).text());
                else if (tag.equals("Runtime:"))
                    length = getDuration(docs.getElementsByClass("info").select("div").get(i + 1).text());
                else if (tag.equals("Genre:"))
                    genre = getGenre(docs.getElementsByClass("info").select("div").get(i + 1).text());
            }

            ArrayList<String> reviews = getReviews(docs);

            rtobject = new RottenTomatoesObject(id,title,date,length,storyline, genre,director, actors,"",reviews);


        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return rtobject;
    }

    private ArrayList<String> getReviews(Document docs)
    {
        ArrayList<String> reviewLst = new ArrayList<>();

        Elements reviewList = docs.getElementById("reviews").getElementsByClass("media-body").select("p");
        for (Element review : reviewList)
        {
            reviewLst.add(review.text());
        }
        return reviewLst;
    }

    private String[] getStringActor(JSONArray actors)
    {
        String[] acts = new String[actors.size()];
        for (int i = 0; i< actors.size(); i ++)
        {
            acts[i] = actors.get(i).toString();
        }
        return acts;
    }
    private String[] getDirectors(String dirs)
    {
        String[] directors = dirs.split(",");
        return directors;

    }

    private String getDuration(String lengthtxt)
    {
        String duration = lengthtxt.replace(" minutes","");
        return duration;
    }

    private String getDate(String dt)
    {
        String[] dateString = dt.split(",");
        String date = dateString[1].substring(0,5);
        return date;
    }

    private String[] getGenre(String gens)
    {
        String[] genres = gens.split(",");
        return genres;

    }


}
