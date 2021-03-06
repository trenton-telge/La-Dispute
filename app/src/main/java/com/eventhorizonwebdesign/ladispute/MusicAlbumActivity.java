package com.eventhorizonwebdesign.ladispute;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;


public class MusicAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_album);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF606476"));

        Bitmap coverBitmap = null;
        String tracksText = "";
        String albumTitle = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                String album = extras.getString("EXTRA_ALBUM_NAME");
                if (album == null){album = "";}
                switch (album) {
                    case "Vancouver":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vancouver);
                        tracksText = getString(R.string.tracklisting_vancouver);
                        albumTitle = getString(R.string.album_vancouver);
                        break;
                    case "Somewhere At The Bottom":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.satbotrbvaa);
                        tracksText = getString(R.string.tracklisting_satbotrbvaa);
                        albumTitle = getString(R.string.album_satbotrbvaa_full);
                        break;
                    case "Wildlife":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wildlife);
                        tracksText = getString(R.string.tracklisting_wildlife);
                        albumTitle = getString(R.string.album_wildlife);
                        break;
                    case "Rooms Of The House":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
                        tracksText = getString(R.string.tracklisting_rooms);
                        albumTitle = getString(R.string.album_rooms);
                        break;
                    case "Untitled 7\"":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.untitled);
                        tracksText = getString(R.string.tracklisting_untitled);
                        albumTitle = getString(R.string.album_untitled);
                        break;
                    case "Here, Hear I":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh1);
                        tracksText = getString(R.string.tracklisting_herehearptone);
                        albumTitle = getString(R.string.album_herehearptone);
                        break;
                    case "Here, Hear II":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh2);
                        tracksText = getString(R.string.tracklisting_herehearpttwo);
                        albumTitle = getString(R.string.album_herehearpttwo);
                        break;
                    case "Here, Hear III":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh3);
                        tracksText = getString(R.string.tracklisting_herehearptthree);
                        albumTitle = getString(R.string.album_herehearptthree);
                        break;
                    default:
                        return;
                }
            } catch (NullPointerException e){
                Log.e("MusicAlbumActivity", "EXTRA_ALBUM_NAME not found", e);
            }
        }

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int viewport_width = size.x;
        int dim = (int)((double)viewport_width*.6);
        ImageView albumCover = (ImageView)findViewById(R.id.albumCover);
        Bitmap resizedCoverBitmap = Bitmap.createScaledBitmap(coverBitmap, dim, dim, true);
        albumCover.setImageBitmap(resizedCoverBitmap);

        TextView albumTitleView = (TextView)findViewById(R.id.albumTitle);
        albumTitleView.setText(albumTitle);

        TextView tracklist = (TextView)findViewById(R.id.tracklisting);
        tracklist.setText(tracksText);

        ImageButton playAlbumButton = (ImageButton)findViewById(R.id.playAlbumButton);
        int width = (int)((double)viewport_width*.3);
        Bitmap playBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.playthisselection);
        double ratio = (double)playBitmap.getHeight()/(double)playBitmap.getWidth();
        Bitmap resizedPlayBitmap = Bitmap.createScaledBitmap(playBitmap, width, (int)(ratio*(double)width), true);
        playAlbumButton.setImageBitmap(resizedPlayBitmap);
        final String album = albumTitle;
        playAlbumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isAppInstalled(getApplicationContext(), "com.google.android.music")) {
                    Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Albums.ENTRY_CONTENT_TYPE);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_ALBUM, album);
                    intent.putExtra(SearchManager.QUERY, album);
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nomusic), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
