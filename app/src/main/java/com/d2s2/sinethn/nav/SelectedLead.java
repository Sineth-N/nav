package com.d2s2.sinethn.nav;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.d2s2.sinethn.nav.Database.DBHelper;
import com.d2s2.sinethn.nav.Leads.Lead;

import java.util.ArrayList;

public class SelectedLead extends ActionBarActivity {
    private TextView LeadID, Name, Vehicletype, telephone, manufacturerTV, modelTv, expectedTv, capitalTv;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_lead);
//        ArrayList<Lead> leadArray = (ArrayList<Lead>) getIntent().getSerializableExtra("LeadArray");
//        int leadPosition = (int) getIntent().getSerializableExtra("Lead");
//         num= (int) getIntent().getSerializableExtra("Num");
//        Lead lead = leadArray.get(leadPosition);
//      //  LeadID = (TextView) findViewById(R.id.fillLeadID);
//        Name = (TextView) findViewById(R.id.fillnameTV);
//     //   Vehicletype = (TextView) findViewById(R.id.vehicleTV);
//        telephone = (TextView) findViewById(R.id.filltelephoneprimaryTV);
//        manufacturerTV = (TextView) findViewById(R.id.brandTV);
//        modelTv = (TextView) findViewById(R.id.modelTV);
//      //  expectedTv = (TextView) findViewById(R.id.expectedTV);
//        capitalTv = (TextView) findViewById(R.id.capitalTV);
//        LeadID.setText(String.valueOf(lead.getLeadID()));
//        Name.setText(lead.getLeadName());
//        Vehicletype.setText(lead.getVehicleType());
//        telephone.setText(lead.getPhoneNumberPrimary());
//
//        manufacturerTV.setText(lead.getBrand());
//        modelTv.setText(lead.getModel());
//        expectedTv.setText(lead.getExpected());
//        capitalTv.setText(lead.getCapital());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selected_lead, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void moveUp(View view) {
//        if(num<4) {
//            DBHelper dbHelper = new DBHelper(getBaseContext());
//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//
//            ContentValues values = new ContentValues();
//            int j = num + 1;
//            Message.message(getBaseContext(),""+num);
//            values.put(DBHelper.STATUS, j);
//            String[] whereArgs = {String.valueOf(num), Name.getText().toString()};
//            int i = database.update(DBHelper.LEAD_TABLE, values, DBHelper.STATUS + " =? AND " + DBHelper.FIRSTNAME + " =? ", whereArgs);
//            if (i > 0) {
//                Message.message(getBaseContext(), "Successfully Moved Up");
//            } else
//                Message.message(getBaseContext(), "Failed to Move Up");
//
//        }else{
//            Message.message(getBaseContext(),"Cannot Increment further");
//        }
    }

    public void lostLead(View view) {
//        DBHelper dbHelper = new DBHelper(getBaseContext());
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(DBHelper.STATUS, "4");
//        String[] whereArgs = {"0", Name.getText().toString()};
//        int i = database.update(DBHelper.LEAD_TABLE, values, DBHelper.STATUS + " =? AND " + DBHelper.FIRSTNAME + " =? ", whereArgs);
//        if (i > 0) {
//            Message.message(getBaseContext(), "Lead Lost registered");
//        } else
//            Message.message(getBaseContext(), "Failed to Add to Lost Lead");
    }

    public void NoteAdd(View view) {
        startActivity(new Intent(view.getContext(), SecondActivity.class));
    }


    public void delete(View view) {

        //
//        new AlertDialog.Builder(this).setTitle("Delete Lead").setMessage("Are you Sure you want to delete this lead? ").setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                DBHelper dbHelper = new DBHelper(getBaseContext());
//                SQLiteDatabase database = dbHelper.getWritableDatabase();
//                String[] whereArgs = {Name.getText().toString()};
//                int i = 0;
//                try {
//                    i = database.delete(DBHelper.LEAD_TABLE, DBHelper.FIRSTNAME + " =? ", whereArgs);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                if (i > 0) {
//                    Message.message(getBaseContext(), "Deleted Lead Details");
//                } else
//                    Message.message(getBaseContext(), "Operation Failed.");
//            }
//        }).setNegativeButton(R.string.No, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        }).show();
    }
}
