package phone.safe.lx.com.safephone.gps;

import phone.safe.lx.com.safephone.utils.RunCommands;

public class GpsHandler {

    // automatic turn off the gps
    public void turnGPSOn() {
        String grantPermissions = "pm grant com.your_app_packagename android.permission.WRITE_SECURE_SETTINGS";
        String activeGps = "settings put secure location_providers_allowed gps,network,wifi";
        String[] cmds = {grantPermissions, activeGps};
        RunCommands.asRoot(cmds);
        System.out.println("GPS encendido");
    }
    // automatic turn off the gps
    public void turnGPSOff() {
        String grantPermissions  = "pm grant com.your_app_packagename android.permission.WRITE_SECURE_SETTINGS";
        String offGps = "settings put secure location_providers_allowed ''";
        String[] cmds = {grantPermissions, offGps};
        RunCommands.asRoot(cmds);
    }
}
