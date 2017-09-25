package phone.safe.lx.com.safephone.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.Timer;

import phone.safe.lx.com.safephone.R;

public class SoundUtils {

    private static SoundPool soundPool;
    private static AudioManager audioManager;
    private static int currentVolume;

    public static void playSound(Context context) throws InterruptedException {
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

        /*soundId for Later handling of sound pool*/
        int soundId = soundPool.load(context, R.raw.alarm, 1); // in 2nd param u have to pass your desire ringtone
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,int status) {
                System.out.println("playing sound");
                soundPool.play(sampleId, 1, 1, 0, 0, 1);
            }
        });

    }

    public static void s(){
        
    }

    public static void setupAudioManger(Context context) {
        audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public static void setMaxVolume() {
        audioManager.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                0);
    }

    public static void getCurrentVolume() {
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    public static void restoreVolume() {
        audioManager.setStreamVolume(
                AudioManager.STREAM_MUSIC,
                currentVolume,
                0);
    }
}
