package com.example.tobibur.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.tobibur.myapplication.adapters.ViewPagerAdapter;
import com.example.tobibur.myapplication.fragments.OneFragment;
import com.example.tobibur.myapplication.fragments.TwoFragment;

public class TabLayoutActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        toolbar = findViewById(R.id.toolbar_tab);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.viewPager_id);
        tabLayout = findViewById(R.id.tabLayout_id);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new OneFragment(),"Recents");
        adapter.addFragment(new TwoFragment(),"Favorites");
        adapter.addFragment(new ThreeFragment(),"Nearby");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.phone);
        tabLayout.getTabAt(1).setIcon(R.drawable.heart_tab);
        tabLayout.getTabAt(2).setIcon(R.drawable.account);
    }
}
