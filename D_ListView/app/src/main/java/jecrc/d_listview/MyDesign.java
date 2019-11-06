package jecrc.d_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDesign  extends BaseAdapter {

    ArrayList<String>nm=new ArrayList<>();
    ArrayList<String>mb=new ArrayList<>();
     LayoutInflater inf;
      Context cnt;

    public MyDesign(Context context, ArrayList<String>nm, ArrayList<String>mb){

          this.nm=nm;
          this.mb=mb;
          cnt=context;
          inf=LayoutInflater.from(cnt);

    }
    @Override
    public int getCount() {
        return nm.size();
    }

    @Override
    public Object getItem(int i) {
        return nm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

       viewGroup=(ViewGroup)inf.inflate(R.layout.desing_format,null);

        TextView name=(TextView)viewGroup.findViewById(R.id.textView);
        TextView mobile=(TextView)viewGroup.findViewById(R.id.textView2);

        name.setText(nm.get(i));
        mobile.setText(mb.get(i));


        return viewGroup;
    }
}
