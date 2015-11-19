package com.eventhorizonwebdesign.ladispute;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.widget.ImageButton;

public class MusicMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int viewport_width = size.x;
        int viewport_height = size.y;//unused as of now
        int albumdim = (int)((double)viewport_width-32-8-8-8)/2;
        ImageButton vancouverAlbum = (ImageButton)findViewById(R.id.vancouverAlbum);
        Bitmap albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vancouver);
        Bitmap resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
        vancouverAlbum.setImageBitmap(resizedAlbumBitmap);
        ImageButton satbotrbvaaAlbum = (ImageButton)findViewById(R.id.satbotrbvaaAlbum);
        albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.satbotrbvaa);
        resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
        satbotrbvaaAlbum.setImageBitmap(resizedAlbumBitmap);
        ImageButton wildlifeAlbum = (ImageButton)findViewById(R.id.wildlifeAlbum);
        albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wildlife);
        resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
        wildlifeAlbum.setImageBitmap(resizedAlbumBitmap);
        ImageButton roomsAlbum = (ImageButton)findViewById(R.id.roomsAlbum);
        albumBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
        resizedAlbumBitmap = Bitmap.createScaledBitmap(albumBitmap, albumdim, albumdim, true);
        roomsAlbum.setImageBitmap(resizedAlbumBitmap);
    }

}
