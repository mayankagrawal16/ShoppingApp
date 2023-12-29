package com.mayank.e_commerce_app.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.mayank.e_commerce_app.Activity.DetailActivity;
import com.mayank.e_commerce_app.Domain.PopularDomain;
import com.mayank.e_commerce_app.R;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.Viewholder> {
    ArrayList<PopularDomain>items;
    Context context;

    public PopularAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View Inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list,parent,false);
        return new Viewholder(Inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.Viewholder holder, int position) {
        holder.titletxt.setText(items.get(position).getTitle());
        holder.feetxt.setText("$ "+items.get(position).getPrice());
        holder.scoretxt.setText(""+items.get(position).getScore());
        holder.reviewtxt.setText(""+items.get(position).getReview());

        /// Now to get picture url

        // this is important part..
        int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicurl(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new GranularRoundedCorners(30,30,0,0))
                .into(holder.pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(holder.itemView.getContext(), DetailActivity.class);
                i.putExtra("object", items.get(position));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView titletxt,feetxt,scoretxt,reviewtxt;
        ImageView pic;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            titletxt=itemView.findViewById(R.id.titletext);
            feetxt=itemView.findViewById(R.id.feetxt);
            scoretxt=itemView.findViewById(R.id.scoretxt);
            reviewtxt=itemView.findViewById(R.id.reviewtxt);
            pic=itemView.findViewById(R.id.pic);

        }
    }
}
