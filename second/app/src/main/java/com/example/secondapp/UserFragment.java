package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserFragment extends Fragment {
    private User user;
    private int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //position = getActivity().getIntent().getIntExtra("position", 1);
        position = getArguments().getInt("position");
        user = Users.get(getActivity()).getUserList().get(position);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, viewGroup, false);
        Button editBtn = view.findViewById(R.id.editBtn);
        Button deleteBtn = view.findViewById(R.id.deleteBtn);
        TextView userInfo = view.findViewById(R.id.userInfo);
        Button backBtn = view.findViewById(R.id.backBtn);
        String text = "Name:" + user.getUserName() + "\n"
                + "Lastname:" + user.getUserLastName() + "\n"
                + "phone:"+ user.getPhone();
        userInfo.setText(text);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "UserFragment.click(editBtn)");
                Intent intent = new Intent(getActivity(), EditUserActivity.class);
                intent.putExtra("position", position);
                Log.d("DEBUG", "intent start EditUserActivity");
                startActivity(intent);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Users.get(getContext()).deleteUser(user.getUuid().toString());
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
