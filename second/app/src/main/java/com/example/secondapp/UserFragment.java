package com.example.secondapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserFragment extends Fragment {
    private User user;
    private TextView userInfo;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = new User();
        user.setUserName("USER");
        user.setUserLastName("USER_LASTNAME");
        user.setPhone("79850745631");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, viewGroup, false);
        userInfo = view.findViewById(R.id.userInfo);
        userInfo.setText(user.getUserName() + " " + user.getUserLastName() + "\n" + user.getPhone());
        return view;
    }
}
