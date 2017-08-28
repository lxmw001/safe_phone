package phone.safe.lx.com.safephone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AutoStart extends BroadcastReceiver {

	private static final String TAG = "AutoStartBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent myIntent = new Intent(context, ServiceDemo.class);
        context.startService(myIntent);
        Log.i(TAG, "started");
    }
}