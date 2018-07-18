package com.vangiex.admob;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;

import java.util.concurrent.ExecutionException;

public class Interstitial {

    private InterstitialAd mInterstitialAd;
    private String unitId;
    private Context ctx;

    public Interstitial(Context ctx, String UnitId) throws ExecutionException, InterruptedException {
        this.unitId = UnitId;
        this.ctx = ctx;
        Init();
        RequestAd();
        Addlistener();
    }

    public Interstitial(String unitId, Context ctx) throws ExecutionException, InterruptedException {
        this.unitId = unitId;
        this.ctx = ctx;
        Init();
        RequestAd();
    }

    public void show() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            Log.d("TAG", "opened----------------------------------------------");
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }


    private void Addlistener() {
        mInterstitialAd.setAdListener(new Listener());
    }

    private void RequestAd() throws ExecutionException, InterruptedException {
        mInterstitialAd.loadAd(new Request().execute().get());
    }

    private void Init() {
        mInterstitialAd = new InterstitialAd(ctx);
        mInterstitialAd.setAdUnitId(unitId);
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public InterstitialAd getmInterstitialAd() {
        return mInterstitialAd;
    }

    class Listener extends AdListener {

        @Override
        public void onAdLoaded() {
            // Code to be executed when an ad finishes loading.
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                Log.d("TAG", "opened----------------------------------------------");
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            // Code to be executed when an ad request fails.
            Log.d("TAG", "fail------------------------------------------");
        }

        @Override
        public void onAdOpened() {
            // Code to be executed when the ad is displayed.
            Log.d("TAG", "opened--------------------------------.");
        }

        @Override
        public void onAdLeftApplication() {
            // Code to be executed when the user has left the app.
            Log.d("TAG", "application--------------------------------------");
        }

        @Override
        public void onAdClosed() {
            // Code to be executed when when the interstitial ad is closed.
            Log.d("TAG", "closed---------------------------------------------");
        }
    }

}

