package phone.safe.lx.com.safephone.comunication;

import android.location.Location;
import android.telephony.TelephonyManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by luis on 8/25/17.
 */

public class ShareData {

    public static void shareLocation(Location location) {

//        final TelephonyManager tm = (TelephonyManager) getBaseContext().getSystemService(Context.TELEPHONY_SERVICE);
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference latitudeRef = database.getReference("my-emai/latitue");
        DatabaseReference longitudeRef = database.getReference("my-emai/longitude");
        System.out.println("saving location on firebase");
        latitudeRef.setValue(location.getLatitude());
        longitudeRef.setValue(location.getLongitude());
    }
}
