package com.example.singhkshitiz.letschat.Notification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.singhkshitiz.letschat.R;
import com.example.singhkshitiz.letschat.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllUserListActivity extends AppCompatActivity {

    //https://www.youtube.com/watch?v=pm6W9k9CP64&list=PLGCjwl1RrtcRHjHyZAxm_Mq4qvtnundo0&index=3
    //part 3 ar নবচ19min
    private AllUserAdapter adapter;
    private DatabaseReference mUsersDatabaseReference;
    private List<Users> users_list = new ArrayList<>();
    private RecyclerView all_user_recycler_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user_list);

        all_user_recycler_view = findViewById(R.id.all_user_recycler_view);
        mUsersDatabaseReference= FirebaseDatabase.getInstance().getReference().child("users");

        mUsersDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                users_list.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                    Users users = dataSnapshot1.getValue(Users.class);
                    if (users != null){
                        users_list.add(users);
                        Toast.makeText(AllUserListActivity.this, "Test Toast", Toast.LENGTH_SHORT).show();
                    }
                }

                if (users_list.size()>0){
                    adapter = new AllUserAdapter(AllUserListActivity.this,users_list);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AllUserListActivity.this);
                    all_user_recycler_view.setLayoutManager(layoutManager);
                    all_user_recycler_view.setItemAnimator(new DefaultItemAnimator());
                    all_user_recycler_view.setAdapter(adapter);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
