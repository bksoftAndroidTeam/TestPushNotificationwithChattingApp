package com.example.singhkshitiz.letschat.Notification;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
    public void onBindViewHolder(@NonNull AllUserHolder holder, int position) {
        users = usersList.get(position);
        holder.textViewSingleListName.setText(users.getName());
        holder.textViewSingleListStatus.setText(users.getStatus());

        Picasso.with(context).load(users.getImage()).placeholder(R.drawable.user_img).into(holder.circleImageViewUserImage);


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class AllUserHolder extends RecyclerView.ViewHolder{

        TextView textViewSingleListName;
        TextView textViewSingleListStatus;
        CircleImageView circleImageViewUserImage;

        public AllUserHolder(@NonNull View itemView) {
            super(itemView);
            textViewSingleListName = itemView.findViewById(R.id.textViewSingleListName);
            textViewSingleListStatus = itemView.findViewById(R.id.textViewSingleListStatus);
            circleImageViewUserImage = itemView.findViewById(R.id.circleImageViewUserImage);
        }
    }
}
