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
        DatabaseReference currentLocationRef = database.getReference("deviceData/" + macAddress + "/location");
        DatabaseReference navigationRef = database.getReference("deviceData/" + macAddress + "/navigation/" + DateUtils.getCurrentDate());

        currentLocationRef.setValue(getLocationMap(location));
        navigationRef.push().setValue(getLocationMap(location));
    }	

    private static String getMacAddress(Context context) {
    	return WifiUtils.getMacAddress(context);
    }

    private static Map getLocationMap(Location location) {
        Map<String, Object> locationMap = new HashMap<String, Object>();
        locationMap.put("latitude", location.getLatitude());
        locationMap.put("longitude", location.getLongitude());
        locationMap.put("date", DateUtils.getCurrentDateAndTime());
        return locationMap;
    }
}
