package phone.safe.lx.com.safephone.comunication;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import phone.safe.lx.com.safephone.gps.GpsHandler;
import phone.safe.lx.com.safephone.gps.LocationHandler;
import phone.safe.lx.com.safephone.utils.DateUtils;
import phone.safe.lx.com.safephone.utils.WifiUtils;

public class ShareData {

	private static final String TAG = "ShareData";
    public static boolean sendLocation = false;

    public static void shareLocation(Location location, Context context) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        String macAddress = getMacAddress(context);
        DatabaseReference currentLocationRef = database.getReference("deviceData/" + macAddress + "/location");
        DatabaseReference navigationRef = database.getReference("deviceData/" + macAddress + "/navigation/" + DateUtils.getCurrentDate());

        currentLocationRef.setValue(getLocationMap(location, true));
        navigationRef.push().setValue(getLocationMap(location, false));
    }	

    private static String getMacAddress(Context context) {
    	return WifiUtils.getMacAddress(context);
    }

    private static Map getLocationMap(Location location, boolean fullDate) {
        String dateKey = fullDate ? "date" : "time";
        String dateValue = fullDate ? DateUtils.getCurrentDateAndTime() : DateUtils.getCurrentTime();

        Map<String, Object> locationMap = new HashMap<String, Object>();
        locationMap.put("latitude", location.getLatitude());
        locationMap.put("longitude", location.getLongitude());
        locationMap.put(dateKey, dateValue);
        return locationMap;
    }

    public static void retrieveData(final Context context) {
        String macAddress = getMacAddress(context);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myDeviceRef = database.getReference("deviceData/" + macAddress + "/manageActions");
        // Read from the database
        myDeviceRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                Map<String, Object> value = (Map<String, Object>) dataSnapshot.getValue();

                if((Boolean) value.get("reportedAsLost")) {
                    Log.d(TAG, "Reported as lost");
                    initLocalizationProccess(context);
                } else {
                    Log.d(TAG, "Apagar gps");
                    turnOffGPS(context);
                    //verificar el estado anterior, si estubo en false no hacer nada
                }
//                sendLocation =  (Boolean) value.get("reportedAsLost");

                if((Boolean) value.get("toRing")) {
                    Log.d(TAG, "To ring phone");
//hacer sonar
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

    }

    private static void initLocalizationProccess(Context context) {
        GpsHandler gpsHandler = new GpsHandler(context);
        gpsHandler.turnGPSOnRoot();
        LocationHandler locationHandler = new LocationHandler(context);
        locationHandler.getLocation();
    }

    private static void turnOffGPS(Context context) {
        GpsHandler gpsHandler = new GpsHandler(context);
        gpsHandler.turnGPSOffRoot();
    }

}
