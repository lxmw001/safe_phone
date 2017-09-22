package phone.safe.lx.com.safephone.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import phone.safe.lx.com.safephone.R;

public class SoundUtils {

    private static MediaPlayer mediaPlayer;

    public static void playSound(Context context) throws InterruptedException {
//        mediaPlayer = MediaPlayer.create(context, R.raw.alarm);
//        mediaPlayer.start();
        SoundPool sp = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        /*soundId for Later handling of sound pool*/
        int soundId = sp.load(context, R.raw.alarm, 1); // in 2nd param u have to pass your desire ringtone
        sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener()
        {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
                System.out.println("playing sound");
                soundPool.play(sampleId, 1, 1, 0, 0, 1);
            }
        });

    }


}
