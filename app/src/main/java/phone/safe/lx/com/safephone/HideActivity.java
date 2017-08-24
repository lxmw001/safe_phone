package phone.safe.lx.com.safephone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import phone.safe.lx.com.safephone.gps.GpsHandler;

/**
 * Created by luis on 8/23/17.
 */

public class HideActivity extends Activity {
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        startService(new Intent(this, ServiceDemo.class));
        Toast.makeText(getBaseContext(), "Hello........", Toast.LENGTH_LONG).show();
//        this.finish();
//        GpsHandler gpsHandler = new GpsHandler(this);
//        gpsHandler.turnGPSOn();

    }
}
