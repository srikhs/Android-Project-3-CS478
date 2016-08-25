package com.example.saisrikanth.project3companion;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by srikh on 3/16/2016.
 */
//This is associated with the Chicago file
public class WebViewList extends Fragment {

    private static final String TAG = "QuotesFragment";

    private WebView mQuoteView = null;
    private int mCurrIdx = -1;
    private int mQuoteArrLen;

    int getShownIndex() {
        return mCurrIdx;
    }

    // Show the Webview string at position newIndex
    void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrLen)
            return;
        mCurrIdx = newIndex;
       // mQuoteView.setText(MainActivity.mWebViewArray[mCurrIdx]);
        mQuoteView.getSettings().setJavaScriptEnabled(true);
        mQuoteView.loadUrl(MainActivity.mWebViewArray[newIndex]);
    }

    @Override
    public void onAttach(Activity activity) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onAttach()");
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onCreateView()");

        // Inflate the layout defined in webview.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.webview,
                container, false);
    }

    // Set up some information about the mQuoteView TextView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":entered onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        mQuoteView = (WebView) getActivity().findViewById(R.id.webView);
        mQuoteArrLen = MainActivity.mWebViewArray.length;

    }


}
