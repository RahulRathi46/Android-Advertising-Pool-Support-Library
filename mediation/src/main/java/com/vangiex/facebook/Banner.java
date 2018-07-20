package com.vangiex.facebook;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.vangiex.facebook.AdListener.Listener;

public class Banner {

    private AdView adView;
    private LinearLayout view;
    private Context ctx;
    private String unitId;

    // Mode : Auto
    public Banner(Context ctx, String UnitId , LinearLayout view) {
        this.ctx = ctx;
        this.unitId = UnitId;
        this.view = view;

        Init();
        AddView();
        Request();

        adView.setAdListener(new Listener("BANNER"));

    }

    // Mode : Mannully
    public Banner(Context ctx,String UnitId) {
        this.ctx = ctx;
        this.unitId = UnitId;
        Init();
    }

    public View getView() {
        return view;
    }

    public void setView(LinearLayout view) {
        this.view = view;
        AddView();
    }

    public void show()
    {
        Request();
    }

    private void Request()
    {
        // Request an ad
        adView.loadAd();
    }

    private void AddView() {

        // Add the ad view to your activity layout
        view.addView(adView);
    }

    private void Init() {

        adView = new AdView(ctx, unitId, AdSize.BANNER_HEIGHT_50);
    }


}
