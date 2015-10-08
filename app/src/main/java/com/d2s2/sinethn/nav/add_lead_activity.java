package com.d2s2.sinethn.nav;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import com.d2s2.sinethn.nav.Database.DBHelper;

import java.util.Calendar;


public class add_lead_activity extends ActionBarActivity {
    private DBHelper dbHelper;
    private EditText firstName,lastName,defaultTele,NIC,address,manufacturer,model,year,expected,capital;
    private MultiAutoCompleteTextView stage;
    private static final String[] stages = new String[] {
            "FIRST CALL ", "INITIATED ", "PROSPECTIVE ", "WON "
    };
    private Toolbar toolbar;

    private android.support.v7.app.AlertDialog.Builder alert;
    private static int vID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lead_activity);
        alert=new android.support.v7.app.AlertDialog.Builder(add_lead_activity.this);
        alert.setTitle("Invalid Data !");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, stages);
        MultiAutoCompleteTextView textView = (MultiAutoCompleteTextView) findViewById(R.id.stageSpinner);
        textView.setAdapter(adapter);
        textView.setThreshold(1);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        setTitle("ADD LEAD");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        firstName= (EditText) findViewById(R.id.firstNameET);
        lastName= (EditText) findViewById(R.id.LastNameET);
        defaultTele=(EditText) findViewById(R.id.telephoneDefaultET);
        stage= (MultiAutoCompleteTextView) findViewById(R.id.stageSpinner);
        address= (EditText) findViewById(R.id.addressET);
        manufacturer= (EditText) findViewById(R.id.BrandET);
        model= (EditText) findViewById(R.id.ModelET);
        year= (EditText) findViewById(R.id.yearET);
        expected= (EditText) findViewById(R.id.expectedvalueET);
        capital= (EditText) findViewById(R.id.capitalET);
        NIC= (EditText) findViewById(R.id.NICText);
        textView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        dbHelper=new DBHelper(this);
    }


    boolean validate(){

        if (defaultTele.getText().toString().length()<10){
            defaultTele.setText("");
            alert.setMessage("Error in Telephone number you entered");
            alert.setCancelable(true);
            alert.show();
            return false;
        }else if(!stage.getText().toString().equals("FIRST CALL , ")){
            stage.setText("");
            alert.setMessage("Error in Stage you entered");
            alert.setCancelable(true);
            alert.show();
            return false;
        }else if(NIC.getText().toString().length()!=9){
            NIC.setText("");
            alert.setMessage("Error in NIC No you entered");
            alert.setCancelable(true);
            alert.show();
            return false;
        }else if(1900 > Integer.valueOf(year.getText().toString()) | Integer.valueOf(year.getText().toString())> Calendar.getInstance().get(Calendar.YEAR)){
            year.setText("");
            alert.setMessage("Error in year you entered");
            alert.setCancelable(true);
            alert.show();
            return false;
        }else if(Integer.valueOf(capital.getText().toString())>Integer.valueOf(expected.getText().toString())){
            capital.setText("");
            expected.setText("");
            alert.setMessage("Error in Capital and Expected values you entered");
            alert.setCancelable(true);
            alert.show();
            return false;
        }
        return true;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_lead_activity, menu);
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
        if(id==R.id.home){

        }

        return super.onOptionsItemSelected(item);
    }

    public synchronized void SubmitAction(View view) {
//        if(validate()) {
//            dbHelper = new DBHelper(this);
//            SQLiteDatabase database = dbHelper.getWritableDatabase();
//            ContentValues values = new ContentValues();
//            values.put(DBHelper.FIRSTNAME, firstName.getText().toString());
//            values.put(DBHelper.TELEPHONE_NUMBER_PRIMARY, defaultTele.getText().toString());
//            values.put(DBHelper.NIC_NO, NIC.getText().toString());
//            values.put(DBHelper.SECONDNAME, lastName.getText().toString());
//            values.put(DBHelper.ADDRESS, address.getText().toString());
//            values.put(DBHelper.LEAD_ID, "-1");
//            values.put(DBHelper.STATUS, "0");
//          //  values.put(DBHelper.GENDER, 1);
//
//            values.put(DBHelper.BRAND,manufacturer.getText().toString());
//            values.put(DBHelper.MODEL, model.getText().toString());
//            values.put(DBHelper.CAPITAL, capital.getText().toString());
//            values.put(DBHelper.EXPECTED, expected.getText().toString());
//
//            ContentValues vehicleValues = new ContentValues();
//            vehicleValues.put(DBHelper.VEHICLE_ID, vID);
//            vehicleValues.put(DBHelper.OFFICER_ID, "007");
//            vehicleValues.put(DBHelper.LEAD_ID_VEHICLE, "-1");
//            vehicleValues.put(DBHelper.FTYPE_ID, "DIRECT");
//            vehicleValues.put(DBHelper.MODEL, model.getText().toString());
//            vehicleValues.put(DBHelper.CAPITAL, capital.getText().toString());
//            vehicleValues.put(DBHelper.REG_YEAR, year.getText().toString());
//            vehicleValues.put(DBHelper.EXPECTED, expected.getText().toString());
//            //vehicleValues.put(DBHelper.BRAND, manufacturer.getText().toString());
//            long i = 0;
//            long j = 0;
//            try {
//                i = database.insert(DBHelper.LEAD_TABLE, null, values);
//                j = database.insert(DBHelper.VEHICLE_TABLE, null, vehicleValues);
//
//            } catch (Exception e) {
//
//            }
//            if (i == -1 | j == -1) {
//                alert.setMessage("Error in data you entered \n please make sure that you are not duplicating records.");
//                alert.setCancelable(true);
//                alert.show();
//            } else
//                Message.message(getBaseContext(), "Successfully added to the database");
//                vID++;
//        }

    }

}
