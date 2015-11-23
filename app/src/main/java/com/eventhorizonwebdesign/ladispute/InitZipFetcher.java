package com.eventhorizonwebdesign.ladispute;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


/**
 * Created by Trenton on 11/21/2015.
 */
public class InitZipFetcher extends AsyncTask<Void, Integer, Integer> {


    protected Integer doInBackground(Void... v) {
        try {
            LocationManager lm = (LocationManager) MainActivity.context.getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            double lng = location.getLongitude();
            double lat = location.getLatitude();
            Geocoder geocoder = new Geocoder(MainActivity.context, Locale.getDefault());
            List<Address> addresses = geocoder.getFromLocation(lat, lng, 1);
            MainActivity.lastZip = addresses.get(0).getPostalCode();
        } catch (SecurityException e){
            //TODO error for no GPS permissions
            return 1;
        } catch (IOException e){
            //TODO error for IOException
            return 1;
        } catch (NullPointerException e){
            //TODO delay and retry
            return 1;
        }
        return 0;
    }

    protected void onProgressUpdate() {

    }

    protected void onPostExecute() {

    }
}
