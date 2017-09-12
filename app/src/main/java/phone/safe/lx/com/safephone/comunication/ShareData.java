package phone.safe.lx.com.safephone.comunication;

import android.content.Context;
import android.location.Location;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import phone.safe.lx.com.safephone.utils.DateUtils;
import phone.safe.lx.com.safephone.utils.WifiUtils;

public class ShareData {

	private static final String TAG = "ShareData";	

    public static void shareLocation(Location location, Context context) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String macAddress = getMacAddress(context);
        DatabaseReference latitudeRef = database.getReference("deviceData/" + macAddress + "/location/latitude");
        DatabaseReference longitudeRef = database.getReference("deviceData/" + macAddress + "/location/longitude");
        DatabaseReference navigationRef = database.getReference("deviceData/" + macAddress + "/navigation/" + DateUtils.getCurrentDate());
        DatabaseReference dateRef = database.getReference("deviceData/" + macAddress + "/location/date");
        System.out.println("saving location on firebase");
        latitudeRef.setValue(location.getLatitude());
        longitudeRef.setValue(location.getLongitude());
        dateRef.setValue(DateUtils.getCurrentDateAndTime());
        navigationRef.push().setValue(getLocationMap(location));

    }	

    private static String getMacAddress(Context context) {
    	return WifiUtils.getMacAddress(context);
    }

    private static Map getLocationMap(Location location) {
        Map<String, Double> locationMap = new HashMap<String, Double>();
        locationMap.put("latitude", location.getLatitude());
        locationMap.put("longitude", location.getLongitude());
        return locationMap;
    }
}
