package jecrc.d_ex2_list;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MyDesing extends BaseAdapter {
    Context context;
    ArrayList<String>name=new ArrayList<>();
    ArrayList<String>age=new ArrayList<>();
    LayoutInflater myLayout;
    public MyDesing(Context context, ArrayList<String>name, ArrayList<String>age){

        this.name=name;
        this.age=age;
        this.context=context;
        myLayout=LayoutInflater.from(this.context);
    }
    @Override
    public int getCount() {
        return name.size();
    }

    @Override
    public Object getItem(int i) {
        return name.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        viewGroup= (ViewGroup) myLayout.inflate(R.layout.degsin,null);

        TextView nm=(TextView)viewGroup.findViewById(R.id.textView);
        Button aag=(Button)viewGroup.findViewById(R.id.button);

        nm.setText(name.get(i));
        aag.setText(age.get(i));

        aag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent obj=new Intent(context,Display.class);
               context.startActivity(obj);
            }
        });

        return viewGroup;
    }
}
