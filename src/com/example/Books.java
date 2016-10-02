package com.example;

/**
 * Created by jugs on 9/29/16.
 */
public class Books
{
    private String title;
    private String author;
    private String publisher;
    public String[] coauthor;

    public Books(String title, String author, String publisher,String[] coauthor)
    {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.coauthor = coauthor;
    }

    public String[] getCoauthor() {
        return coauthor;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
