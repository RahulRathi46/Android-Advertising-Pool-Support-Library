package com.vangiex.facebook.AdListener;

import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdListener;

public class NativeListener implements NativeAdListener {

    public String TAG = "FB";


    public NativeListener(String TAG) {
        this.TAG = this.TAG + TAG;
    }

    @Override
    public void onMediaDownloaded(Ad ad) {

        Log.e(TAG, "ad media download");
    }

    @Override
    public void onError(Ad ad, AdError adError) {

        Log.e(TAG, "ad failed to load: " + adError.getErrorMessage());

    }

    @Override
    public void onAdLoaded(Ad ad) {
        // Race condition, load() called again before last ad was displayed
        Log.e(TAG, "ad adloaded!");

    }

    @Override
    public void onAdClicked(Ad ad) {
        Log.e(TAG, "ad clicked!");
    }

    @Override
    public void onLoggingImpression(Ad ad) {
        Log.e(TAG, "ad logging impression");
    }
}
