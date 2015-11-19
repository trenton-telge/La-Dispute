package com.eventhorizonwebdesign.ladispute;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import pt.joaocruz04.lib.SOAPManager;
import pt.joaocruz04.lib.misc.JSoapCallback;
import pt.joaocruz04.lib.misc.JsoapError;

public class LyricActivity extends AppCompatActivity {
    private static TextView lyricsView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyric);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lyricsView = (TextView) findViewById(R.id.lyricPane);
        getlyricText();
    }
    private static void setLyricPaneText(String text){
        lyricsView.setText(text);
    }
    private static void getlyricText() {
        String url="http://www.chartlyrics.com/api.aspx";
        String namespace="http://api.chartlyrics.com/";
        String method = "SearchLyricDirect";
        String soap_action = "http://api.chartlyrics.com/SearchLyricDirect";

        SOAPManager.get(namespace, url, method, soap_action, new SearchLyricDirect("La Dispute", MainActivity.songTitle), SearchLyricDirectResult.MyReply.class, new JSoapCallback() {

            @Override
            public void onSuccess(Object result) {
                SearchLyricDirectResult.MyReply res = (SearchLyricDirectResult.MyReply) result;
                setLyricPaneText(res.getLyric());

            }

            @Override
            public void onError(int error) {
                switch (error) {
                    case JsoapError.NETWORK_ERROR:
                        break;
                    case JsoapError.PARSE_ERROR:
                        break;
                    default:
                        break;
                }
            }
        });

    }

}
