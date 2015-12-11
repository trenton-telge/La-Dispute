package com.eventhorizonwebdesign.ladispute;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ExtrasMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView wallpapersRoom = (TextView)findViewById(R.id.wallpapers);
        wallpapersRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_wallpapers)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        TextView repoRoom = (TextView)findViewById(R.id.code);
        repoRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_repo)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        Switch notificationSwitch = (Switch)findViewById(R.id.notificationsSwitch);

        EditText zipField = (EditText)findViewById(R.id.zipcode);
        if (!((MainActivity.lastZip == null) || (MainActivity.lastZip.equals("")) || (MainActivity.lastZip.equals("0")))){
            zipField.setText(MainActivity.lastZip);
        }
    }


}
