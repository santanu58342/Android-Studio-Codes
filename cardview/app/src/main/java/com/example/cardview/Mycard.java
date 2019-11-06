package com.example.cardview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Mycard extends BaseAdapter {
    Context cnt;
    ArrayList<String>nm=new ArrayList<>();
    ArrayList<String>version=new ArrayList<>();
    ArrayList<Integer>img=new ArrayList<>();
    LayoutInflater inflater;
    public Mycard(Context cnt,ArrayList<String> nm,ArrayList<String> version,ArrayList<Integer> img){
        this.cnt=cnt;
        this.nm=nm;
        this.version=version;
        this.img=img;
        inflater=LayoutInflater.from(cnt);
    }
    @Override
    public int getCount() {
        return nm.size();
    }

    @Override
    public Object getItem(int position) {
        return nm.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        parent= (ViewGroup) inflater.inflate(R.layout.card_design,null);
        ImageView imageview=parent.findViewById(R.id.imageView);
        TextView name=parent.findViewById(R.id.t1);
        TextView version1=parent.findViewById(R.id.t2);
        imageview.setImageResource(img.get(position));
        name.setText(nm.get(position));
        version1.setText(version.get(position));
        return parent;
    }
}
