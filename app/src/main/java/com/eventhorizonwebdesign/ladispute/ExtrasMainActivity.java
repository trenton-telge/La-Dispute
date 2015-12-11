package com.eventhorizonwebdesign.ladispute;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class ExtrasMainActivity extends AppCompatActivity {
    protected SharedPreferences settings = getApplicationContext().getSharedPreferences(MainActivity.PREFS_NAME, 0);
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
        final Switch notificationSwitch = (Switch)findViewById(R.id.notificationsSwitch);
        notificationSwitch.setChecked(settings.getBoolean("notify", false));
        notificationSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("notify", notificationSwitch.isChecked());
                // Commit the edits!
                editor.apply();
            }
        });
        final EditText zipField = (EditText)findViewById(R.id.zipcode);
        if (!((MainActivity.lastZip == null) || (MainActivity.lastZip.equals("")) || (MainActivity.lastZip.equals("0")))){
            zipField.setText(MainActivity.lastZip);
        }
        zipField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("zip", zipField.getText().toString());
                editor.putBoolean("manualZip", true);
                // Commit the edits!
                editor.apply();
                return false;
            }
        });
    }


}
