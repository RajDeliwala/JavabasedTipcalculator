package com.example.raj.bcs421rajdeliwalahwktip;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * Created by Raj on 4/16/2017.
 */

public class tipListFragment extends Fragment{
    ArrayAdapter<tipData> tipDataArrayAdapter;
    tipData instance;


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view,savedInstanceState);
        tipDataArrayAdapter = new ArrayAdapter(getContext(),R.layout.list_item, Singleton.getInstance().getTipArray());
        ListView list = (ListView) getView().findViewById(R.id.firstListView);

        /*
        for(int i = 0; i < Singleton.getInstance().getTipArray().size(); i++) {
            Singleton.getInstance().getTipArray().get(i).getRestaurantName();

        }*/
        //To post the name


        Iterator<tipData> iter = Singleton.getInstance().getTipArray().iterator();
        while(iter.hasNext())
        {
            tipData instance = iter.next();
            instance.getRestaurantName();
        }
        /*
        tipDetailFragment fragment = new tipDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("ArrayPosition", 0);
        fragment.setArguments(bundle);*/

        final int orientation = this.getResources().getConfiguration().orientation;




        /*list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int orientation = tipListFragment.this.getResources().getConfiguration().orientation;

                if(orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    *//*tipDetailFragment fragment = new tipDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ArrayPosition", position);
                    fragment.setArguments(bundle);*//*
                    Singleton.getInstance().setArrayPostion(position);
                    Intent IntentLoadDetailActivity = new Intent(getActivity(),detailActivity.class);
                    startActivity(IntentLoadDetailActivity);

                }
                else
                {
                    Singleton.getInstance().setArrayPostion(position);
                    *//*tipDetailFragment fragment = new tipDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ArrayPosition", position);
                    fragment.setArguments(bundle);*//*


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });*/



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                //instance = Singleton.getInstance().getTipArray().get(position);
                //(ListActivity)getActivity().

                if(orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    //tipDetailFragment fragment = new tipDetailFragment();
                    //Bundle bundle = new Bundle();
                    //bundle.putInt("ArrayPosition", position);
                    //fragment.setArguments(bundle);
                    //Singleton.getInstance().setArrayPostion(position);
                    Intent IntentLoadDetailActivity = new Intent(getActivity(),detailActivity.class);
                    IntentLoadDetailActivity.putExtra("ArrayPosition",position);
                    startActivity(IntentLoadDetailActivity);
                }
                else
                {
                    Singleton.getInstance().setArrayPostion(position);
                    tipDetailFragment fragment = new tipDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ArrayPosition", position);
                    fragment.setArguments(bundle);
                }
            }
        });

        //Content






        list.setAdapter(tipDataArrayAdapter);
    }
}
