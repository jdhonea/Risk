//package com.risktakers.Risk;
import twitter4j.*;
import twitter4j.conf.*;

import java.io.*;
import java.util.*;

public class TwitterAPI
{
    // the object that holds the loaded properties
    private Properties prop = new Properties();

    // properties expected to be in the file
    private final String CONSUMER_KEY = "you-key";
    private final String CONSUMER_SECRET = "secret";
    private final String ACCESS_TOKEN = "token";
    private final String ACCESS_TOKEN_SECRET = "token-secret";

    // the singleton instance used for sending tweets
    Twitter twitter = null;

    // "secrets_RISK_TAKERS.prop"
    void loadPropertyFile( String filename )
    {
        BufferedReader input = null;
        try
        {
            // open file for reading
            input = new BufferedReader(new FileReader(filename));

            // load a properties file
            prop.load(input);

            // setup the configuration
            ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true)
                    .setOAuthConsumerKey(prop.getProperty(CONSUMER_KEY))
                    .setOAuthConsumerSecret(prop.getProperty(CONSUMER_SECRET))
                    .setOAuthAccessToken(prop.getProperty(ACCESS_TOKEN))
                    .setOAuthAccessTokenSecret(prop.getProperty(ACCESS_TOKEN_SECRET));

            // grab the twitter instance
            twitter = new TwitterFactory(cb.build()).getInstance();

        } catch ( FileNotFoundException ignored )
        {
            System.out.println("Sorry, unable to find file: " + filename);
        } catch ( IllegalArgumentException ignored )
        {
            System.out.println("Sorry, malformed characters in file: " + filename);
        } catch ( IOException ex )
        {
            System.out.println("Sorry, unknown error occurred when reading from file: " + filename);
            ex.printStackTrace();
        } finally
        {
            if ( input != null )
            {
                try
                {
                    input.close();
                } catch ( IOException e )
                {
                    System.out.println("Sorry, unknown error occurred when closing file: " + filename);
                    e.printStackTrace();
                }
            }
        }
    }

    public void sendTweet( String message ) throws TwitterException
    {
        Status status = twitter.updateStatus(message);
    }
}

// Post the number of territories conquered by each player on Twitter after each turn and at the end of the game.

