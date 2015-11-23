package com.eventhorizonwebdesign.ladispute;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;

public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ImageButton vancouverAlbum = (ImageButton)findViewById(R.id.vancouverAlbum);
        ViewTreeObserver observer = vancouverAlbum.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int albumdim = vancouverAlbum.getWidth()-8;
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
        ImageButton playButton = (ImageButton)findViewById(R.id.playButton);
        Bitmap playBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.playthisselection);
        double ratio = (double)playBitmap.getHeight()/(double)playBitmap.getWidth();
        Bitmap resizedPlayBitmap = Bitmap.createScaledBitmap(playBitmap, (int)200, (int)(200*ratio), true);
        playButton.setImageBitmap(resizedPlayBitmap);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String artist = getString(R.string.app_name);
                Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
                intent.putExtra(MediaStore.EXTRA_MEDIA_FOCUS, MediaStore.Audio.Artists.ENTRY_CONTENT_TYPE);
                intent.putExtra(MediaStore.EXTRA_MEDIA_ARTIST, artist);
                intent.putExtra(SearchManager.QUERY, artist);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }

}
