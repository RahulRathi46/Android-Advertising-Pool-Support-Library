package com.vangiex.facebook;

import android.content.Context;
import android.util.Log;

import com.facebook.ads.Ad;
import com.facebook.ads.InterstitialAd;
import com.vangiex.facebook.AdListener.InterstitialListener;

public class Interstitial {

    private final InterstitialAd interstitialAd;

    public Interstitial(Context ctx) {

        interstitialAd = new InterstitialAd(ctx, "481369655656275_481400692319838");
        interstitialAd.setAdListener(new Listener("interstitial".toUpperCase()));
        interstitialAd.loadAd();
    }

    class Listener extends InterstitialListener {

        public Listener(String TAG) {
            super(TAG);
        }

        @Override
        public void onAdLoaded(Ad ad) {
            // Interstitial ad is loaded and ready to be displayed
            Log.d(TAG, "ad is loaded and ready to be displayed!");
            // Show the ad
            interstitialAd.show();
        }

       }
}
