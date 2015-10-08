package com.d2s2.sinethn.nav;


import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavigationDrawerFragment extends android.support.v4.app.Fragment implements RecAdapter.ClickListener {


    public static final String STRING_FILE_NAME = "testpref";
    private boolean isuserLearntDrawer;
    private boolean fromSavedState;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private View containerView;
    private static final String KEY_USER_LEARNED_DRAWER = "user_learnt_drawer";
    private RecyclerView recyclerView;
    private RecAdapter adapter;

    public NavigationDrawerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isuserLearntDrawer = Boolean.valueOf(readfromPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, "false"));
        if (savedInstanceState != null) {
            fromSavedState = true;
        }else {
            fromSavedState=false;
        }

    }

    public static ArrayList<Info> getData() {

        ArrayList<Info> data = new ArrayList<>();
        int[] iconArray = {R.mipmap.ic_new_account, R.mipmap.ic_cloud, R.mipmap.ic_about, R.mipmap.ic_label, R.mipmap.ic_settings, R.mipmap.ic_secure};
        String[] titles = {"My Account", "Cloud", "About Me", "Notifications", "Settings", "Self-Test"};
        for (int i = 0; i < iconArray.length && i < titles.length; i++) {
            Info current = new Info();
            current.setId(iconArray[i]);
            current.setDescription(titles[i]);
            data.add(current);
        }
        return data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_navigate_drawer, container, false);
        recyclerView = (RecyclerView) layout.findViewById(R.id.drawer);
        adapter = new RecAdapter(getActivity(), getData());
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return layout;
    }

    public void setUp(int fragment_navigate_drawer, DrawerLayout drawerLayout, Toolbar toolbar) {
        containerView = getActivity().findViewById(fragment_navigate_drawer);
        this.drawerLayout = drawerLayout;
        this.actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout,toolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (!isuserLearntDrawer) {
                    isuserLearntDrawer = true;
                    saveToPreferences(getActivity(), KEY_USER_LEARNED_DRAWER, isuserLearntDrawer + "");
                }
                getActivity().invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                    getActivity().invalidateOptionsMenu();
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {

                // Pass the event to ActionBarDrawerToggle, if it returns
                // true, then it has handled the app icon touch event
                if (actionBarDrawerToggle.onOptionsItemSelected(item)) {

                    return true;
                }
                // Handle your other action bar items...

                return super.onOptionsItemSelected(item);
            }
        };
        if (!isuserLearntDrawer && !fromSavedState) {
            drawerLayout.openDrawer(containerView);
        }
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(STRING_FILE_NAME, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }


    public static String readfromPreferences(Context context, String preferenceName, String defaultvalue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(STRING_FILE_NAME, context.MODE_PRIVATE);
        return sharedPreferences.getString(preferenceName, defaultvalue);

    }

    @Override
    public void itemClicked(View view, int postition) {

        if (postition == 0) {
           //TODO add touch launchers
        } else if (postition == 1) {
            startActivity(new Intent(getActivity(), SecondActivity.class));
        }

    }
}
