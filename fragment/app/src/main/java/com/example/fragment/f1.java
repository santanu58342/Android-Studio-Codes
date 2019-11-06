package com.example.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class f1 extends Fragment{
    Button b1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflater=getLayoutInflater();
        container=(ViewGroup)inflater.inflate(R.layout.l1,null);
        b1=container.findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),record.class);
                startActivity(i);
                Toast.makeText(getContext(), "ok", Toast.LENGTH_SHORT).show();
            }
        });
        return container;
    }
}