package com.d2s2.sinethn.nav;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.d2s2.sinethn.nav.Fragments.Notification;
import com.d2s2.sinethn.nav.ViewLead.view_lead;


public class MainActivity extends ActionBarActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigate_drawer);
        drawerFragment.setUp(R.id.fragment_navigate_drawer, (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout), toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == R.id.navigate) {
            startActivity(new Intent(this, SecondActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public void onclick(View view) {
        int id = view.getId();
        if (id == R.id.leads) {
            startActivity(new Intent(this, add_lead_activity.class));
        }else if(id==R.id.Scheduler){
            startActivity(new Intent(this,Notifier.class));
        }else if(id==R.id.view_leads){
            startActivity(new Intent(this, view_lead.class));
        }else if(id==R.id.Notifications){
            startActivity(new Intent(this,SecondActivity.class));
        }



    }
}
