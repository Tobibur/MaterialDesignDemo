package com.example.tobibur.myapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tobibur.myapplication.R;

public class ViewHolder extends RecyclerView.ViewHolder{

    public ImageView profile;
    public TextView pro_name, pro_desc;
    public LinearLayout linearLayout;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        profile = itemView.findViewById(R.id.profileImg_id);
        pro_name = itemView.findViewById(R.id.profile_name);
        pro_desc = itemView.findViewById(R.id.profile_desc);
        linearLayout = itemView.findViewById(R.id.recItemLayout_id);
    }
}
