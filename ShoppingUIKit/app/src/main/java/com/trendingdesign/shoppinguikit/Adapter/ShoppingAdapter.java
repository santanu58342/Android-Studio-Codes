package com.trendingdesign.shoppinguikit.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trendingdesign.shoppinguikit.DashboardActivity;
import com.trendingdesign.shoppinguikit.LoginActivity;
import com.trendingdesign.shoppinguikit.Model.shopping;
import com.trendingdesign.shoppinguikit.NavigationActivity;
import com.trendingdesign.shoppinguikit.R;
import com.trendingdesign.shoppinguikit.SignupActivity;
import com.trendingdesign.shoppinguikit.SplashActivity;

import java.util.List;
/**
 * Created by trending design on 15/3/19.
 */
public class ShoppingAdapter extends RecyclerView.Adapter<ShoppingAdapter.MyViewHolder> {

    Context context;

    private List<shopping> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    public ShoppingAdapter(Context context, List<shopping> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public ShoppingAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_eshopping_list, parent, false);

        return new ShoppingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        shopping lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, SplashActivity.class);
                    context.startActivity(i);
                    ((Activity)context).finish();
                }else if (position == 1) {
                    Intent i = new Intent(context, SignupActivity.class);
                    context.startActivity(i);
                } else if (position == 2) {
                    Intent i = new Intent(context, LoginActivity.class);
                    context.startActivity(i);
                } else if (position == 3) {
                    Intent i = new Intent(context, DashboardActivity.class);
                    context.startActivity(i);
                } else if (position == 4) {
                    Intent i = new Intent(context, NavigationActivity.class);
                    context.startActivity(i);
                }
            }

        });
    }

    @Override
    public int getItemCount() {
        return OfferList.size();
    }
}


