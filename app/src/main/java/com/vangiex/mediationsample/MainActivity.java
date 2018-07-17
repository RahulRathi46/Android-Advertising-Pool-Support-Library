package com.vangiex.mediationsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vangiex.admob.Banner;
import com.vangiex.admob.Interstitial;
import com.vangiex.admob.Reward;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Banner banner = new Banner();
        banner.setView(findViewById(R.id.adView));
        banner.Show();

        Interstitial i = new Interstitial(this,"ca-app-pub-8949106420284340/3405468137");

        Reward r = new Reward(this,"ca-app-pub-3940256099942544/5224354917");




    }
}
