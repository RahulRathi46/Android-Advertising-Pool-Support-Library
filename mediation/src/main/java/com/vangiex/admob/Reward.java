package com.vangiex.admob;

import android.content.Context;
import android.os.AsyncTask;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.concurrent.ExecutionException;

public class Reward  {

    private Context ctx;
    private String UnitId = null;
    private RewardedVideoAd mRewardedVideoAd;

    // Mode : Auto
    public Reward(Context ctx, String UnitId) throws ExecutionException, InterruptedException {
        this.ctx = ctx;
        this.UnitId = UnitId;
        Init();
        Request();
        AddListener();
    }

    public Reward(Context ctx) {
        this.ctx = ctx;
        Init();
    }

    public String getUnitId() {
        return UnitId;
    }

    public void setUnitId(String unitId) throws ExecutionException, InterruptedException {
        UnitId = unitId;
        Request();
    }

    private void Init()
    {
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(ctx);
    }

    private void Request() throws ExecutionException, InterruptedException {
        if (UnitId == null) {
            UnitId = "ca-app-pub-3940256099942544/5224354917";
        }
        mRewardedVideoAd.loadAd(UnitId, new Request().execute().get());
    }

    private void AddListener(){
        mRewardedVideoAd.setRewardedVideoAdListener(new Listener());
    }

    public void show(){
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
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