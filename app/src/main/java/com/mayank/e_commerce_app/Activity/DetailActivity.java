package com.mayank.e_commerce_app.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mayank.e_commerce_app.Domain.PopularDomain;
import com.mayank.e_commerce_app.Helper.ManagementCart;
import com.mayank.e_commerce_app.R;

public class DetailActivity extends AppCompatActivity {

    private Button addToCartBtn;
    private TextView scoreTxt,feeTxt,titleTxt,descriptionTxt,reviewTxt;
    private ImageView backbtn,picItem;
    private PopularDomain object;
    private int numberOrder=1;
    private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object=(PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPicurl(),"drawable",this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        reviewTxt.setText(object.getReview()+"");
        scoreTxt.setText(object.getScore()+"");
        descriptionTxt.setText(object.getDescription());

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartbtn);
        scoreTxt=findViewById(R.id.scoreTxt);
        feeTxt=findViewById(R.id.priceTxt);
        titleTxt=findViewById(R.id.textView10);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        reviewTxt=findViewById(R.id.reviewTxt);
        backbtn=findViewById(R.id.backbtn);
        picItem=findViewById(R.id.itempic);
    }
}