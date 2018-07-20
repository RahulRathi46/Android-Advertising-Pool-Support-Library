package com.vangiex.facebook.AdListener;

import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;

public class InterstitialListener implements InterstitialAdListener {

    public String TAG = "FB";

    public InterstitialListener(String TAG) {
        this.TAG = this.TAG + TAG;
    }

    @Override
    public void onError(Ad ad, AdError adError) {
        // Ad error callback
        Log.e(TAG, "ad failed to load: " + adError.getErrorMessage());
    }

    @Override
    public void onAdLoaded(Ad ad) {
        // Interstitial ad is loaded and ready to be displayed
        Log.d(TAG, "ad is loaded and ready to be displayed!");
    }

    @Override
    public void onAdClicked(Ad ad) {
        // Ad clicked callback
        Log.d(TAG, "ad clicked!");
    }

    @Override
    public void onLoggingImpression(Ad ad) {
        // Ad impression logged callback
        Log.d(TAG, "ad impression logged!");
    }

    @Override
    public void onInterstitialDisplayed(Ad ad) {
        Log.e(TAG, "ad displayed.");
    }

    @Override
    public void onInterstitialDismissed(Ad ad) {
        Log.e(TAG, "ad dismissed.");
    }
}
