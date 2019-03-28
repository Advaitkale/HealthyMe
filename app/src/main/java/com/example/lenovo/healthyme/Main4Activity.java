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
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Main4Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    String str1,str2,str3,str4;
    //float[] rain= {20.0f,19.0f,31.0f,30.0f};
    float[] rain= new float[4];
    Button b1;


    EditText et1,et2,et3,et4;


    String month[]={"Blood Glucose","Insulin","Hemoglobin","Cholesterol"};
    PieChart chart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);


        b1=(Button) findViewById(R.id.entr);
                chart=(PieChart) findViewById(R.id.PieChart);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);







        enterData();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                setUpPieCHart();
            }
        });

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


    public void enterData()
    {
        chart.setVisibility(View.GONE);
        et1=(EditText) findViewById(R.id.Gluco) ;
        et2=(EditText) findViewById(R.id.insulin);
        et3=(EditText) findViewById(R.id.haemo) ;
        et4=(EditText)findViewById(R.id.choles) ;

    }

    public void setUpPieCHart() {

        /*rain[0]=Float.parseFloat(et1.getText().toString());
        rain[1]=Float.parseFloat(et2.getText().toString());
        rain[2]=Float.parseFloat(et3.getText().toString());
        rain[3]=Float.parseFloat(et4.getText().toString());*/

       chart.setVisibility(View.VISIBLE);

        str1=et1.getText().toString();
        str2=et2.getText().toString();
        str3=et3.getText().toString();
        str4=et4.getText().toString();


        addData();
    }

    public void addData()
    {


        List<PieEntry> pieEntries=new ArrayList<>();
        rain[0]=Float.parseFloat(str1);
        rain[1]=Float.parseFloat(str2);
        rain[2]=Float.parseFloat(str3);
        rain[3]=Float.parseFloat(str4);

        for (int i=0;i<rain.length;i++)
        {
            pieEntries.add(new PieEntry(rain[i],month[i]));
        }
        PieDataSet pieDataSet=new PieDataSet(pieEntries,"Health Records");
         PieData data=new PieData(pieDataSet);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(data);
        chart.animateY(1000);
        chart.invalidate();

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
        getMenuInflater().inflate(R.menu.main4, menu);
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
