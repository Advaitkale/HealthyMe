package com.example.lenovo.healthyme;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main10Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    String call[]={"9028620349","8828460376","9930116923","8452037371","9028620349","8828460376","9930116923","8452037371","9028620349","8828460376","9930116923","8452037371","9028620349","8828460376","9930116923","8452037371"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView)findViewById(R.id.listView);
        String [] subjects = {"Doctor 1", "Doctor 2","Doctor 3","Doctor 4","Doctor 5","Doctor 6","Doctor 7","Doctor 8","Doctor 9", "Doctor 10","Doctor 11","Doctor 12","Doctor 13","Doctor 14","Doctor 15","Doctor 16"};


        ListAdapter listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,subjects);



        listView.setAdapter(listAdapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                String sub = String.valueOf(parent.getItemAtPosition(position));

                Toast.makeText(Main10Activity.this,"Calling " +sub , Toast.LENGTH_SHORT).show();
                String dial="tel:"+call[0];
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));



            }

        });
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
        getMenuInflater().inflate(R.menu.main10, menu);
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
            share();

        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void share(){
        Intent sharingIntent=new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "https://github.com/Advaitkale/HealthyMe";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
