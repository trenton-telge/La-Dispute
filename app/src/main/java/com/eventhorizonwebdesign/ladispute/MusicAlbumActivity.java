package com.eventhorizonwebdesign.ladispute;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;


public class MusicAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_album);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bitmap coverBitmap = null;
        String tracksText = "";

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                switch (extras.getString("EXTRA_ALBUM_NAME")) {
                    case "Vancouver":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.vancouver);
                        tracksText = getString(R.string.tracklisting_vancouver);
                        break;
                    case "Somewhere At The Bottom":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.satbotrbvaa);
                        tracksText = getString(R.string.tracklisting_satbotrbvaa);
                        break;
                    case "Wildlife":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.wildlife);
                        tracksText = getString(R.string.tracklisting_wildlife);
                        break;
                    case "Rooms Of The House":
                        coverBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
                        tracksText = getString(R.string.tracklisting_rooms);
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

        TextView tracklist = (TextView)findViewById(R.id.tracklisting);
        tracklist.setText(tracksText);
    }

}
