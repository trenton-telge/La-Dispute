package com.eventhorizonwebdesign.ladispute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class LyricActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String songTitle = getIntent().getExtras().getString("SONG_TITLE");
        if (songTitle == null){songTitle = "";}
        TextView lyricsView = (TextView) findViewById(R.id.lyricPane);
        if (songTitle.equals(getString(R.string.song_vancouver_1))){lyricsView.setText(R.string.lyrics_vancouver_1);}
        else if (songTitle.equals(getString(R.string.song_vancouver_2))){lyricsView.setText(R.string.lyrics_vancouver_2);}
        else if (songTitle.equals(getString(R.string.song_vancouver_3))){lyricsView.setText(R.string.lyrics_vancouver_3);}
        else if (songTitle.equals(getString(R.string.song_vancouver_4))){lyricsView.setText(R.string.lyrics_vancouver_4);}
        else if (songTitle.equals(getString(R.string.song_vancouver_5))){lyricsView.setText(R.string.lyrics_vancouver_5);}
        else if (songTitle.equals(getString(R.string.song_vancouver_6))){lyricsView.setText(R.string.lyrics_vancouver_6);}
        else if (songTitle.equals(getString(R.string.song_vancouver_7))){lyricsView.setText(R.string.lyrics_vancouver_7);}
        else if (songTitle.equals(getString(R.string.song_vancouver_8))){lyricsView.setText(R.string.lyrics_vancouver_8);}

        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_1))){lyricsView.setText(R.string.lyrics_satbotrbvaa_1);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_2))){lyricsView.setText(R.string.lyrics_satbotrbvaa_2);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_3))){lyricsView.setText(R.string.lyrics_satbotrbvaa_3);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_4))){lyricsView.setText(R.string.lyrics_satbotrbvaa_4);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_5))){lyricsView.setText(R.string.lyrics_satbotrbvaa_5);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_6))){lyricsView.setText(R.string.lyrics_satbotrbvaa_6);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_7))){lyricsView.setText(R.string.lyrics_satbotrbvaa_7);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_8))){lyricsView.setText(R.string.lyrics_satbotrbvaa_8);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_9))){lyricsView.setText(R.string.lyrics_satbotrbvaa_9);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_10))){lyricsView.setText(R.string.lyrics_satbotrbvaa_10);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_11))){lyricsView.setText(R.string.lyrics_satbotrbvaa_11);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_12))){lyricsView.setText(R.string.lyrics_satbotrbvaa_12);}
        else if (songTitle.equals(getString(R.string.song_satbotrbvaa_13))){lyricsView.setText(R.string.lyrics_satbotrbvaa_13);}

        else if (songTitle.equals(getString(R.string.song_wildlife_1))){lyricsView.setText(R.string.lyrics_wildlife_1);}
        else if (songTitle.equals(getString(R.string.song_wildlife_2))){lyricsView.setText(R.string.lyrics_wildlife_2);}
        else if (songTitle.equals(getString(R.string.song_wildlife_3))){lyricsView.setText(R.string.lyrics_wildlife_3);}
        else if (songTitle.equals(getString(R.string.song_wildlife_4))){lyricsView.setText(R.string.lyrics_wildlife_4);}
        else if (songTitle.equals(getString(R.string.song_wildlife_5))){lyricsView.setText(R.string.lyrics_wildlife_5);}
        else if (songTitle.equals(getString(R.string.song_wildlife_6))){lyricsView.setText(R.string.lyrics_wildlife_6);}
        else if (songTitle.equals(getString(R.string.song_wildlife_7))){lyricsView.setText(R.string.lyrics_wildlife_7);}
        else if (songTitle.equals(getString(R.string.song_wildlife_8))){lyricsView.setText(R.string.lyrics_wildlife_8);}
        else if (songTitle.equals(getString(R.string.song_wildlife_9))){lyricsView.setText(R.string.lyrics_wildlife_9);}
        else if (songTitle.equals(getString(R.string.song_wildlife_10))){lyricsView.setText(R.string.lyrics_wildlife_10);}
        else if (songTitle.equals(getString(R.string.song_wildlife_11))){lyricsView.setText(R.string.lyrics_wildlife_11);}
        else if (songTitle.equals(getString(R.string.song_wildlife_12))){lyricsView.setText(R.string.lyrics_wildlife_12);}
        else if (songTitle.equals(getString(R.string.song_wildlife_13))){lyricsView.setText(R.string.lyrics_wildlife_13);}
        else if (songTitle.equals(getString(R.string.song_wildlife_14))){lyricsView.setText(R.string.lyrics_wildlife_14);}

    }


}
