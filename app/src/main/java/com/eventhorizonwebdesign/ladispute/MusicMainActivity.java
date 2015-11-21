package com.eventhorizonwebdesign.ladispute;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    }

}
