package com.example.dell.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * create by lizejun
 * date 2018/8/14
 */
public class WebViewActivity extends AppCompatActivity {


    private String prevUrl;
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_webview);
        webView = findViewById(R.id.webView);
        Intent intent = getIntent();
        prevUrl = intent.getStringExtra("url");
        webView.setVerticalScrollbarOverlay(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT >= 21) {
            webView.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new OAWebViewClient());
        webView.setWebChromeClient(new OAWebChromeClient());
        if (prevUrl.toLowerCase().startsWith("www")) {
            prevUrl="http://"+prevUrl;
        }
        webView.loadUrl(prevUrl);

    }


    class OAWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (prevUrl != null) {
                if (!prevUrl.equals(url)) {
                    if (!(url.toLowerCase().startsWith("http://") || url.toLowerCase().startsWith("https://"))) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        Uri content_url = Uri.parse(url);
                        intent.setData(content_url);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                        try {
                            startActivity(intent);
                        } catch (Exception e) {

                            e.printStackTrace();
                        }
                        return true;
                    }
                    prevUrl = url;
                    webView.loadUrl(url);
                    return true;
                } else {
                    return false;
                }
            } else {
                prevUrl = url;
                webView.loadUrl(url);
                return true;
            }
        }
    }

    private class OAWebChromeClient extends WebChromeClient {
        @Override
        public void onReceivedTitle(WebView view, String title) {

        }
    }

}
