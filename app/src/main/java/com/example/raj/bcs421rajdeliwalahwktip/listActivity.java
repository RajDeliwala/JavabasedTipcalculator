package com.example.raj.bcs421rajdeliwalahwktip;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;


/**
 * Created by Raj on 4/16/2017.
 */

public class listActivity extends Activity {
    //tipListFragment tipListFragment;
    //tipDetailFragment tipDetailFragment;

    public int returnPosition (int position)
    {
        return position;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiplist);

        int orientation = this.getResources().getConfiguration().orientation;
        Fragment fragment;

        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            fragment = new tipListFragment();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.listViewFrame, new tipListFragment());
            ft.commit();
        }
        else
        {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.listFragment_container, new tipListFragment());
            ft.add(R.id.listDetail_container, new tipDetailFragment());
            ft.commit();
        }

    }
}
