package com.vangiex.admob;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Interstitial {

    private InterstitialAd mInterstitialAd;
    private String UnitId;
    private Context ctx;

    // Mode : Mannual
    public Interstitial(Context ctx)
    {
        this.ctx = ctx;
    }

    // Mode : Auto Mode
    public Interstitial(Context ctx,String unitId) {
        UnitId = unitId;
        mInterstitialAd = new InterstitialAd(ctx);
        mInterstitialAd.setAdUnitId(unitId);
        new InterstitialAsyn().execute();
    }

    // Mode : Auto Mode & Mannual Show
    public Interstitial(Context ctx,String unitId,Boolean Flag_Show) {
        UnitId = unitId;
        this.ctx = ctx;
        mInterstitialAd = new InterstitialAd(ctx);
        mInterstitialAd.setAdUnitId(unitId);
        if(Flag_Show) {
            new InterstitialAsyn().execute();
        }else {
            new InterstitialRequestAsyn().execute();
        }
    }

    public boolean show()
    {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            return true;
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
            return false;
        }
    }

    public InterstitialAd getmInterstitialAd() {
        return mInterstitialAd;
    }

    public void setmInterstitialAd(InterstitialAd mInterstitialAd) {
        this.mInterstitialAd = mInterstitialAd;
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String unitId) {
        UnitId = unitId;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    class InterstitialAsyn extends AsyncTask<Void,Void,Boolean>{

        private AdRequest Request;

        @Override
        protected Boolean doInBackground(Void... voids) {
            Request = new AdRequest.Builder().build();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mInterstitialAd.loadAd(Request);
            mInterstitialAd.setAdListener(new Listener());
            Log.d("TAG", "ADTASK-------------------------------------------------");
        }
    }

    class InterstitialRequestAsyn extends AsyncTask<Void, Void, Boolean> {

        private AdRequest Request;

        @Override
        protected Boolean doInBackground(Void... voids) {
            Request = new AdRequest.Builder().build();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mInterstitialAd.loadAd(Request);
            Log.d("TAG", "ADSYN__________________________");
        }
    }

    class RequestAsyn extends AsyncTask<Void,Void,AdRequest>{

        AdRequest Request;
        @Override
        protected AdRequest doInBackground(Void... Voids) {
            Request = new AdRequest.Builder().build();
            Log.d("TAG", "ADREQUEST--------------------------------------");
            return Request;
        }
    }

    class Listener extends AdListener{

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

