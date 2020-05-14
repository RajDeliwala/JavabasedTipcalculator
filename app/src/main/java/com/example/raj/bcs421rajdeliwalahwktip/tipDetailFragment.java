package com.example.raj.bcs421rajdeliwalahwktip;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Created by Raj on 4/16/2017.
 */
public class tipDetailFragment extends Fragment {
    EditText restName;
    EditText tipAmount;
    EditText tipPct;
    EditText speed;
    EditText friend;
    EditText order;

    public tipDetailFragment(){};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int orientation = tipDetailFragment.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Intent intent;
            intent = getActivity().getIntent();
            int position;
            position = intent.getIntExtra("ArrayPosition", 0);
            tipData tip = Singleton.getInstance().getTipArray().get(position);
            tipFunction(tip);
            Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
        }
        else
        {
            Intent intent;
            intent = getActivity().getIntent();
            int position;
            position = intent.getIntExtra("ArrayPosition", 0);
            tipData tip = Singleton.getInstance().getTipArray().get(position);

            tipFunction(tip);
            Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
            //Singleton.getInstance().setArrayPostion(position);
                    /*tipDetailFragment fragment = new tipDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ArrayPosition", position);
                    fragment.setArguments(bundle);*/
        }
        return inflater.inflate(R.layout.detail_fragment, container, false);


    }/*
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Bundle bundle = this.getArguments();
        //int myKey = bundle.getInt("ArrayPosition",position);
        //int myKey = Singleton.getInstance().getArrayPostion();


        Intent intent;
        intent = getActivity().getIntent();
        int position;
        position = intent.getIntExtra("ArrayPosition", 0);

        //tipData tip = Singleton.getInstance().getTipArray().get(Singleton.getInstance().arrayPostion);
        tipData tip = Singleton.getInstance().getTipArray().get(position);
        tipFunction(tip);
        //Setting all of them with their respective IDs

    }*/
/*
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int orientation = tipDetailFragment.this.getResources().getConfiguration().orientation;
        if(orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Intent intent;
            intent = getActivity().getIntent();
            int position;
            position = intent.getIntExtra("ArrayPosition", 0);
            tipData tip = Singleton.getInstance().getTipArray().get(position);
            tipFunction(tip);
        }
        else
        {
            //Singleton.getInstance().setArrayPostion(position);
                    *//*tipDetailFragment fragment = new tipDetailFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt("ArrayPosition", position);
                    fragment.setArguments(bundle);*//*
        }
    }*/


    public void tipFunction(tipData tip)
    {
        restName = (EditText) getView().findViewById(R.id.resturantEditText);
        tipAmount = (EditText) getView().findViewById(R.id.tipAmountEditText);
        tipPct = (EditText) getView().findViewById(R.id.tipPercentEditText);
        speed = (EditText) getView().findViewById(R.id.speedDetailEditText);
        friend = (EditText) getView().findViewById(R.id.friendDetailEditText);
        order = (EditText) getView().findViewById(R.id.orderDetailEditText);

        //DecimalFormat form = new DecimalFormat("0.00");
        //String formatedTip = form.format(tipThis.getTipAmount());
        //restName.setText(Singleton.getInstance().getTipArray().get(myKey).getRestaurantName());
        restName.setText(tip.getRestaurantName());
        tipAmount.setText(String.valueOf(tip.getTipAmount()));
        tipPct.setText(String.valueOf(tip.getTipPercentage()));
        speed.setText(String.valueOf(tip.getSpeedService()));
        friend.setText(String.valueOf(tip.getFriendService()));
        order.setText(String.valueOf(tip.getAccuracyService()));
        /*
        tipAmount.setText(String.valueOf(Singleton.getInstance().getTipArray().get(myKey).getTipAmount()));
        tipPct.setText(String.valueOf(Singleton.getInstance().getTipArray().get(myKey).getTipPercentage()));
        speed.setText(String.valueOf(Singleton.getInstance().getTipArray().get(myKey).getSpeedService()));
        friend.setText(String.valueOf(Singleton.getInstance().getTipArray().get(myKey).getFriendService()));
        order.setText(String.valueOf(Singleton.getInstance().getTipArray().get(myKey).getAccuracyService()));*/

    }
}

