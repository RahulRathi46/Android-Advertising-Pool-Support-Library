package com.vangiex.admob;

import android.os.AsyncTask;

import com.google.android.gms.ads.AdRequest;

public class Request extends AsyncTask<Void,Void,AdRequest>{
    private AdRequest request;
    @Override
    protected AdRequest doInBackground(Void... Void){
        request = new AdRequest.Builder().build();
        return request;
    }
}
