package com.d2s2.sinethn.nav.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d2s2.sinethn.nav.Leads.Lead;
import com.d2s2.sinethn.nav.R;

import java.util.ArrayList;

/**
 * Created by Sineth N on 8/19/2015.
 */
public class AdapterNotification  extends  RecyclerView.Adapter<AdapterNotification.viewHolderNotification>{

    private ArrayList<Lead> leadArrayList_Lost = new ArrayList<>();
    private LayoutInflater layoutInflater;

    public AdapterNotification(Context context) {
        layoutInflater=LayoutInflater.from(context);
        int i = 0;
        while (i < 15) {
            Lead lead = new Lead();
            lead.setLeadID("ef");
            lead.setLeadName("Lost"+i);
            lead.setPhoneNumberPrimary("21356");
            lead.setVehicleType("54");
            leadArrayList_Lost.add(lead);
            lead=null;
            i++;
        }
    }
    public void setLeadArrayList_Lost(ArrayList<Lead> leadArrayList_Lost) {
        this.leadArrayList_Lost = leadArrayList_Lost;
    }

    @Override
    public viewHolderNotification onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.notification, parent, false);
        viewHolderNotification viewHolder_Lost = new viewHolderNotification(view);
        return viewHolder_Lost;
    }

    @Override
    public void onBindViewHolder(viewHolderNotification holder, int position) {
        Lead currentLead = leadArrayList_Lost.get(position);
        holder.leadNameTV.setText(currentLead.getLeadName());
        holder.leadIDTV.setText(String.valueOf(currentLead.getLeadID()));
        holder.phoneTV.setText(currentLead.getPhoneNumberPrimary());
        holder.VehicleTypeTV.setText(currentLead.getVehicleType());
    }

    @Override
    public int getItemCount() {
        return leadArrayList_Lost.size();
    }
    static class viewHolderNotification extends RecyclerView.ViewHolder {

        private TextView leadNameTV, VehicleTypeTV, phoneTV, leadIDTV;

        public viewHolderNotification(View itemView) {
            super(itemView);
            leadNameTV = (TextView) itemView.findViewById(R.id.notifyNameTV);
//            VehicleTypeTV = (TextView) itemView.findViewById(R.id.VehicleTypeTV);
//            phoneTV = (TextView) itemView.findViewById(R.id.phoneTV);
//            leadIDTV = (TextView) itemView.findViewById(R.id.leadIDTV);


        }
    }
}
