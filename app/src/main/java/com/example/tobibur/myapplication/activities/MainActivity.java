package com.example.tobibur.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.tobibur.myapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login_btn, recycler_btn, navdraw_btn, tab_btn, ui_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initWidgets();

        login_btn.setOnClickListener(this);
        recycler_btn.setOnClickListener(this);
        navdraw_btn.setOnClickListener(this);
        ui_btn.setOnClickListener(this);
        tab_btn.setOnClickListener(this);
    }

    private void initWidgets() {

        login_btn = findViewById(R.id.login_btn);
        recycler_btn = findViewById(R.id.card_btn);
        navdraw_btn = findViewById(R.id.nav_btn);
        ui_btn = findViewById(R.id.custom_ui_btn);
        tab_btn = findViewById(R.id.tab_nav_btn);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){

            case R.id.login_btn:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.card_btn:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;
            case R.id.nav_btn:
                startActivity(new Intent(this,NavDrawerActivity.class));
                break;
            case R.id.custom_ui_btn:
                startActivity(new Intent(this, UIActivity.class));
                break;
            case R.id.tab_nav_btn:
                startActivity(new Intent(this, TestTabActivity.class));
                break;
        }


    }
}
