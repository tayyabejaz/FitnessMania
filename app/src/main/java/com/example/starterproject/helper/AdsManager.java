package com.example.starterproject.helper;

/**
 * Created by umairali on 12/3/18.
 */

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.starterproject.BuildConfig;
import com.example.starterproject.R;
import com.example.starterproject.application.AppClass;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import java.util.List;

public class AdsManager {


    private static AdsManager manager;
    private final String TAG = AdsManager.class.getName();
    SharedPreferences preferences;
    Context context;
    private InterstitialAd interstitialAd;
    private RewardedVideoAd rewardedVideoAd;

    private AdsManager() {
        context = AppClass.getContext();
        preferences = AppClass.getContext().getSharedPreferences("spywifi", 0);
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(context.getString(R.string.interstitial_ad_id));

        // fbInterstitialAd = new com.facebook.ads.InterstitialAd(context, context.getString(R.string.interstitial_facebook);
        // load the ads and cache them for later use
        loadInterstitialAd();
    }

    public static AdsManager getInstance() {
        if (manager == null) {
            manager = new AdsManager();
        }
        return manager;
    }

    private AdRequest prepareAdRequest() {
        AdRequest adRequest;

        adRequest = new AdRequest.Builder().build();

        return adRequest;
    }

    public void showBanner(final AdView banner) {
        if (preferences.getBoolean("spywifi", true)) {


            if (Utils.isNetworkAvailable(AppClass.getContext())) {
                if (banner != null) {
                    if (BuildConfig.DEBUG) {
                        banner.loadAd(new AdRequest.Builder()
                                .addTestDevice("5E1FCC3B764D919B8431916707F847EA")
                                .build());
                    } else {
                        banner.loadAd(prepareAdRequest());
                    }
                    banner.setAdListener(new AdListener() {

                        @Override
                        public void onAdFailedToLoad(int i) {
                            super.onAdFailedToLoad(i);
                            Log.d(TAG, "AdMob BannerAd -> onAdFailedToLoad");
                        }

                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            Log.d(TAG, "AdMob BannerAd -> onAdLoaded");
                            if (banner.getVisibility() == View.GONE) {
                                banner.setVisibility(View.VISIBLE);
                            }
                        }
                    });
                }
            }
        }
    }

    private void loadInterstitialAd() {
        if (preferences.getBoolean("spywifi", true)) {
            if (Utils.isNetworkAvailable(AppClass.getContext())) {
                if (BuildConfig.DEBUG) {
                    interstitialAd.loadAd(new AdRequest.Builder()
                            .addTestDevice("5E1FCC3B764D919B8431916707F847EA")
                            .build());
                } else {
                    interstitialAd.loadAd(prepareAdRequest());
                }
                interstitialAd.setAdListener(new AdListener() {

                    @Override
                    public void onAdClosed() {
                        super.onAdClosed();
                        Log.d(TAG, "AdMob InterstitialAd -> onAdClosed");
                        loadInterstitialAd();
                    }

                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.d(TAG, "AdMob InterstitialAd -> onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(int i) {
                        super.onAdFailedToLoad(i);
                        Log.d(TAG, "AdMob InterstitialAd -> onAdFailedToLoad");
                    }
                });
            }
        }
    }

    public void showInterstitialAd() {
        if (preferences.getBoolean("spywifi", true)) {
            if (interstitialAd.isLoaded()) {
                interstitialAd.show();
            } else {
                loadInterstitialAd();
            }
        }
    }

    @SuppressLint("InflateParams")
    public void loadNativeAppInstall(final Context context, final FrameLayout nativeAppInstall, NativeAdType nativeAdType) {
        if (Utils.isNetworkAvailable(AppClass.getContext())) {
            AdLoader adLoader = new AdLoader.Builder(context, context.getString(R.string.native_ad_unit))
                    .forUnifiedNativeAd(unifiedNativeAd -> {
                        Log.d(TAG, "onNativeAppInstallAdLoaded");
                        UnifiedNativeAdView adView;
                        if (nativeAdType == NativeAdType.REGULAR_TYPE) {
                            adView = (UnifiedNativeAdView) LayoutInflater.from(context).inflate(R.layout.ad_app_install, null);
                        } else {
                            adView = (UnifiedNativeAdView) LayoutInflater.from(context).inflate(R.layout.banner_ad_app_install, null);
                        }
                        populateNativeAppInstallAdView(unifiedNativeAd, adView);
                        nativeAppInstall.removeAllViews();
                        nativeAppInstall.addView(adView);
                    })
                    .withAdListener(new AdListener() {

                        @Override
                        public void onAdFailedToLoad(int i) {
                            super.onAdFailedToLoad(i);
                            Log.d(TAG, "onNativeAppInstallAdFailedToLoad");
                        }

                        @Override
                        public void onAdLoaded() {
                            super.onAdLoaded();
                            if (nativeAppInstall.getVisibility() == View.GONE) {
                                nativeAppInstall.setVisibility(View.VISIBLE);
                            }
                            Log.d(TAG, "onNativeAppInstallAdLoaded");
                        }

                        @Override
                        public void onAdClosed() {
                            super.onAdClosed();
                            Log.d(TAG, "onNativeAppInstallAdClosed");
                        }
                    }).build();
            adLoader.loadAd(prepareAdRequest());
        }
    }

    private void populateNativeAppInstallAdView(UnifiedNativeAd nativeAppInstallAd, UnifiedNativeAdView adView) {
        // Get the video controller for the ad. One will always be provided, even if the ad doesn't
        // have a video asset.
        try {
            if (nativeAppInstallAd != null) {
                VideoController vc = nativeAppInstallAd.getVideoController();

                // Create a new VideoLifecycleCallbacks object and pass it to the VideoController. The
                // VideoController will call methods on this object when events occur in the video
                // lifecycle.
                vc.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
                    public void onVideoEnd() {
                        // Publishers should allow native ads to complete video playback before refreshing
                        // or replacing them with another ad in the same UI location.
                        super.onVideoEnd();
                    }
                });

                adView.setHeadlineView(adView.findViewById(R.id.appinstall_headline_banner));
                adView.setBodyView(adView.findViewById(R.id.appinstall_body));
                adView.setCallToActionView(adView.findViewById(R.id.appinstall_call_to_action));
                adView.setIconView(adView.findViewById(R.id.appinstall_app_icon));
                adView.setStarRatingView(adView.findViewById(R.id.appinstall_stars));

                // Some assets are guaranteed to be in every NativeAppInstallAd.
                ((TextView) adView.getHeadlineView()).setText(nativeAppInstallAd.getHeadline());
                ((TextView) adView.getBodyView()).setText(nativeAppInstallAd.getBody());
                ((Button) adView.getCallToActionView()).setText(nativeAppInstallAd.getCallToAction());
                // ((ImageView) adView.getIconView()).setImageDrawable(nativeAppInstallAd.getIcon().getDrawable());

                if (nativeAppInstallAd.getIcon() != null && nativeAppInstallAd.getIcon().getUri() != null) {
                    Glide.with(AppClass.getContext()).
                            load(nativeAppInstallAd.getIcon().
                                    getUri()).
                            into((ImageView) adView.getIconView());
                } else {
                    Glide.with(AppClass.getContext()).
                            load(nativeAppInstallAd.getImages().get(0).getUri()).
                            into((ImageView) adView.getIconView());

                }

                MediaView mediaView = adView.findViewById(R.id.appinstall_media);
                ImageView mainImageView = adView.findViewById(R.id.appinstall_image);

                // Apps can check the VideoController's hasVideoContent property to determine if the
                // NativeAppInstallAd has a video asset.
                if (vc.hasVideoContent()) {
                    adView.setMediaView(mediaView);
                    mainImageView.setVisibility(View.GONE);
                } else {

                    adView.setImageView(mainImageView);
                    mediaView.setVisibility(View.GONE);

                    // At least one image is guaranteed.
                    List<NativeAd.Image> images = nativeAppInstallAd.getImages();
                    if (images.size() > 0) {

                        Glide.with(AppClass.getContext()).
                                load(images.get(0).getUri()).
                                into(mainImageView);
                    }
                    // mainImageView.setImageDrawable(images.get(0).getUri());

                }

                // These assets aren't guaranteed to be in every NativeAppInstallAd, so it's important to
                // check before trying to display them.
                if (nativeAppInstallAd.getStarRating() == null) {
                    adView.getStarRatingView().setVisibility(View.GONE);
                } else {
                    ((RatingBar) adView.getStarRatingView())
                            .setRating(nativeAppInstallAd.getStarRating().floatValue());
                    adView.getStarRatingView().setVisibility(View.VISIBLE);
                }

                // Assign native ad object to the native view.
                adView.setNativeAd(nativeAppInstallAd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public enum NativeAdType {
        REGULAR_TYPE,
        BANNER_TYPE
    }

}
