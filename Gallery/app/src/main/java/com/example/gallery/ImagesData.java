package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImagesData extends BaseAdapter {

    ArrayList<Integer> images=new ArrayList<>();
    Context cnt;
    public ImagesData(Context context, ArrayList<Integer> images)
    {
        cnt=context;
        this.images=images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object getItem(int position) {
        return images.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView=new ImageView(cnt);
        imageView.setImageResource(images.get(position));
        return imageView;
    }
}
