package com.d2s2.sinethn.nav.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d2s2.sinethn.nav.Database.DBHelper;
import com.d2s2.sinethn.nav.Leads.Lead;
import com.d2s2.sinethn.nav.R;
import com.d2s2.sinethn.nav.SelectedLead;

import java.util.ArrayList;

/**
 * Created by Sineth N on 8/17/2015.
 */
public class AdapterWon extends RecyclerView.Adapter<AdapterWon.viewHolderWon>  {

    private ArrayList<Lead> leadArrayList_Won = new ArrayList<>();
    private LayoutInflater layoutInflater;

    private DBHelper dbHelper;
    private Context context;
    public Lead current;
    public AdapterWon(Context context) {
        layoutInflater = LayoutInflater.from(context);
        dbHelper=new DBHelper(context);
        current=new Lead();
        SQLiteDatabase database=dbHelper.getWritableDatabase();
//        String [] col={DBHelper.FIRSTNAME,DBHelper.TELEPHONE_NUMBER_PRIMARY, DBHelper.NIC_NO,DBHelper.LEAD_ID,DBHelper.ADDRESS,DBHelper.EXPECTED,DBHelper.CAPITAL,DBHelper.BRAND,DBHelper.MODEL};
        int status=4;
//        Cursor cursor=database.query(DBHelper.LEAD_TABLE,col,DBHelper.STATUS+" = '"+status+"'",null,null,null,null);
//        while(cursor.moveToNext()) {
//
//            current.setAddress(cursor.getString(cursor.getColumnIndex(DBHelper.ADDRESS)));
//            current.setLeadName(cursor.getString(cursor.getColumnIndex(DBHelper.FIRSTNAME)));
//            current.setPhoneNumberPrimary(cursor.getString(cursor.getColumnIndex(DBHelper.TELEPHONE_NUMBER_PRIMARY)));
//            current.setLeadID(cursor.getString(cursor.getColumnIndex(DBHelper.LEAD_ID)));
//
//            current.setBrand(cursor.getString(cursor.getColumnIndex(DBHelper.BRAND)));
//            current.setModel(cursor.getString(cursor.getColumnIndex(DBHelper.MODEL)));
//            current.setCapital(cursor.getString(cursor.getColumnIndex(DBHelper.CAPITAL)));
//            current.setExpected(cursor.getString(cursor.getColumnIndex(DBHelper.EXPECTED)));
//            //getVehicledata(database);
//            leadArrayList_Won.add(current);
//        }
//        cursor.close();
//        this.context=context;
    }
    public void setLeadArrayList_Won(ArrayList<Lead> leadArrayList_Won) {
        this.leadArrayList_Won = leadArrayList_Won;
    }

    @Override
    public viewHolderWon onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.lead_first_call_list, parent, false);
        viewHolderWon viewHolder_Won = new viewHolderWon(view);
        return viewHolder_Won;
    }

    public ArrayList<Lead> getLeadArrayList_Won() {
        return leadArrayList_Won;
    }

    @Override
    public void onBindViewHolder(viewHolderWon holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(new Intent(context, SelectedLead.class));
                intent.putExtra("LeadArray", getLeadArrayList_Won());
                intent.putExtra("Lead", position);
                intent.putExtra("Num",3);
                context.startActivity(intent);
            }
        });
        Lead currentLead = leadArrayList_Won.get(position);
        holder.leadNameTV.setText(currentLead.getLeadName());
        holder.leadIDTV.setText(String.valueOf(currentLead.getLeadID()));
        holder.phoneTV.setText(currentLead.getPhoneNumberPrimary());
        holder.VehicleTypeTV.setText(currentLead.getVehicleType());
    }

    @Override
    public int getItemCount() {
        return leadArrayList_Won.size();
    }
    static class viewHolderWon extends RecyclerView.ViewHolder {

        private TextView leadNameTV, VehicleTypeTV, phoneTV, leadIDTV;

        public viewHolderWon(View itemView) {
            super(itemView);
            leadNameTV = (TextView) itemView.findViewById(R.id.notifyNameTV);
//            VehicleTypeTV = (TextView) itemView.findViewById(R.id.VehicleTypeTV);
//            phoneTV = (TextView) itemView.findViewById(R.id.phoneTV);
//            leadIDTV = (TextView) itemView.findViewById(R.id.leadIDTV);


        }
    }
}
