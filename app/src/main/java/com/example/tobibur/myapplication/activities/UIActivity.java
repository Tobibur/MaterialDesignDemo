package com.example.tobibur.myapplication.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.tobibur.myapplication.R;


public class UIActivity extends AppCompatActivity {

    private static final String TAG = "UIActivity";

    Toolbar toolbar;
    BottomSheetBehavior sheetBehavior;
    LinearLayout layoutBottomSheet;
    Button btnBottomSheet;

    ImageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        btnBottomSheet = findViewById(R.id.btn_bottom_sheet);

        img1 = findViewById(R.id.item1);
        img2 = findViewById(R.id.item2);

        Glide.with(this).load(R.drawable.chickenfriedrice).into(img1);
        Glide.with(this).load(R.drawable.paneertikka).into(img2);

        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        /*
          bottom sheet state change listener
          we are changing button text when sheet changed state
          */
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        Log.d(TAG, "onStateChanged: STATE_HIDDEN");
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        //btnBottomSheet.setText("Close Sheet");
                        Log.d(TAG, "onStateChanged: STATE_EXPANDED");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        //btnBottomSheet.setText("Expand Sheet");
                        Log.d(TAG, "onStateChanged: STATE_COLLAPSED");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        Log.d(TAG, "onStateChanged: STATE_DRAGGING");
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        Log.d(TAG, "onStateChanged: STATE_SETTLING");
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                Log.d(TAG, "onSlide: Slided");
            }
        });
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.done_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_bottom_sheet) {
            toggleBottomSheet();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
