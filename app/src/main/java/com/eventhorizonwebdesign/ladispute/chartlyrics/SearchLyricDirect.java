package com.eventhorizonwebdesign.ladispute.chartlyrics;

/**
 * Created by Trenton on 11/16/2015.
 *
 * Request object for ChartLyrics SOAP API
 */


import pt.joaocruz04.lib.annotations.JSoapClass;
import pt.joaocruz04.lib.annotations.JSoapReqField;
import pt.joaocruz04.lib.misc.SOAPSerializable;

@JSoapClass(namespace = "http://api.chartlyrics.com/")
public class SearchLyricDirect extends SOAPSerializable {

    @JSoapReqField(order = 0)
    private String artist;

    @JSoapReqField(order = 1)
    private String song;

    public SearchLyricDirect(String artist, String song) {
        this.artist = artist;
        this.song = song;
    }

}
