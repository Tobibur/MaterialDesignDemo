package com.example.tobibur.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.tobibur.myapplication.activities.ProfileActivity;
import com.example.tobibur.myapplication.R;
import com.example.tobibur.myapplication.model.User;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<User> users;
    Context context;

    public RecyclerAdapter(Context context, List<User> users) {

        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

        final User sampleUser = users.get(position);
        viewHolder.pro_name.setText(sampleUser.user_name);
        viewHolder.pro_desc.setText(sampleUser.user_desc);
        //viewHolder.profile.setImageResource(sampleUser.user_image);
        Glide.with(context).load(sampleUser.user_image).into(viewHolder.profile);

        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Toast.makeText(context, "Item "+position+" clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, ProfileActivity.class);
                intent.putExtra("position",String.valueOf(sampleUser.user_image));
                intent.putExtra("ProfileName",sampleUser.user_name);
                intent.putExtra("ProfileDesc",sampleUser.user_desc);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return users.size();
    }
}
