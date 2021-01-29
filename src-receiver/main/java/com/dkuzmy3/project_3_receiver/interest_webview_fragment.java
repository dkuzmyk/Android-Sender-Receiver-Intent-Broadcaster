package com.dkuzmy3.project_3_receiver;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class interest_webview_fragment extends Fragment {

    static String[] interestWebpages;

    public interest_webview_fragment(){}

    //@SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        interestWebpages = getResources().getStringArray(R.array.interest_websites);

        Bundle b = getArguments();               // open passed bundle
        int index = b.getInt("val");        // pick up the index of the button pressed

        View v = inflater.inflate(R.layout.interest_pageview_fragment, container, false);
        WebView wv = (WebView)v.findViewById(R.id.web_view_);
        wv.getSettings().setJavaScriptEnabled(true);  // so we can use javascript
        wv.setWebViewClient(new WebViewClient());     // for url

        // when receiving number from list, display website accordingly
        wv.loadUrl(interestWebpages[index]);    // load the url respecive to the index

        setRetainInstance(true);
        return v;
    }
}
