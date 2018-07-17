package com.vangiex.admob;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class Reward  {

    private Context ctx;
    private String UnitId = null;
    private RewardedVideoAd mRewardedVideoAd;

    // Mode : Auto
    public Reward(Context ctx, String UnitId) {
        this.ctx = ctx;
        this.UnitId = UnitId;
        new RewardAsyn().execute();
    }

    // Mode mannull
    public Reward(Context ctx) {
        this.ctx = ctx;
    }

    class RewardAsyn extends AsyncTask<Void, Void, AdRequest> {

        @Override
        protected void onPreExecute() {
            if (UnitId == null) {
                UnitId = "ca-app-pub-3940256099942544/5224354917";
            }
            mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(ctx);
        }

        @Override
        protected AdRequest doInBackground(Void... voids) {

            AdRequest request = new AdRequest.Builder().build();
            return request;
        }

        @Override
        protected void onPostExecute(AdRequest request) {
            super.onPostExecute(request);
            mRewardedVideoAd.loadAd(UnitId, request);
            mRewardedVideoAd.setRewardedVideoAdListener(new Listener());
        }
    }

    class RequestAsyn extends AsyncTask<Void, Void, AdRequest> {
        @Override
        protected AdRequest doInBackground(Void... voids) {

            AdRequest request = new AdRequest.Builder().build();
            return request;
        }
    }


    class Listener implements RewardedVideoAdListener {

        @Override
        public void onRewardedVideoAdLoaded() {

            if (mRewardedVideoAd.isLoaded()) {
                mRewardedVideoAd.show();

            } else {
                onRewardedVideoAdFailedToLoad(1);
            }
        }

        @Override
        public void onRewardedVideoAdOpened() {


        }

        @Override
        public void onRewardedVideoStarted() {

        }

        @Override
        public void onRewardedVideoAdClosed() {


        }

        @Override
        public void onRewarded(RewardItem rewardItem) {

        }

        @Override
        public void onRewardedVideoAdLeftApplication() {

        }

        @Override
        public void onRewardedVideoAdFailedToLoad(int i) {


        }

        @Override
        public void onRewardedVideoCompleted() {


        }
    }


}