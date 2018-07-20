package com.vangiex.admob;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.concurrent.ExecutionException;

import static com.google.ads.mediation.unity.UnityAdapter.TAG;

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
        mRewardedVideoAd.setRewardedVideoAdListener(new Listener("RewardedVideo".toUpperCase()));
    }

    public void show(){
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }


    class Listener extends RewardAdListener
    {
        public Listener(String TAG) {
            super(TAG);
        }

        @Override
        public void onRewardedVideoAdLoaded() {

            if (mRewardedVideoAd.isLoaded()) {
                mRewardedVideoAd.show();
                super.onRewardedVideoAdLoaded();
            } else {
                onRewardedVideoAdFailedToLoad(1);
            }
        }
    }




}