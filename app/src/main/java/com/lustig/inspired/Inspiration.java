package com.lustig.inspired;

import android.graphics.Color;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Inspiration {

    private final String T = "MichaelLustig";

    private int mBackgroundColor = Color.parseColor("#00000000");
    private String mInspiration = "";

    /**
     * ArrayList of mInspirations. Facts may repeat.
     */
    private ArrayList<String> mInspirations = new ArrayList<String>(
            Arrays.<String>asList(
                    "Hooray! You figured out how to do this!",
                    "You should probably practice OOP techniques on this project.",
                    "One day are you going to work at Google?",
                    "Keep coding and one day you'll be great!",
                    "Work until you don't have to introduce yourself.",
                    "You need to take care of getting your interview stuff tomorrow (Thursday)",
                    "You also need to figure out how to automate MuPDF for Martin",
                    "Get all of your homework done in advance, don't be a dummy!"

            )
    );

    /**
     * ArrayList of mBackgroundColors. Colors may repeat
     */
    private ArrayList<String> mBackgroundColors = new ArrayList<String>(
            Arrays.asList(
                    "#39add1",   // 1)  light blue
                    "#3079ab",   // 2)  dark blue
                    "#c25975",   // 3)  mauve
                    "#e15258",   // 4)  red
                    "#f9845b",   // 5)  orange
                    "#838cc7",   // 6)  lavender
                    "#7d669e",   // 7)  purple
                    "#53bbb4",   // 8)  aqua
                    "#51b46d",   // 9)  green
                    "#e0ab18",   // 10) mustard
                    "#637a91",   // 11) dark gray
                    "#f092b0",   // 12) pink
                    "#b7c0c7"    // 13) light gray
            )

    );


    /**
     * I ended up just going with a random number a fact pick in the constructor.
     * This way, the code just calls the constructor in some kind of loop and
     * the randomness is taken care of by this class.
     */
    public Inspiration() {



    }

    public Inspiration getNextQuote() {

        Random r = new Random();

        int quoteIndex = r.nextInt(mInspirations.size());

        Log.i(T, "quoteIndex: " + quoteIndex);
        Log.i(T, "Before getting quote, mInspirations size at " + mInspirations.size());

        mInspiration = mInspirations.get(quoteIndex);

        Log.i(T, "Fact picked, removing : " + quoteIndex + " from mInspirations");

        int colorIndex = r.nextInt(mBackgroundColors.size());

        /* Grab a color and make sure it is removed from the list */
        mBackgroundColor =
                Color.parseColor(
                        mBackgroundColors.get(colorIndex)
                );

        Inspiration inspiration = new Inspiration();

        return inspiration;

    }

    public String getQuote() {
        return mInspiration;
    }

    public int getColor() {
        return mBackgroundColor;
    }
}
