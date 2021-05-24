package com.example.secondapp;

import android.support.v4.app.Fragment;

public class UserActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        Fragment fragment = new UserFragment();
        return fragment;
    }
}
