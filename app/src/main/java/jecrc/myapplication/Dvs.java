package jecrc.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Dvs extends Fragment {

Context ref;
    ImageView imageView;
    Button k;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final  View v=inflater.inflate(R.layout.dvs,null);

        ref=getContext();
imageView=(ImageView)v.findViewById(R.id.imageView3);
k=(Button)v.findViewById(R.id.button2);

k.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent obj=new Intent(ref,Dvs_Activity.class);

        startActivity(obj);
    }
});

imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        navigation_itmes(new Dvs2());

        Toast.makeText(getActivity(), "Hello", Toast.LENGTH_SHORT).show();
    }
});

        return v;
    }


    public void navigation_itmes(Fragment frm){

        FragmentManager manager=getFragmentManager();
        FragmentTransaction transaction =manager.beginTransaction();
        transaction.replace(R.id.frame,frm);
        transaction.commit();

    }
}
