package com.vangiex.admob;

import android.util.Log;

import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class RewardAdListener implements RewardedVideoAdListener {

    String TAG = "ADMOB";

    public RewardAdListener(String TAG) {
        this.TAG = this.TAG + TAG;
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        Log.d(TAG, "ad loaded!");
    }

    @Override
    public void onRewardedVideoAdOpened() {
        Log.d(TAG, "ad opened!");
    }

    @Override
    public void onRewardedVideoStarted() {
        Log.d(TAG, "ad started!");
    }

    @Override
    public void onRewardedVideoAdClosed() {
        Log.d(TAG, "ad closed!");
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
        Log.d(TAG, "ad onreward!");
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
        Log.d(TAG, "ad left application!");
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        Log.d(TAG, "ad failed! code : " + String.valueOf(i));
    }

    @Override
    public void onRewardedVideoCompleted() {
        Log.d(TAG, "ad completed!");
    }
}

