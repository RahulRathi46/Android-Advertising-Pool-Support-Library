package com.vangiex.admob;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Banner {
    private AdRequest Request;
    private AdView view;

    // Mode : Mannual & show
    public Banner() {
    }

    // Mode : manual Show && mannully view
    public Banner(AdView view) {
        this.view = view;
    }

    // Mode : auto show
    public Banner(View viewById) {
        this.view = (AdView) viewById;
        new BannerAsyn().execute();
    }

    public void Show() {
        new BannerAsyn().execute();
    }


    public AdRequest getRequest() {
        return Request;
    }

    public void setRequest(AdRequest request) {
        Request = request;
    }

    public AdView getView() {
        return view;
    }

    public void setView(View view) {
        this.view = (AdView) view;
    }

    class BannerAsyn extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            Log.d("BannerSyn", "Called Asyn Task");
            Request = new AdRequest.Builder().build();
            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            view.loadAd(Request);
        }
    }

    class RequestAsyn extends AsyncTask<Void, Void, AdRequest> {

        AdRequest Request;

        @Override
        protected AdRequest doInBackground(Void... voids) {
            Log.d("RequestSyn", "Called Asyn Request");
            Request = new AdRequest.Builder().build();
            return Request;
        }
    }


}
