package phone.safe.lx.com.safephone;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import phone.safe.lx.com.safephone.gps.GpsHandler;
import phone.safe.lx.com.safephone.gps.LocationHandler;

public class ServiceDemo extends Service {

    private static final String TAG = "Service";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onStart(Intent intent, int startId) {
        Log.d(TAG, "onStart");
        GpsHandler gpsHandler = new GpsHandler(this);
        gpsHandler.turnGPSOn();
        LocationHandler locationHandler = new LocationHandler(this);
        locationHandler.getLocation();
    }

    public void onDestroy() {
        Log.d(TAG, "onDestroy");
    }

}