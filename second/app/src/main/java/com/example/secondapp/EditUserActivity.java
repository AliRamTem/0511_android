package com.example.secondapp;

import android.support.v4.app.Fragment;
import android.util.Log;

public class EditUserActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        Log.d("DEBUG", "EditUserActivity createFragment()");
        Fragment fragment = new EditUserFragment();
        return fragment;
    }
}
