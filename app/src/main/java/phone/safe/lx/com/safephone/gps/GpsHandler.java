package phone.safe.lx.com.safephone.gps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import phone.safe.lx.com.safephone.HideActivity;

/**
 * Created by luis on 8/24/17.
 */

public class GpsHandler {

    private Context ctx = null;



    public GpsHandler() {
//        HideActivity activity = new HideActivity();
//        this.ctx = activity.getBaseContext();
//        this.ctx = context;
//        System.out.println("context setted");
    }

    public void turnGPSOn() {
        try {
            String comand  = "pm grant com.your_app_packagename android.permission.WRITE_SECURE_SETTINGS";
            System.out.println(comand);
            String activeGps = "settings put secure location_providers_allowed gps,network,wifi";
            System.out.println(activeGps);
            Process proc = Runtime.getRuntime().exec(new String[]{"su", activeGps});
            proc.waitFor();
            System.out.println("gps encendido");
        } catch (Exception e) {
            System.out.println("error");
        }

//        Intent intent = new Intent("android.location.GPS_ENABLED_CHANGE");
//        intent.putExtra("enabled", true);
//        this.ctx.sendBroadcast(intent);
//
//        String provider = Settings.Secure.getString(this.ctx.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
//        if(!provider.contains("gps")){ //if gps is disabled
//            final Intent poke = new Intent();
//            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
//            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
//            poke.setData(Uri.parse("3"));
//            this.ctx.sendBroadcast(poke);
//
//        }
    }
    // automatic turn off the gps
    public void turnGPSOff() {
        String provider = Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
        if(provider.contains("gps")){ //if gps is enabled
            final Intent poke = new Intent();
            poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
            poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
            poke.setData(Uri.parse("3"));
            this.ctx.sendBroadcast(poke);
        }
    }

}
