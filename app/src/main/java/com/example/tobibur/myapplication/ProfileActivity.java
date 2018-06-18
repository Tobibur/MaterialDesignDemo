package com.example.tobibur.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    ImageView profile_dp;
    private TextView profile_name,profile_desc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_pro);
        setSupportActionBar(toolbar);

        profile_dp = findViewById(R.id.profileImg_id);
        profile_name = findViewById(R.id.pro_name);
        profile_desc = findViewById(R.id.pro_desc);


        Intent intent = getIntent();

        String pos = intent.getStringExtra("position");
        String name = intent.getStringExtra("ProfileName");
        String desc = intent.getStringExtra("ProfileDesc");

        profile_dp.setImageResource(Integer.parseInt(pos));
        profile_name.setText(name);
        profile_desc.setText(desc);

        Toast.makeText(this, name, Toast.LENGTH_LONG).show();

        /*switch (pos){

            case "0":
                profile_dp.setImageResource(R.drawable.a);
                break;
            case "1":
                profile_dp.setImageResource(R.drawable.b);
                break;
        }*/
    }
}
