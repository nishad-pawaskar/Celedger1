package com.example.celedger1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class XpnseAdaptor extends RecyclerView.Adapter<XpnseAdaptor.XpnseViewHolder> {

    //DECLARATIONS
    private String[] data;
    public XpnseAdaptor(String[] data)
    {
        this.data = data;
    }


    //VIEW HOLDER
    @NonNull
    @Override
    public XpnseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater Inflater = LayoutInflater.from(viewGroup.getContext());
        View view = Inflater.inflate(R.layout.xpense_list_layout, viewGroup, false);
        return new XpnseViewHolder(view);
    }

    //BIND THE VIEW TOGETHER
    @Override
    public void onBindViewHolder(@NonNull XpnseViewHolder xpnseViewHolder, int i) {
        String title = data[i];
        xpnseViewHolder.Xpnsetitle.setText(title);
    }


    //NUMBER OF ITEMS TO BE SHOWN IN THE VIEW
    @Override
    public int getItemCount()  {
        return data.length;
    }

    public class XpnseViewHolder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView Xpnsetitle;
        public XpnseViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon = (ImageView) itemView.findViewById(R.id.imgicon);
            Xpnsetitle = (TextView) itemView.findViewById(R.id.Xpnsetitle);
        }
    }

}
