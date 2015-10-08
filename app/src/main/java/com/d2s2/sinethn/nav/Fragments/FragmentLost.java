package com.d2s2.sinethn.nav.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.d2s2.sinethn.nav.Adapters.AdapterLost;
import com.d2s2.sinethn.nav.Leads.Lead;
import com.d2s2.sinethn.nav.R;


import java.util.ArrayList;

public class FragmentLost extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ArrayList<Lead> listLeadFirstCall = new ArrayList<>();
    private AdapterLost adapterLost;
    private RecyclerView LostFragRecycleView;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentLost.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentLost newInstance(String param1, String param2) {
        FragmentLost fragment = new FragmentLost();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentLost() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        adapterLost = new AdapterLost(getActivity());
        View view = inflater.inflate(R.layout.fragment_fragment_lost, container, false);
        LostFragRecycleView = (RecyclerView) view.findViewById(R.id.recLost);
        LostFragRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        LostFragRecycleView.setAdapter(adapterLost);
        return view;
    }


}
