package com.neostore.borrowit.Activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.neostore.borrowit.R;
import com.neostore.borrowit.Util.Methods;

public class EnquiryActivity extends Activity {
    ProgressBar progressBar;
    WebView webEnquiryNow;
    String mUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);
        webEnquiryNow = (WebView) findViewById(R.id.webEnquiryNow);
        progressBar = (ProgressBar) findViewById(R.id.progressBar1);
        webEnquiryNow.setWebViewClient(new myWebClient());
        webEnquiryNow.getSettings().setJavaScriptEnabled(true);

        if (Methods.isOnline(this)) {
            mUrl = "http://www.smartline.com.au/";
            webEnquiryNow.loadUrl(mUrl);
        } else {
            webEnquiryNow.loadData("Please Check your internet connection!", "text/html", "UTF-8");
        }
    }

    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            progressBar.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        if (webEnquiryNow.copyBackForwardList().getCurrentIndex() > 0) {
            if(webEnquiryNow.getUrl().equals("http://www.smartline.com.au/")){
                super.onBackPressed();
            }else {
                webEnquiryNow.goBack();
            }
        }
        else {
            super.onBackPressed();
        }
    }
}