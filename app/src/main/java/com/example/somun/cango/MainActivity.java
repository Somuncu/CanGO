package com.example.somun.cango;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CardView butt2 = (CardView)findViewById(R.id.button2);
        CardView butt3 = (CardView)findViewById(R.id.button3);
        CardView butt4 = (CardView)findViewById(R.id.button4);
        CardView butt5 = (CardView)findViewById(R.id.button5);
        CardView butt6 = (CardView)findViewById(R.id.button6);
        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1= new Intent(MainActivity.this,Comment.class);
                startActivity(int1);
            }
        });
        butt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1= new Intent(MainActivity.this,Complaint.class);
                startActivity(int1);
            }
        });
        butt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1= new Intent(MainActivity.this,Rate.class);
                startActivity(int1);
            }
        });
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1= new Intent(MainActivity.this,Alert.class);
                startActivity(int1);
            }
        });
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1= new Intent(MainActivity.this,SomunMap.class);
                startActivity(int1);
            }
        });



    }
}
