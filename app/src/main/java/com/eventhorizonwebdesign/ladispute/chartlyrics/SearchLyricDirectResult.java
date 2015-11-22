package com.eventhorizonwebdesign.ladispute.chartlyrics;

import pt.joaocruz04.lib.annotations.JSoapClass;
import pt.joaocruz04.lib.annotations.JSoapResField;
import pt.joaocruz04.lib.misc.SOAPDeserializable;

/**
 * Created by Trenton on 11/16/2015.
 *
 * Result object for ChartLyrics SOAP API
 */
public class SearchLyricDirectResult extends SOAPDeserializable {

    @JSoapClass(namespace = "http://api.chartlyrics.com/")
    public class MyReply extends SOAPDeserializable {

        @JSoapResField(name = "TrackChecksum")
        private String trackChecksum;

        @JSoapResField(name = "TrackId")
        private String trackId;

        @JSoapResField(name = "LyricChecksum")
        private String lyricChecksum;

        @JSoapResField(name = "LyricId")
        private String lyricId;

        @JSoapResField(name = "LyricSong")
        private String lyricSong;

        @JSoapResField(name = "LyricArtist")
        private String lyricArtist;

        @JSoapResField(name = "LyricUrl")
        private String lyricUrl;

        @JSoapResField(name = "LyricCoverArtUrl")
        private String lyricCoverArtUrl;

        @JSoapResField(name = "LyricRank")
        private String lyricRank;

        @JSoapResField(name = "LyricCorrectUrl")
        private String lyricCorrectUrl;

        @JSoapResField(name = "Lyric")
        private String lyric;

        public String getLyric(){
            return lyric;
        }
    }
}
