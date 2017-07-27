package com.example.varun.googlemaps;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//AIzaSyBjL-KygtswXbsKgfAiLtizU6Jt4bLb3wA

public class MainActivity extends FragmentActivity {
    Button button;
Intent intent;
    Fragment mapfragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //intent=new Intent(this,Mapfragment.class);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Mapfragment fragment=new Mapfragment();
                fragmentTransaction.add(R.id.mapfragment, fragment);
                fragmentTransaction.commit();
            }
        });

    }
}
