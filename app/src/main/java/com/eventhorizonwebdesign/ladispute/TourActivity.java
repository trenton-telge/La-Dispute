package com.eventhorizonwebdesign.ladispute;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class TourActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final WebView webview=(WebView)findViewById(R.id.tourView);
        final ProgressBar webProgress = (ProgressBar) findViewById(R.id.webProgress);
        webview.clearCache(true);
        webview.clearHistory();
        webview.getSettings().setAppCacheEnabled(false);
        webview.getSettings();
        webview.setBackgroundColor(0);
        if (isNetworkAvailable(getApplicationContext())){
            webview.setWebViewClient(new WebViewClient(){
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    if (url != null) {
                        view.getContext().startActivity(
                                new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                        return true;
                    } else {
                        return false;
                    }
                }
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    webProgress.setVisibility(View.VISIBLE);
                    webProgress.setProgress(0);
                }
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    webview.setVisibility(View.INVISIBLE);
                }
            });
            webview.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onProgressChanged(WebView view, int newProgress) {
                    if (newProgress <= 5) {
                        webProgress.setProgress(5);
                    } else if (newProgress >= 95) {
                        webProgress.setVisibility(View.INVISIBLE);
                    } else {
                        webProgress.setProgress(newProgress);
                    }
                    super.onProgressChanged(view, newProgress);
                }
            });
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl(getString(R.string.url_tourinfo));
        } else Toast.makeText(getApplicationContext(), getString(R.string.toast_noweb), Toast.LENGTH_LONG).show();
    }
    protected static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }
}
