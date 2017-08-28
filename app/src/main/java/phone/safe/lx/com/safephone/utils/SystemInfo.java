package phone.safe.lx.com.safephone.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

public class SystemInfo {

    private Context context;
    private TelephonyManager telephonyManager;

    public SystemInfo(Context context) {
        this.context = context;
        this.telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
    }


    public void getDeviceId() {
        telephonyManager.getDeviceId();
    }
}