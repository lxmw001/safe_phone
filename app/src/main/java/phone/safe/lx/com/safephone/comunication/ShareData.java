package phone.safe.lx.com.safephone.comunication;

import android.content.Context;
import android.location.Location;
import android.telephony.TelephonyManager;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import phone.safe.lx.com.safephone.utils.WifiUtils;

public class ShareData {

	private static final String TAG = "ShareData";	

    public static void shareLocation(Location location, Context context) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String macAddress = getMacAddress(context) + "/";
        DatabaseReference latitudeRef = database.getReference(macAddress + "latitue");
        DatabaseReference longitudeRef = database.getReference(macAddress + "longitude");
        System.out.println("saving location on firebase");
        latitudeRef.setValue(location.getLatitude());
        longitudeRef.setValue(location.getLongitude());
    }	

    public static String getMacAddress(Context context) {
    	return WifiUtils.getMacAddress(context);
    }    
}
