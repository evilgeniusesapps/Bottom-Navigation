package com.evilgeniusesapps.bottomnavigation.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.evilgeniusesapps.bottomnavigation.R;
import com.evilgeniusesapps.bottomnavigation.fragments.FragmentOne;
import com.evilgeniusesapps.bottomnavigation.fragments.FragmentThree;
import com.evilgeniusesapps.bottomnavigation.fragments.FragmentTwo;
import com.evilgeniusesapps.bottomnavigation.interfaces.ChangeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements ChangeFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragment(FragmentOne.newInstance());
    }

    @Override
    protected void onStart() {
        super.onStart();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.tab_1:
                    setFragment(FragmentOne.newInstance());
                    break;
                case R.id.tab_2:
                    setFragment(FragmentTwo.newInstance());
                    break;
                case R.id.tab_3:
                    setFragment(FragmentThree.newInstance());
                    break;
            }
            return true;
        });
    }

    @Override
    public void setFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}