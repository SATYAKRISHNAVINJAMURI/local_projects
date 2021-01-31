package com.example.satyakrishnavinjamuri.someapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnClickListener();


    }
    public void addOnClickListener(){
        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello World", Toast.LENGTH_LONG).show();
                setContentView(R.layout.second);
                LayoutInflater li = getLayoutInflater();
                View love = li.inflate(R.layout.customtoast,,true);
                LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linear);



            }
        });

        }


    }
