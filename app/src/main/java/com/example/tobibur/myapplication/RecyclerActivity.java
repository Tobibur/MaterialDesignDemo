package com.example.tobibur.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.example.tobibur.myapplication.adapters.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String[] name_array = {
            "User 1",
            "User 2",
            "User 3",
            "User 4",
            "User 5",
            "User 6",
            "User 7",
            "User 8",
            "User 9",
            "User 10",
            "User 11",
    };

    String[] desc_array = {
            "Description 1",
            "Description 2",
            "Description 3",
            "Description 4",
            "Description 5",
            "Description 6",
            "Description 7",
            "Description 8",
            "Description 9",
            "Description 10",
            "Description 11",
    };

    int[] image_array = {

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_id);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView_id);

        List<User> sampleuser = new ArrayList<>();

        for (int i =0; i<name_array.length; i++){

            User user = new User();

            user.user_name = name_array[i];
            user.user_desc = desc_array[i];
            user.user_image = image_array[i];

            sampleuser.add(user);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new RecyclerAdapter(this,sampleuser));

    }
}