package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class f1 extends Fragment {
    Button b11;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        container=(ViewGroup)inflater.inflate(R.layout.f1,null);
        b11=container.findViewById(R.id.b11);
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent obj=new Intent(getActivity(),Main2Activity.class);
                obj.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(obj);
            }
        });
        return container;
    }
}
