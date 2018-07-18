package com.vangiex.admob;


import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.concurrent.ExecutionException;

public class Banner {
    private AdRequest Request;
    private AdView view;

    // Mode : auto show
    public Banner(View viewById) throws ExecutionException, InterruptedException {
        this.view = (AdView) viewById;
        show();
    }

    public Banner() {
    }

    private AdRequest getRequest() throws ExecutionException, InterruptedException {
        return new Request().execute().get();
    }

    public void show() throws ExecutionException, InterruptedException {
        view.loadAd(getRequest());
    }

    public AdView getView() {
        return view;
    }

    public void setView(View view) {
        this.view = (AdView) view;
    }
}
