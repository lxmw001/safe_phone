package phone.safe.lx.com.safephone.utils;

import java.io.DataOutputStream;

public class Terminal {

    public static void runAsRoot(String[] commands){
        try {
            Process p = Runtime.getRuntime().exec("su");
            DataOutputStream os = new DataOutputStream(p.getOutputStream());
            for (String tmpCmd : commands) {
                os.writeBytes(tmpCmd+"\n");
            }
            os.writeBytes("exit\n");
            os.flush();
        } catch (Exception e) {
            System.out.println("Error");
        }

    }
}
