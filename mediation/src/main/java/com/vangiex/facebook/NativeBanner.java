package com.vangiex.facebook;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdChoicesView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdIconView;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.vangiex.facebook.AdListener.NativeListener;
import com.vangiex.mediation.R;

import java.util.ArrayList;
import java.util.List;

public class NativeBanner {

    private final NativeBannerAd nativeBannerAd;
    private final Context ctx;
    private String unitId;
    private final View View;

    // Mode : Auto
    public NativeBanner(Context ctx , String UnitId, View view) {
        this.ctx = ctx;
        unitId = UnitId;
        this.View = view;

        nativeBannerAd = new NativeBannerAd(ctx, UnitId);
        nativeBannerAd.setAdListener(new Listener("NATIVEBANNER" , view) );
        nativeBannerAd.loadAd();
    }

    private void inflateAd(Context ctx , NativeBannerAd nativeBannerAd , View view) {
        // Unregister last ad
        nativeBannerAd.unregisterView();

        // Add the Ad view into the ad container.
        ViewGroup nativeBannerAdContainer = (ViewGroup) view;
        LayoutInflater inflater = LayoutInflater.from(ctx);
        // Inflate the Ad view.  The layout referenced is the one you created in the last step.
        LinearLayout adView = (LinearLayout) inflater.inflate(R.layout.nativebanner, nativeBannerAdContainer, false);
        nativeBannerAdContainer.addView(adView);

        // Add the AdChoices icon
        RelativeLayout adChoicesContainer = adView.findViewById(R.id.ad_choices_container);
        AdChoicesView adChoicesView = new AdChoicesView(ctx, nativeBannerAd, true);
        adChoicesContainer.addView(adChoicesView, 0);

        // Create native UI using the ad metadata.
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        AdIconView nativeAdIconView = adView.findViewById(R.id.native_icon_view);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(
                nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        // Register the Title and CTA button to listen for clicks.
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(adView, nativeAdIconView, clickableViews);
    }

    class Listener extends NativeListener {

        private final View view;

        public Listener(String TAG, android.view.View view) {
            super(TAG);
            this.view = view;
        }

        @Override
        public void onAdLoaded(Ad ad) {
            // Race condition, load() called again before last ad was displayed
            if (nativeBannerAd != ad) {
                return;
            }
            // Inflate Native Banner Ad into Container
            inflateAd(ctx , nativeBannerAd , view);
        }
    }
}

