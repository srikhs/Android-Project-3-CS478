package com.example.saisrikanth.project3companion;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.example.saisrikanth.project3companion.IndianapolisList.ListSelectionListener;
/**
 * Created by srikh on 3/16/2016.
 */
// This is used while populating when Indianapolis button is clicked
public class IndianapolisMainActivity extends AppCompatActivity implements ListSelectionListener {



    public static String[] mListArray;
    public static String[] mWebViewArray;


    private final WebViewList1 mQuoteFragment = new WebViewList1();
    private FragmentManager mFragmentManager;
    private FrameLayout mTitleFrameLayout, mQuotesFrameLayout;

    private static final int MATCH_PARENT = LinearLayout.LayoutParams.MATCH_PARENT;
    private static final String TAG = "QuoteViewerActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Log.i(TAG, getClass().getSimpleName() + ":entered onCreate()");

        super.onCreate(savedInstanceState);

        // Get the string arrays with the titles and qutoes
        mListArray = getResources().getStringArray(R.array.LocationIndianapolis);
        mWebViewArray = getResources().getStringArray(R.array.QuotesIndianapolis);
      //  Log.d("wsaisw",mWebViewArray[1]+"ss");
     //   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
   //     setSupportActionBar(toolbar);
        setContentView(R.layout.content_main);

        // Get references to the TitleFragment and to the QuotesFragment
        mTitleFrameLayout = (FrameLayout) findViewById(R.id.location_fragment);
        mQuotesFrameLayout = (FrameLayout) findViewById(R.id.webview_fragment);


        // Get a reference to the FragmentManager
        mFragmentManager = getFragmentManager();

        // Start a new FragmentTransaction
        FragmentTransaction fragmentTransaction = mFragmentManager
                .beginTransaction();

        // Add the TitleFragment to the layout
        fragmentTransaction.replace(R.id.location_fragment,
                new IndianapolisList());
       // fragmentTransaction.addToBackStack(null);
        // Commit the FragmentTransaction
        fragmentTransaction.commit();

        // Add a OnBackStackChangedListener to reset the layout when the back stack changes
        mFragmentManager
                .addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
                    public void onBackStackChanged() {
                        setLayout();
                    }
                });
    }

    private void setLayout() {

        // Determine whether the QuoteFragment has been added
        if (!mQuoteFragment.isAdded()) {

            // Make the TitleFragment occupy the entire layout
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    MATCH_PARENT, MATCH_PARENT));
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
        }
        else {
        int orientationSize= getResources().getConfiguration().orientation;
        if (orientationSize==2){

            // Make the TitleLayout take 1/3 of the layout's width
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 1f));

            // Make the QuoteLayout take 2/3's of the layout's width
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT, 2f));
        }
        if (orientationSize==1){
            mTitleFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(0,
                    MATCH_PARENT));
            mQuotesFrameLayout.setLayoutParams(new LinearLayout.LayoutParams(MATCH_PARENT,
                    MATCH_PARENT));

        }}
    }

    // Called when the user selects an item in the TitlesFragment
    @Override
    public void onListSelection(int index) {

        // If the QuoteFragment has not been added, add it now
        if (!mQuoteFragment.isAdded()) {

            // Start a new FragmentTransaction
            FragmentTransaction fragmentTransaction = mFragmentManager
                    .beginTransaction();

            // Add the QuoteFragment to the layout
            fragmentTransaction.replace(R.id.webview_fragment,
                    mQuoteFragment);

            // Add this FragmentTransaction to the backstack
            fragmentTransaction.addToBackStack(null);

            // Commit the FragmentTransaction
            fragmentTransaction.commit();

            // Force Android to execute the committed FragmentTransaction
            mFragmentManager.executePendingTransactions();
        }

        if (mQuoteFragment.getShownIndex() != index) {

            // Tell the QuoteFragment to show the quote string at position index
            mQuoteFragment.showQuoteAtIndex(index);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if (count!=0){
            getFragmentManager().popBackStack();
        }
        else
        {
            super.onBackPressed();
        }



    }
    @Override
    protected void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onDestroy()");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onPause()");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onResume()");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStart()");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, getClass().getSimpleName() + ":entered onStop()");
        super.onStop();
    }

}

