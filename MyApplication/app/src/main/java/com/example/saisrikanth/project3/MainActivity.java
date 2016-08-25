package com.example.saisrikanth.project3;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button upButton ;
    private Button downButton ;
    private String city1="Chicago";
    private String city2="Indianapolis";

    private static final String TOAST_INTENT_UP =
            "com.example.saisrikanth.project3.showToastUp";
   // private static final String TOAST_INTENT_DOWN =
         //   "com.example.saisrikanth.project3.showToastDown";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Chicago Button Click
        upButton = (Button) findViewById(R.id.buttonUp) ;
        upButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent upIntent = new Intent(TOAST_INTENT_UP);
                upIntent.putExtra("City", city1);   //Passing city value in extra
                sendOrderedBroadcast(upIntent, null);



            }
        }) ;


        //Indianapolis Button Click
        downButton = (Button) findViewById(R.id.buttonDown) ;
        downButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent downIntent = new Intent(TOAST_INTENT_UP);
                downIntent.putExtra("City", city2); //Passing city value in extra
                sendOrderedBroadcast(downIntent, null);


            }
        }) ;




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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
