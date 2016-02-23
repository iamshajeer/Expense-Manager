package com.droidev.util.expensetracker.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.droidev.util.expensetracker.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIMER = 1000 * 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(SPLASH_TIMER);
                    launchMainScreen();
                    finish();
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }).start();
    }

    private void launchMainScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
