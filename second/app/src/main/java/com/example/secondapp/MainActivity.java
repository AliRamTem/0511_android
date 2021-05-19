package com.example.secondapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SYSTEM INFO: ","МЕТОД onCreate() запущен");
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        Users users = new Users();
        List<String> userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);

    }

    private class UserHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;

        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.activity_item, viewGroup, false));
            Log.d("SYSTEM INFO: ","Конструктор UserHolder");
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName) {
            itemTextView.setText(userName);
            Log.d("SYSTEM INFO: ","МЕТОД bind() UserHolder");
        }
    }

    private class UserAdapter extends RecyclerView.Adapter<UserHolder> {
        List<String> userList;
        public UserAdapter(List<String> userList) {
            Log.d("SYSTEM INFO: ","Конструктор UserAdapter");
            this.userList = userList;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Log.d("SYSTEM INFO: ","МЕТОД onCreateViewHolder() UserHolder");
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            return new UserHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            Log.d("SYSTEM INFO: ","МЕТОД onBindViewHolder() UserHolder");
            String userName = userList.get(position);
            userHolder.bind(userName);

        }

        @Override
        public int getItemCount() {
            Log.d("SYSTEM INFO: ","МЕТОД getItemCount() UserHolder");
            return userList.size();
        }
    }
}