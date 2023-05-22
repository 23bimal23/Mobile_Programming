package com.example.mobile_programming;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private int[] iconLists = {R.drawable.home, R.drawable.message, R.drawable.profile};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initToolbar();
        findview();



    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.notification_icon){
            Intent intent = new Intent(DashboardActivity.this, NotificationActivity.class);

            Toast.makeText(this, "Notification Icon clicked", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        } else if (item.getItemId()==R.id.account) {
            Intent intent = new Intent(DashboardActivity.this, AccountActivity.class);

            Toast.makeText(this, "Account Icon clicked", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Dashboard");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }
    private void findview(){
        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);
    }
}