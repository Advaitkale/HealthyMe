package com.example.lenovo.healthyme;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final int REQUEST_CALL=1;
    String call="";
    String number[]={"9930510840","9028620349","8839256761","8828460376","9930116923","8452037371"};
    ImageButton ima;
    ImageButton imb;
    ImageButton imc;
    ImageButton imd;
    ImageButton ime;
    ImageButton imf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    ima=(ImageButton)findViewById(R.id.im);
    imb=(ImageButton)findViewById(R.id.im2);
    imc=(ImageButton)findViewById(R.id.im3);
    imd=(ImageButton)findViewById(R.id.im4);
    ime=(ImageButton)findViewById(R.id.im5);
    imf=(ImageButton)findViewById(R.id.im6);



        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(4);
            }
        });
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(0);
            }
        });
        imc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(1);
            }
        });
        imd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(2);
            }
        });
        ime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givePermission(3);
            }
        });
        imf.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           givePermission(5);
       }
   });

}

    private void givePermission(int callnum)
    {
        String permit[]={Manifest.permission.CALL_PHONE, Manifest.permission.ANSWER_PHONE_CALLS};
        if((ContextCompat.checkSelfPermission(Main5Activity.this,permit[0])!=PackageManager.PERMISSION_GRANTED) || (ContextCompat.checkSelfPermission(Main5Activity.this,permit[1])!=PackageManager.PERMISSION_GRANTED))
        {
            ActivityCompat.requestPermissions(Main5Activity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);

        }

        makePhoneCall(callnum);
    }

    private void makePhoneCall(int callno)
    {
        if(callno==0)
        {
            call=number[0];
        }
        else if(callno==1)
        {
            call=number[1];
        }
        else if(callno==2)
        {
            call=number[2];
        }
        else if(callno==3)
        {
            call=number[3];
        }
        else if(callno==4)
        {
            call=number[4];
        }
        else
            call=number[5];

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==REQUEST_CALL)
        {
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED)
            {

                String dial="tel:"+call;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
            else
                Toast.makeText(this,"Permission Denied",Toast.LENGTH_SHORT).show();
        }

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
        getMenuInflater().inflate(R.menu.main6, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
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
