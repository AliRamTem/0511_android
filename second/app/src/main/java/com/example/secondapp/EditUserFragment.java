package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditUserFragment extends Fragment {
    private User user;
    private TextView textView;
    private Button updateBtn;
    private EditText nameText;
    private EditText lastNameText;
    private EditText phoneText;
    private int position;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG", "position = " + position);
        position = getActivity().getIntent().getIntExtra("position", 1);
        Log.d("DEBUG", "position = " + position);
        user = Users.get(getActivity()).getUserList().get(position);
        Log.d("DEBUG", "EditUserFragment.onCreate()");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        Log.d("DEBUG", "EditUserFragment.onCreateView()");
        View view = inflater.inflate(R.layout.fragment_user_edit, viewGroup, false);
        textView = view.findViewById(R.id.textViewUpdateForm);
        nameText = view.findViewById(R.id.editUpdateName);
        lastNameText = view.findViewById(R.id.editUpdateLastName);
        phoneText = view.findViewById(R.id.editUpdatePhone);
        updateBtn = view.findViewById(R.id.btnUpdate);
        nameText.setText(user.getUserName());
        lastNameText.setText(user.getUserLastName());
        phoneText.setText(user.getPhone());
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "EditUserFragment.onClick(updateBtn)");
                user.setUserName(nameText.getText().toString());
                user.setUserLastName(lastNameText.getText().toString());
                user.setPhone(phoneText.getText().toString());
                Users.get(getContext()).editUser(user);

                Intent intent = new Intent(getActivity(), UserActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


        return view;
    }
}
