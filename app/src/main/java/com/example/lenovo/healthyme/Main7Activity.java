package com.example.lenovo.healthyme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class Main7Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Button b1;
    EditText e1;
    EditText e2;
    EditText e3;
    Spinner s;
    Spinner s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.edit1);
        e2=(EditText)findViewById(R.id.edit2);
        e3=(EditText)findViewById(R.id.edit3);
        s = (Spinner) findViewById(R.id.spinner);
        s2 = (Spinner) findViewById(R.id.spinner2);
        String [] subjects = {"Lab 1", "Lab 2","Lab 3","Lab 4","Lab 5","Lab 6","Lab 7","Lab 8"};
        String [] time = {"10:00AM-11:00AM", "11:00AM-12:00","12:00-1:00PM","1:00PM-2:00PM","2:00PM-3:00PM","3:00PM-4:00PM","4:00PM-5:00PM","5:00PM-6:00PM"};



        SpinnerAdapter sa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,subjects);
        SpinnerAdapter sb = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,time);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=e1.getText().toString();
                String contact=e2.getText().toString();
                String doc=e3.getText().toString();
                Toast.makeText(Main7Activity.this,"Appointment Booked for "+ name + "("+contact+") "+ " with (DR."+doc+")",Toast.LENGTH_LONG).show();

            }
        });


        s.setAdapter(sa);
        s2.setAdapter(sb);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main7, menu);
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
            Intent intent = new Intent(getApplicationContext(),Home.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.signout) {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_doc) {
            Intent intent = new Intent(getApplicationContext(),Main10Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_shop) {
            Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_records) {
            Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_contacts ) {
            Intent intent = new Intent(getApplicationContext(),Main5Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_share) {
            Intent intent = new Intent(getApplicationContext(),Main8Activity.class);
            startActivity(intent);

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
