package com.example.realinsta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.realinsta.fragment.HomeFragment;
import com.example.realinsta.fragment.NotificationFragment;
import com.example.realinsta.fragment.ProfileFragment;
import com.example.realinsta.fragment.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private Fragment selectorFragment;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {

            switch (menuItem.getItemId()){
                case R.id.nav_home :
                    selectorFragment = new HomeFragment();
                    break;

                case R.id.nav_search :
                    selectorFragment = new SearchFragment();
                    break;

                case R.id.nav_add :
                    selectorFragment = null;
                    startActivity(new Intent(MainActivity.this , PostActivity.class));
                    break;

                case R.id.nav_heart :
                    selectorFragment = new NotificationFragment();
                    break;

                case R.id.nav_profile :
                    selectorFragment = new ProfileFragment();
                    break;
            }

            if (selectorFragment != null){
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container , selectorFragment).commit();
            }

            return  true;

        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

    }
}