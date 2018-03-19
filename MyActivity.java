package com.FireFerrariStudios.AlligatorFlip;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    //default shared prefence file
    private SharedPreferences preferenceSettings;
    private SharedPreferences.Editor preferenceEditor;
    private static final int PREFERENCE_MODE_PRIVATE =0;

    DrawView drawView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView=new DrawView(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        preferenceSettings=getPreferences(PREFERENCE_MODE_PRIVATE);
        drawView.setHighScore(preferenceSettings.getInt("High Score",1));
        //System.out.println("High Score load: "+drawView.getHighScore()+" "+preferenceSettings.getInt("High Score", 1));
        setContentView(drawView);


    }

    @Override
    protected void onStop() {
        super.onDestroy();
        preferenceSettings=getPreferences(PREFERENCE_MODE_PRIVATE);
        preferenceEditor = preferenceSettings.edit();
        //System.out.println("High Score: "+drawView.getHighScore()+" "+preferenceSettings.getInt("High Score", 1));
        preferenceEditor.putInt("High Score",drawView.getHighScore());
        //System.out.println("High Score2: "+drawView.getHighScore()+" "+preferenceSettings.getInt("High Score", 1));
        preferenceEditor.commit();

    }
}



