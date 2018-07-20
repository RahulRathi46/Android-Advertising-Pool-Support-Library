package com.vangiex.facebook.AdListener;

import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;

public class Listener implements AdListener {

    public String TAG = "FB";

    public Listener(String TAG) {
        this.TAG = this.TAG + TAG;
    }

    @Override
    public void onError(Ad ad, AdError adError) {
        Log.e(TAG, "ad failed to load ErrorCode :  " + adError.getErrorCode() + " ErrorMessage : " + adError.getErrorMessage());
    }

    @Override
    public void onAdLoaded(Ad ad) {
        Log.d(TAG, "ad is loaded and ready to be displayed!");
    }

    @Override
    public void onAdClicked(Ad ad) {
        Log.d(TAG, "ad clicked!");

    }

    @Override
    public void onLoggingImpression(Ad ad) {
        Log.d(TAG, "ad impression logged!");
    }
}
