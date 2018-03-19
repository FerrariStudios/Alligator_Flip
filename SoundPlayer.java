package com.FireFerrariStudios.AlligatorFlip;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import java.util.HashMap;

/**
 * Created by Matthew Ferrari on 6/12/2016.
 */
public class SoundPlayer{
    public static final int S1 = R.raw.button;
    public static final int S2 = R.raw.eat;
  //  public static final int S3 = R.raw.tada;
    private static SoundPool soundPool;
    private static HashMap soundPoolMap;
    /** Populate the SoundPool*/
    public static void initSounds(Context context) {
        soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap(3);
        soundPoolMap.put( S1, soundPool.load(context, S1, 1) );
        soundPoolMap.put( S2, soundPool.load(context, S2, 2) );
        //soundPoolMap.put( S3, soundPool.load(context, S3, 3) );
    }
    /** Play a given sound in the soundPool */
    public static int playSound(Context context, int soundID) {
        if(soundPool == null || soundPoolMap == null){
            initSounds(context);
        }
        float volume = (float).5;// whatever in the range = 0.0 to 1.0
        // play sound with same right and left volume, with a priority of 1,
        // zero repeats (i.e play once), and a playback rate of 1f
        return soundPool.play(soundID, volume, volume, 1, 0, 1f);
    }

    //public static int stopSound( int streamID) {
      //  soundPool.stop(streamID);
   // }
    /** Play the sound using android.media.MediaPlayer */
    public static void playSoundMP(Context context, int soundID){
        MediaPlayer mp = MediaPlayer.create(context, soundID);
        mp.start();
    }
}