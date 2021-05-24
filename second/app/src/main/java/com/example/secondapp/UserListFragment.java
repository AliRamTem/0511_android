package com.example.secondapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class UserListFragment extends Fragment {
    private Button addUser;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_user, viewGroup, false);
        addUser = view.findViewById(R.id.addUser);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddUserActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onResume(){
        super.onResume();
        recyclerViewInit();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }

    private void recyclerViewInit(){
        Users users = Users.get(getActivity());
        List<String> userList = users.getUserList();
        userAdapter = new UserAdapter(userList);
        recyclerView.setAdapter(userAdapter);
    }

    private class UserHolder extends RecyclerView.ViewHolder{
        TextView itemTextView;
        public UserHolder(LayoutInflater inflater, ViewGroup viewGroup) {
            super(inflater.inflate(R.layout.activity_item,viewGroup,false));
            //itemView - текущий layout activity_item
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
        public void bind(String userName){
            itemTextView.setText(userName);
        }
    }
    // UserAdapter нужен для того, чтобы разместить элементы на RecyclerView
    private class UserAdapter extends RecyclerView.Adapter<UserHolder>{
        List<String> userList;
        public UserAdapter(List<String> userList) {
            this.userList = userList;
        }

        @Override
        public UserHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            // inflater - наполнитель
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new UserHolder(inflater,viewGroup);
        }

        @Override
        public void onBindViewHolder(UserHolder userHolder, int position) {
            String userName = userList.get(position);
            userHolder.bind(userName);
        }

        @Override
        public int getItemCount() {
            return userList.size();
        }
    }
}
