package phone.safe.lx.com.safephone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by luis on 8/23/17.
 */

public class AutoStart extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent myIntent = new Intent(context, ServiceDemo.class);
        context.startService(myIntent);
        System.out.println("hola");
        Log.i("Autostart", "started");
    }
}