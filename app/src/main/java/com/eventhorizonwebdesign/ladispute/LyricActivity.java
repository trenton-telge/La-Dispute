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

    }


}
