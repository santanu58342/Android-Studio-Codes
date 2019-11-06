package jecrc.gridexample;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GetImageLoader extends BaseAdapter {

    LayoutInflater inf;
     Context cnt;
     ArrayList<Integer>img=new ArrayList<>();
     ArrayList<String>name=new ArrayList<>();
    public GetImageLoader(Context context, ArrayList<Integer> images,ArrayList<String>name) {
        cnt=context;
        img=images;
        this.name=name;
        inf=LayoutInflater.from(cnt);

    }

    @Override
    public int getCount() {
        return img.size();
    }

    @Override
    public Object getItem(int i) {
        return img.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       final View v=inf.inflate(R.layout.getimageloader,null);
        ImageView imageView=(ImageView)v.findViewById(R.id.imageView);
        TextView nm=v.findViewById(R.id.textView);
        imageView.setImageResource(img.get(i));
        nm.setText(name.get(i));
       return  v;
    }
}