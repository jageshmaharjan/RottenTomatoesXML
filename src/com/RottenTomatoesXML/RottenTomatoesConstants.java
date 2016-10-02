package com.RottenTomatoesXML;

/**
 * Created by jugs on 16-9-22.
 */
public interface RottenTomatoesConstants
{
    //public String MOVIEURL = "https://www.rottentomatoes.com/browse/dvd-all/?services=amazon;amazon_prime;flixster;hbo_go;itunes;netflix_iw;vudu";
    public String DOMAIN = "https://www.rottentomatoes.com";

    public int STARTPAGE = 13;
    public int ENDPAGE = 5;
    public String JSONURL1 = "https://www.rottentomatoes.com/api/private/v1.0/m/list/find?page=";
    public String JSONURL2 = "&limit=500&type=dvd-all&services=amazon%3Bamazon_prime%3Bflixster%3Bhbo_go%3Bitunes%3Bnetflix_iw%3Bvudu&sortBy=release";


}