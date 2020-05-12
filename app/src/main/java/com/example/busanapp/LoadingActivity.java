package com.example.busanapp;
// 편의시설 네비 드로워 어플

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.busanapp.calendar.CalendarFragment;
import com.example.busanapp.navermap.BasicMap;
import com.example.busanapp.navermap.MainActivity3;
import com.example.busanapp.ui.home.FindFoodFragment;
import com.example.busanapp.ui.home.FoodFragment;
import com.example.busanapp.home.HomeFragment;
import com.example.busanapp.ui.home.PublicartFragment;
import com.example.busanapp.ui.home.StorytellingFragment;
import com.google.android.material.navigation.NavigationView;
import com.naver.maps.map.MapFragment;

public class LoadingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //HomeFragment fragment1;

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu menu = navigationView.getMenu();

        MenuItem conven= menu.findItem(R.id.conven);
        SpannableString s = new SpannableString(conven.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        conven.setTitle(s);


        MenuItem conven2= menu.findItem(R.id.conven2);
        SpannableString s1 = new SpannableString(conven2.getTitle());
        s1.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s1.length(), 0);
        conven2.setTitle(s1);


        MenuItem conven3= menu.findItem(R.id.conven3);
        SpannableString s2 = new SpannableString(conven3.getTitle());
        s2.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s2.length(), 0);
        conven3.setTitle(s2);


        MenuItem conven4= menu.findItem(R.id.conven4);
        SpannableString s3 = new SpannableString(conven4.getTitle());
        s3.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s3.length(), 0);
        conven4.setTitle(s3);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*Button hosbtn = (Button)findViewById(R.id.hosbtn);
        hosbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
            }
        });*/

        /*Button hosbtn = (Button)findViewById(R.id.hosbtn);
        hosbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.hospitalFragment, fragment1).commit();
            }
        });*/





        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_hospital:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HospitalFragment()).commit();
                break;
            case R.id.nav_find_hospital:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FindHospitalFragment()).commit();
                break;

            case R.id.nav_parking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ParkingFragment()).commit();
                break;

            case R.id.nav_bus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new BusFragment()).commit();
                break;
            case R.id.nav_disabled_person:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DisabledFragment()).commit();
                break;

            case R.id.nav_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FoodFragment()).commit();
                break;

            case R.id.nav_find_food:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FindFoodFragment()).commit();
                break;

            case R.id.nav_storytelling:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new StorytellingFragment()).commit();
                break;

            case R.id.nav_publicart:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new PublicartFragment()).commit();
                break;

            case R.id.nav_map :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapFragment()).commit();
            case R.id.nav_map2 :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapFragment()).commit();
            case R.id.nav_map3 :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapFragment()).commit();
            case R.id.nav_map4 :
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new MapFragment()).commit();



            default:
                break;
        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}