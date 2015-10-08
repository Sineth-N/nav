package com.d2s2.sinethn.nav;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Sineth N on 8/14/2015.
 */
public class RecAdapter extends RecyclerView.Adapter<RecAdapter.MyviewHolder>{
    private LayoutInflater inflater;
    private List<Info> data= Collections.emptyList();
    private Context contex;
    private ClickListener clickListener;
    public RecAdapter(Context context,List<Info> data) {
       inflater= LayoutInflater.from(context);
        this.data=data;
        this.contex=context;
    }

    @Override
    public MyviewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view=inflater.inflate(R.layout.custom_row,viewGroup,false);
        MyviewHolder holder=new MyviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyviewHolder viewHolder, int i) {
        Info info=data.get(i);
        viewHolder.title.setText(info.getDescription());
        viewHolder.icon.setImageResource(info.getId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setListener(ClickListener listener){
        this.clickListener=listener;
    }

    class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView title;
        private ImageView icon;
        public MyviewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            title= (TextView) itemView.findViewById(R.id.listText);
            icon= (ImageView) itemView.findViewById(R.id.listImage);
        }

        @Override
        public void onClick(View v) {

            if(clickListener!=null){
                clickListener.itemClicked(v,getPosition());
            }
        }
    }

    public interface ClickListener extends com.d2s2.sinethn.nav.Interfaces.ClickListener {
        void itemClicked(View view,int postition);
    }
}
