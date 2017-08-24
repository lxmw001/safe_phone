package phone.safe.lx.com.safephone;

/**
 * Created by luis on 8/23/17.
 */

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import phone.safe.lx.com.safephone.gps.GpsHandler;

public class ServiceDemo extends Service {

    private static final String TAG = "MyService";

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onStart(Intent intent, int startId) {
        System.out.println("hola");
//        Intent intents = new Intent(getBaseContext(),HideActivity.class);
//        intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intents);
        Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        GpsHandler gpsHandler = new GpsHandler();
        gpsHandler.turnGPSOn();
    }

    public void onDestroy() {
        System.out.println("stop");
        Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
    }

}