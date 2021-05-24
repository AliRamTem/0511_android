package com.example.secondapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        //Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        Fragment fragment = createFragment();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainer, fragment)
                .commit();
    }
}
