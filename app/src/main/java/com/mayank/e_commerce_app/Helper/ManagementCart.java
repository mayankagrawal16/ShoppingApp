package com.mayank.e_commerce_app.Helper;

import android.content.Context;
import android.widget.Toast;

import com.mayank.e_commerce_app.Domain.PopularDomain;

import java.util.ArrayList;

public class ManagementCart {

    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {

        this.context = context;
        this.tinyDB=new TinyDB(context);
    }
    public void insertFood(PopularDomain item)
    {
        ArrayList<PopularDomain>listpop=getListCart();
        boolean existAlready=false;
        int n=0;
        for(int i=0;i<listpop.size();i++)
        {
            if(listpop.get(i).getTitle().equals(item.getTitle()));
            existAlready=true;
            n=i;
            break;
        }
        if(existAlready)
            listpop.get(n).setNumberInCart(item.getNumberInCart());
        else
            listpop.add(item);

        tinyDB.putListObject("CartList",listpop);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }
    public ArrayList<PopularDomain> getListCart()
    {
        return tinyDB.getListObject("CartList")
    }

}
