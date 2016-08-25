package com.example.saisrikanth.project3companion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by srikh on 3/16/2016.
 */
public class IntentReceiver extends BroadcastReceiver {
    private String city1 = "Chicago";
    private String city2 = "Indianapolis";
    String newString;


    public void onReceive(Context arg0, Intent arg1) {
        // TODO Auto-generated method stub
        //Gets the extras of intent passed. It should be either Chicago or Indianapolis
        Bundle extras = arg1.getExtras();
        if (extras != null) {

            newString = extras.getString("City");
        }
        //If chicago, chicago list is populated.
        if (newString.equalsIgnoreCase("Chicago")) {
            Toast.makeText(arg0, "Chicago is clicked",
                    Toast.LENGTH_LONG).show();


            Intent intent = new Intent(arg0, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            arg0.startActivity(intent);




        }
        // if indianapolis, its list is populated
        else {
            Toast.makeText(arg0, "Indianapolis is clicked",
                    Toast.LENGTH_LONG).show();

            Intent intent = new Intent(arg0, IndianapolisMainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            arg0.startActivity(intent);

        }


    }


}
