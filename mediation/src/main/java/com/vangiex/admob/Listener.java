package com.vangiex.admob;

import android.util.Log;

import com.google.android.gms.ads.AdListener;

public class Listener extends AdListener {

        String TAG = "ADMOB";

        public Listener(String TAG) {
                this.TAG = this.TAG + TAG;
        }

        @Override
        public void onAdLoaded() {
            // Code to be executed when an ad finishes loading.
                Log.d(TAG, "ad is loaded and ready to be displayed!");
        }

        @Override
        public void onAdFailedToLoad(int errorCode) {
            // Code to be executed when an ad request fails.
                Log.e(TAG, "ad failed to load ErrorCode :  " + String.valueOf(errorCode));
        }

        @Override
        public void onAdOpened() {
            // Code to be executed when an ad opens an overlay that
            // covers the screen.
                Log.d(TAG, "ad opened!!");
        }

        @Override
        public void onAdLeftApplication() {
            // Code to be executed when the user has left the app.
                Log.d(TAG, "ad leftappication");
        }

        @Override
        public void onAdClosed() {
            // Code to be executed when when the user is about to return
            // to the app after tapping on an ad.
                Log.d(TAG, "ad closed!!");
        }
}
