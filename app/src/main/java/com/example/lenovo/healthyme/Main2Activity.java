package com.example.lenovo.healthyme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.common.api.GoogleApiClient;

public class Main2Activity extends AppCompatActivity {
    String to[]={"healthymehelps@gmail.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


     Button composeMail=(Button)findViewById(R.id.compose);
        composeMail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    emailCompose();
                }
            });

        }

    private void emailCompose() {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL,to);
        i.putExtra(Intent.EXTRA_SUBJECT,"Subject");
        i.putExtra(Intent.EXTRA_TEXT,"Body");
        i.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
        i.setType("text/html");
        i.setPackage("com.google.android.gm");
        startActivity(Intent.createChooser(i,"Send Email ..."));

    }


}


