package com.mayank.e_commerce_app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mayank.e_commerce_app.Adapter.PopularAdapter;
import com.mayank.e_commerce_app.Domain.PopularDomain;
import com.mayank.e_commerce_app.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<PopularDomain>items=new ArrayList<>();

        items.add(new PopularDomain("T-Shirt-Black","","item_1",15,4,500));
        items.add(new PopularDomain("Watches","","item_2",150,4.2,1500));
        items.add(new PopularDomain("SmartPhones","","item_3",250,3.8,25000));
        items.add(new PopularDomain("LG Led ","","item_4",152,4.8,32000));


        recyclerViewPopular=findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterPopular=new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);

    }
}