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
            Log.d("ADMOB", "opened----------------------------------------------");
        } else {
            Log.d("ADMOB", "The interstitial wasn't loaded yet.");
        }
    }


    private void Addlistener() {
        mInterstitialAd.setAdListener(new Listener("Interstitial".toUpperCase()));
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

    class IListener extends Listener {

        public IListener(String TAG) {
            super(TAG);
        }

        @Override
        public void onAdLoaded() {
            // Code to be executed when an ad finishes loading.
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
                super.onAdLoaded();
            } else {
                Log.d(TAG, "The interstitial wasn't loaded yet.");
            }
        }
    }
}

