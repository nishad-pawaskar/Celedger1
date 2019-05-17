package com.example.celedger1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//CLASS FOR INCOME ADAPTOR
public class IncmeAdaptor extends RecyclerView.Adapter<IncmeAdaptor.IncmeViewHolder> {

    //DECLARATIONS
    private String[] data;
    public IncmeAdaptor(String[] data)
    {
        this.data = data;
    }


    //VIEW HOLDER
    @NonNull
    @Override
    public IncmeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater Inflater = LayoutInflater.from(viewGroup.getContext());
        View view = Inflater.inflate(R.layout.income_list_layout, viewGroup, false);
        return new IncmeViewHolder(view);
    }

    //BIND THE VIEW TOGETHER
    @Override
    public void onBindViewHolder(@NonNull IncmeViewHolder incmeViewHolder, int i) {
        String title = data[i];
        incmeViewHolder.Incmetitle.setText(title);

    }

    //NUMBER OF ITEMS TO BE SHOWN IN THE VIEW
    @Override
    public int getItemCount() {
        return data.length;
    }

    //CREATE A VIEW
    public class IncmeViewHolder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView Incmetitle;
        public IncmeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon = (ImageView) itemView.findViewById(R.id.imgicon);
            Incmetitle = (TextView) itemView.findViewById(R.id.Incmetitle);
        }
    }

}
