package com.example.singhkshitiz.letschat.Notification;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.singhkshitiz.letschat.R;
import com.example.singhkshitiz.letschat.Users;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AllUserAdapter extends RecyclerView.Adapter<AllUserAdapter.AllUserHolder>{

    private Users users;
    Context context;
    private List<Users> usersList = new ArrayList<>();


    public AllUserAdapter(Context context, List<Users> usersList) {
        this.context = context;
        this.usersList = usersList;
    }

    @NonNull
    @Override
    public AllUserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_single_user,parent,false);
        return new AllUserHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllUserHolder holder, final int position) {
        users = usersList.get(position);
        holder.textViewSingleListName.setText(users.getName());
        holder.textViewSingleListStatus.setText(users.getStatus());
        Picasso.with(context).load(users.getImage()).placeholder(R.drawable.user_img).into(holder.circleImageViewUserImage);

        holder.single_user_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SendActivity.class);
                intent.putExtra("user_name",usersList.get(position).getName());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    class AllUserHolder extends RecyclerView.ViewHolder{

        TextView textViewSingleListName;
        TextView textViewSingleListStatus;
        CircleImageView circleImageViewUserImage;
        RelativeLayout single_user_item;

        public AllUserHolder(@NonNull View itemView) {
            super(itemView);
            textViewSingleListName = itemView.findViewById(R.id.textViewSingleListName);
            textViewSingleListStatus = itemView.findViewById(R.id.textViewSingleListStatus);
            circleImageViewUserImage = itemView.findViewById(R.id.circleImageViewUserImage);

            single_user_item = itemView.findViewById(R.id.single_user_item);


        }
    }
}
