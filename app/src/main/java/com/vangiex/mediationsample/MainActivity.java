package com.vangiex.mediationsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vangiex.admob.Banner;
import com.vangiex.admob.Interstitial;
import com.vangiex.admob.Reward;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Banner banner = new Banner();
        banner.setView(findViewById(R.id.adView));
        try {
            banner.show();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Interstitial i = new Interstitial(this,"ca-app-pub-3940256099942544/1033173712");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        try {
            Reward r = new Reward(this,"ca-app-pub-3940256099942544/5224354917");
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
