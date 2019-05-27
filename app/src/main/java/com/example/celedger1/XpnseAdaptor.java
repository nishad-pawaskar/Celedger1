package com.example.celedger1;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class XpnseAdaptor extends RecyclerView.Adapter<XpnseAdaptor.XpnseViewHolder> {

    //DECLARATIONS
    public String xp_cat;
    public Float xp_amt;

    private Context xpContext;
    private Cursor xpCursor;

    public XpnseAdaptor(Context context, Cursor cursor)
    {
        xpContext = context;
        xpCursor = cursor;
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
        if(!xpCursor.moveToPosition(i)){
            return;
        }
        xp_cat = xpCursor.getString(xpCursor.getColumnIndex(CeledgerContract.XpenseEntry.CATEGORY));
        xp_amt = xpCursor.getFloat(xpCursor.getColumnIndex(CeledgerContract.XpenseEntry.AMOUNT));

        xpnseViewHolder.Xpnsetitle.setText(xp_cat);
        xpnseViewHolder.xp_amt.setText(String.valueOf(xp_amt));
    }


    //NUMBER OF ITEMS TO BE SHOWN IN THE VIEW
    @Override
    public int getItemCount()  {
        return xpCursor.getCount();
    }

    public void swapxpCursor(Cursor newCursor){
        if(xpCursor != null){
            xpCursor.close();
        }
        xpCursor = newCursor;
        if(newCursor != null){
            notifyDataSetChanged();
        }
    }

    public class XpnseViewHolder extends RecyclerView.ViewHolder{
        ImageView imgicon;
        TextView Xpnsetitle;
        TextView xp_amt;
        public XpnseViewHolder(@NonNull View itemView) {
            super(itemView);
            imgicon = itemView.findViewById(R.id.imgicon);
            Xpnsetitle = itemView.findViewById(R.id.Xpnsetitle);
            xp_amt = itemView.findViewById(R.id.xp_amt);
        }
    }

}
