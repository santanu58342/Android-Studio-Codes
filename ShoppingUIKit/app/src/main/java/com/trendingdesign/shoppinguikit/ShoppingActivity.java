package com.trendingdesign.shoppinguikit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.trendingdesign.shoppinguikit.Adapter.ShoppingAdapter;
import com.trendingdesign.shoppinguikit.Model.shopping;

import java.util.ArrayList;
/**
 * Created by trending design on 15/3/19.
 */
public class ShoppingActivity extends AppCompatActivity {

    private ArrayList<shopping> eShoppingModelClasses;
    private RecyclerView recyclerView;
    private ShoppingAdapter bAdapter;

    private String txt[]={"1.SplashScreen","2.SignUp Activity","3.SignIn Activity","4.Dashboard Activity","5.Navigation Activity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eshopping_list);

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShoppingActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        eShoppingModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            shopping beanClassForRecyclerView_contacts = new shopping(txt[i]);
            eShoppingModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new ShoppingAdapter(ShoppingActivity.this,eShoppingModelClasses);
        recyclerView.setAdapter(bAdapter);
    }
}
