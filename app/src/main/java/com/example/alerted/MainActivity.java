package com.example.alerted;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

/**
 * @author Roy Tendler
 * @version 1
 * @since 03/12/2019
 */
public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder adb;
    LinearLayout ll ;
    Random rnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
        rnd = new Random();

    }

    /**
     *The method creates an alert message with text when button is pressed
     */
    public void first(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Only message");
        adb.setMessage("Hello");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method creates an alert message with text and a picture when the button is pressed
     */
    public void second(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Picture and a message");
        final ImageView iv1 = new ImageView(this);
        iv1.setImageResource(R.drawable.lilpic);
        adb.setView(iv1);
        adb.setMessage("Hello");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method creates an alert message with text a picture and a button when the button is pressed
     */

    public void third(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("Picture message and a button");
        final ImageView iv3 = new ImageView(this);
        iv3.setImageResource(R.drawable.lilpic);
        adb.setView(iv3);
        adb.setMessage("Hello");
        adb.setNeutralButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        adb.setCancelable(false);
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method creates an alert message with text and one button to change the background and one to cancel when the button is pressed
     */
    public void fourth(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("message and two buttons");

        adb.setMessage("Do you want to change your background?");

        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(255)+1, rnd.nextInt(255)+1, rnd.nextInt(255)+1));
            }
        });

        adb.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        adb.setCancelable(false);

        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     *The method creates an alert message with text and with one button to change the background one to cancel and one to reset to white when the button is pressed
     */
    public void fifth(View view) {
        adb = new AlertDialog.Builder(this);

        adb.setTitle("message and two buttons");

        adb.setMessage("Do you want to change your background?");

        adb.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.rgb(rnd.nextInt(255)+1, rnd.nextInt(255)+1, rnd.nextInt(255)+1));
            }
        });

        adb.setNegativeButton("Reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll.setBackgroundColor(Color.WHITE);
            }
        });
        adb.setNeutralButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        adb.setCancelable(false);

        AlertDialog ad = adb.create();
        ad.show();

    }

    /**
     *The method creates an option menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,0,250,"Credits");
        return true;
    }

    /**
     *The method checks what option was picked in the option menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String st=item.getTitle().toString();
        if(st.equals("Credits")){
            Intent si = new Intent(this,Credits.class);
            startActivity(si);
        }

        return true;
    }
}
