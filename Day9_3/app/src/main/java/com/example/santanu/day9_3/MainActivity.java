package com.example.santanu.day9_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdView = findViewById(R.id.adView);
        MobileAds.initialize(this, "ca-app-pub-3467339392961780/7886048909");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-3467339392961780/7886048909");
        AdRequest request = new AdRequest.Builder().build();
        interstitialAd.loadAd(request);
        interstitialAd.setAdListener(new AdListener(){
            public void onAdLoaded(){
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show();
                }
            }
        });
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}