package com.example.jadwalsholatku;

import android.content.ClipData;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View;

public class layoutpertama extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        Button jadwal = (Button) findViewById(R.id.button2);
        jadwal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View a) {
                Intent myIntent = new
                        Intent(a.getContext(), jadwalsholat.class);
                startActivityForResult(myIntent, 0);
            }
        });

        Button tentang = (Button) findViewById(R.id.button4);
        tentang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View c) {
                Intent myIntent = new
                        Intent(c.getContext(), contact.class);
                startActivityForResult(myIntent, 0);
            }
        });
        Button arahmasjid = (Button) findViewById(R.id.button5);
        arahmasjid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View d) {
                Intent myIntent = new
                        Intent(d.getContext(), myredirect.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }
    }

