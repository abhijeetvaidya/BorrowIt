package com.neostore.borrowit.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.neostore.borrowit.Activity.EnquiryActivity;
import com.neostore.borrowit.Activity.MainActivity;
import com.neostore.borrowit.R;
import com.neostore.borrowit.Util.Methods;

public class CalculatorFragment extends Fragment{

WebView web;
    String mUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        web = (WebView) view.findViewById(R.id.webEnquiryNow);
        web.getSettings().setJavaScriptEnabled(true);

        if (Methods.isOnline(getActivity().getApplicationContext())) {
            mUrl = "http://smartlink.smartline.com.au/web/contctAU.nsf/HowMuchiPhone?OpenForm";
            web.loadUrl(mUrl);
        } else {
            web.loadData("Please Check your internet connection!", "text/html", "UTF-8");
        }

        web.loadUrl(mUrl);
    }
}
