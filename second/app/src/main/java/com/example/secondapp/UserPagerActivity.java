package com.example.secondapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class UserPagerActivity extends AppCompatActivity {
    private ViewPager userViewPager;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pager);
        userViewPager = findViewById(R.id.userViewPager);
        users = Users.get(this).getUserList();
        int position = getIntent().getIntExtra("position", 0);
        FragmentManager fragmentManager = getSupportFragmentManager();
        userViewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                User user = users.get(i);
                Bundle args = new Bundle();
                args.putInt("position", i);
                UserFragment fragment = new UserFragment();
                fragment.setArguments(args);
                return fragment;
            }

            @Override
            public int getCount() {
                return users.size();
            }
        });

        userViewPager.setCurrentItem(position);
    }
}