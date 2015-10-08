package com.d2s2.sinethn.nav.ViewLead;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.d2s2.sinethn.nav.Alarm.MainActivityAlarm;
import com.d2s2.sinethn.nav.Fragments.FragmentFirstCall;
import com.d2s2.sinethn.nav.Fragments.FragmentInitiated;
import com.d2s2.sinethn.nav.Fragments.FragmentLost;
import com.d2s2.sinethn.nav.Fragments.ProspectiveFragment;
import com.d2s2.sinethn.nav.Fragments.WonFragment;
import com.d2s2.sinethn.nav.NavigationDrawerFragment;
import com.d2s2.sinethn.nav.R;
import com.d2s2.sinethn.nav.SelectedLead;
import com.d2s2.sinethn.nav.SlidingTabLayout;

public class view_lead extends ActionBarActivity {
    private Toolbar toolbar;
    private ViewPager mPager;
    private SlidingTabLayout mtabs;
    private final int FIRSTCALL = 0;
    private final int INITIATED = 1;
    private final int PROSPECTIVE = 2;
    private final int WON = 3;
    private final int LOST = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_lead);
        toolbar = (Toolbar) findViewById(R.id.app_bar_view_lead);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigate_drawer_view_lead);
        drawerFragment.setUp(R.id.fragment_navigate_drawer_view_lead, (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawer_layout_view_lead), toolbar);
        mPager = (ViewPager) findViewById(R.id.pager_view_lead);
        mPager.setAdapter(new myPagerAdapter(getSupportFragmentManager()));
        mtabs = (SlidingTabLayout) findViewById(R.id.tabs_view_lead);
        mtabs.setDistributeEvenly(true);
        mtabs.setCustomTabView(R.layout.custom_tab_view, R.id.tabText);
        mtabs.setViewPager(mPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_lead, menu);
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
        if (id==R.id.add){
            startActivity(new Intent(this, MainActivityAlarm.class));
        }

        return super.onOptionsItemSelected(item);
    }

    public static class View_Lead_Fragment extends Fragment {
        private TextView textView;

        public static View_Lead_Fragment getInstance(int position) {
            View_Lead_Fragment viewLeadFragment = new View_Lead_Fragment();
            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            viewLeadFragment.setArguments(bundle);
            return viewLeadFragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View layout = inflater.inflate(R.layout.fragment_tabs, container, false);
            textView = (TextView) layout.findViewById(R.id.position);
            Bundle bundle = getArguments();
            if (bundle != null) {
                textView.setText("Page Selected is " + bundle.getInt("position"));
            }
            return layout;
        }


    }

    public class myPagerAdapter extends FragmentStatePagerAdapter {
        String[] tabs;

        public myPagerAdapter(FragmentManager fm) {
            super(fm);
            tabs = getResources().getStringArray(R.array.tabs_view_lead);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment myFragment = null;

            switch (position) {
                case FIRSTCALL:
                    myFragment = FragmentFirstCall.newInstance("", "");
                    break;
                case INITIATED:
                    myFragment = FragmentInitiated.newInstance("","");
                    break;
                case PROSPECTIVE:
                    myFragment=ProspectiveFragment.newInstance("","");
                    break;
                case WON:
                    myFragment=WonFragment.newInstance("","");
                    break;
                case LOST:
                    myFragment=FragmentLost.newInstance("","");


            }
          return myFragment;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabs[position];
        }

        @Override
        public int getCount() {
            return 5;
        }

    }
}
