package com.app.riyazulquran7line;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.animation.ActivityAnimator;

public class SplashScreen extends Activity
{
    boolean isChangedStat=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run()
            {
                //start your activity here
                if (isChangedStat == false)
                {
                    isChangedStat = true;
                    startMenuScreen();
                }
            }
        }, 5000L);

    }
public void startMenuScreen()
{
    Intent intent=new Intent(Intent.ACTION_VIEW);
    intent.setClass(SplashScreen.this, MainActivity.class);
    startActivityForResult(intent, 300);
    ActivityAnimator anim = new ActivityAnimator();

    try {
    anim.getClass().getMethod("appearTopLeft" + "Animation", Activity.class).invoke(anim, SplashScreen.this);
}
catch(Exception e ) {


}
    finish();
}


}
