package com.eventhorizonwebdesign.ladispute;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    protected static String lastZip = "";
    protected static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);

        //Try and get the zip code from the last GPS location
        new InitZipFetcher().execute();

        //Display footer image
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int viewport_width = size.x;
        int viewport_height = size.y;//unused as of now
        ImageView footerImage = (ImageView)findViewById(R.id.footerImage);
        Bitmap footerBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.footer);
        double bitmapAspectRatio = (double)footerBitmap.getHeight()/(double)footerBitmap.getWidth();
        Bitmap resizedFooterBitmap = Bitmap.createScaledBitmap(footerBitmap, viewport_width, (int)(viewport_width*bitmapAspectRatio), true);
        footerImage.setImageBitmap(resizedFooterBitmap);

        //Make the social links work
        ImageView officialSiteSocial = (ImageView)findViewById(R.id.socialLaDispute);
        officialSiteSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_officialsite)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        ImageView redditSocial = (ImageView)findViewById(R.id.socialSubreddit);
        redditSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_reddit)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
        ImageView facebookSocial = (ImageView)findViewById(R.id.socialFacebook);
        facebookSocial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_facebook)));
                    startActivity(myIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        TextView tourRoom = (TextView)findViewById(R.id.roomTour);
        tourRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TourActivity.class);
                startActivity(intent);
            }
        });
        TextView musicRoom = (TextView)findViewById(R.id.roomMusic);
        musicRoom.setWidth((int) ((double) viewport_width * .3));
        musicRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MusicMainActivity.class);
                startActivity(intent);
            }
        });
        TextView lyricsRoom = (TextView)findViewById(R.id.roomLyrics);
        lyricsRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LyricSorter.class);
                startActivity(intent);
            }
        });
        TextView merchRoom = (TextView)findViewById(R.id.roomStore);
        merchRoom.setWidth((int)((double)viewport_width*.35));
        merchRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    switch (getUserCountry(getApplicationContext())){
                        case "UK":
                        case "AF":
                        case "IN":
                        case "IL":
                        case "JO":
                        case "LB":
                        case "TR":
                        case "VN":
                        case "AT":
                        case "BY":
                        case "BE":
                        case "HR":
                        case "CZ":
                        case "DK":
                        case "EE":
                        case "FI":
                        case "FR":
                        case "DE":
                        case "GR":
                        case "HU":
                        case "IS":
                        case "IE":
                        case "IT":
                        case "LT":
                        case "LU":
                        case "MC":
                        case "NL":
                        case "NO":
                        case "PL":
                        case "PT":
                        case "RO":
                        case "RU":
                        case "ES":
                        case "SE":
                        case "CH":
                        case "UA":
                        case "GB":
                        case "VA":
                        case "ME":
                            try {
                                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_store_europe)));
                                startActivity(myIntent);
                            } catch (ActivityNotFoundException e) {
                                Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                            break;
                        case "AU":
                        case "PG":
                        case "CN":
                        case "KJ":
                        case "JP":
                        case "KR":
                        case "PH":
                        case "SG":
                        case "AE":
                        case "HK":
                            try {
                                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_store_asia)));
                                startActivity(myIntent);
                            } catch (ActivityNotFoundException e) {
                                Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                            break;
                        default:
                            try {
                                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_store_america)));
                                startActivity(myIntent);
                            } catch (ActivityNotFoundException e) {
                                Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                                e.printStackTrace();
                            }
                            break;
                    }
                } catch (NullPointerException e){
                    try {
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.url_store_america)));
                        startActivity(myIntent);
                    } catch (ActivityNotFoundException e1) {
                        Toast.makeText(getApplicationContext(), getString(R.string.toast_nobrowser),  Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }

            }
        });
        TextView extrasRoom = (TextView)findViewById(R.id.roomExtras);
        //TODO Make ExtrasActivity

    }
    public static String getUserCountry(Context context) {
        try {
            final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            final String simCountry = tm.getSimCountryIso();
            if (simCountry != null && simCountry.length() == 2) { // SIM country code is available
                return simCountry.toLowerCase(Locale.US);
            }
            else if (tm.getPhoneType() != TelephonyManager.PHONE_TYPE_CDMA) { // device is not 3G (would be unreliable)
                String networkCountry = tm.getNetworkCountryIso();
                if (networkCountry != null && networkCountry.length() == 2) { // network country code is available
                    return networkCountry.toLowerCase(Locale.US);
                }
            }
        }
        catch (Exception e) {
            return "";
        }
        return "";
    }


}
