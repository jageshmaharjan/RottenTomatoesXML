package com.example;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.IOException;

/**
 * Created by jugs on 9/29/16.
 */
public class TextTag
{
    public static void main(String[] args) throws ClassNotFoundException, IOException
    {
        MaxentTagger tagger = new MaxentTagger("tagger/left3words-wsj-0-18.tagger");

        // The sample string
        String sample = "President of China visited to USA to extend the bilateral relationship between two countries";

        // The tagged string
        String tagged = tagger.tagString(sample);

        // Output the result
        System.out.println(tagged);

    }
}
