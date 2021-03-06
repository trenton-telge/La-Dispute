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
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.Toast;

import com.readystatesoftware.systembartint.SystemBarTintManager;

public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // create our manager instance after the content view is set
        SystemBarTintManager tintManager = new SystemBarTintManager(this);
        // enable status bar tint
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setTintColor(Color.parseColor("#FF606476"));

        final ImageButton vancouverAlbum = (ImageButton)findViewById(R.id.vancouverAlbum);
        ViewTreeObserver observer = vancouverAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = vancouverAlbum.getWidth() - 8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vancouver);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                vancouverAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        vancouverAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Vancouver");
                startActivity(intent);
            }
        });
        final ImageButton satbotrbvaaAlbum = (ImageButton)findViewById(R.id.satbotrbvaaAlbum);
        observer = satbotrbvaaAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = satbotrbvaaAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.satbotrbvaa);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                satbotrbvaaAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        satbotrbvaaAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Somewhere At The Bottom");
                startActivity(intent);
            }
        });
        final ImageButton wildlifeAlbum = (ImageButton)findViewById(R.id.wildlifeAlbum);
        observer = wildlifeAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = wildlifeAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wildlife);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                wildlifeAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        wildlifeAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Wildlife");
                startActivity(intent);
            }
        });
        final ImageButton roomsAlbum = (ImageButton)findViewById(R.id.roomsAlbum);
        observer = roomsAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = roomsAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                roomsAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        roomsAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Rooms Of The House");
                startActivity(intent);
            }
        });
        final ImageButton untitledAlbum = (ImageButton)findViewById(R.id.untitledAlbum);
        observer = untitledAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = untitledAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.untitled);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                untitledAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        untitledAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Untitled 7\"");
                startActivity(intent);
            }
        });
        final ImageButton herehearptoneAlbum = (ImageButton)findViewById(R.id.herehearptoneAlbum);
        observer = herehearptoneAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = herehearptoneAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh1);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                herehearptoneAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        herehearptoneAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Here, Hear I");
                startActivity(intent);
            }
        });
        final ImageButton herehearpttwoAlbum = (ImageButton)findViewById(R.id.herehearpttwoAlbum);
        observer = herehearpttwoAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = herehearpttwoAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh2);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                herehearpttwoAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        herehearpttwoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Here, Hear II");
                startActivity(intent);
            }
        });
        final ImageButton herehearptthreeAlbum = (ImageButton)findViewById(R.id.herehearptthreeAlbum);
        observer = herehearptthreeAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = herehearptthreeAlbum.getWidth()-8;
                Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hh3);
                Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
                herehearptthreeAlbum.setImageBitmap(resizedAlbumBitmap);
            }
        });
        herehearptthreeAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicAlbumActivity.class);
                intent.putExtra("EXTRA_ALBUM_NAME", "Here, Hear III");
                startActivity(intent);
            }
        });
        ImageButton playButton = (ImageButton)findViewById(R.id.playButton);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int viewport_width = size.x;
        int width = (int)((double)viewport_width*.3);
        Bitmap playBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.playthisselection);
        double ratio = (double)playBitmap.getHeight()/(double)playBitmap.getWidth();
        Bitmap resizedPlayBitmap = Bitmap.createScaledBitmap(playBitmap, width, (int)(ratio*(double)width), true);
        playButton.setImageBitmap(resizedPlayBitmap);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.isAppInstalled(getApplicationContext(), "com.google.android.music")) {
                    String artist = getString(R.string.app_name);
                    Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                    intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
                    intent.putExtra(SearchManager.QUERY, artist);
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
