package com.example.raj.bcs421rajdeliwalahwktip;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class tipActivity extends AppCompatActivity {



    // Initialize the variables
    double speed;
    double friend;
    double order;
    double percent = 0;
    double amount = 0;
    double finalAmount;
    String restName;
    private tipData tipThis;
    private ArrayList<tipData> tipArrayThis;


    // Introducing each instance
    EditText userAmount;
    CheckBox speedCheck;
    RatingBar speedRating;
    CheckBox friendCheck;
    RatingBar friendRating;
    CheckBox orderCheck;
    SeekBar orderSeek;
    TextView seekPercent;
    TextView finalTip;
    TextView finalTipPercent;
    EditText restaurantName;
    Button saveButton;



    //Paste value into textView
    public void showValue()
    {
        /*percent = order + speed + friend;
        percent = Math.floor(amount * 100)/100;
        DecimalFormat form = new DecimalFormat("0.00");
        String finalText = form.format(amount);
        finalTip.setText("$"+finalText);
        amount = Double.parseDouble(String.valueOf(userAmount.getText()));
        */
        try {
            amount = Double.parseDouble(String.valueOf(userAmount.getText()));
        }
        catch(Exception e)
        {
            //Could run a toast telling the user not to enter a 0 or a-z into the edit text but the toast duration is way too long
            //since the user can accidently spam a word with 4 letters which would be LENGTH_SHORT*4
            //Toast.makeText(this, "Must be a number & > 0", Toast.LENGTH_SHORT).show();
        }
        int amountBoxes = 0;
        if(speedCheck.isChecked())
        {
            speed = speedRating.getRating()/100;
            amountBoxes++;
        }
        else
        {
            speed = 0.00;
        }

        if(friendCheck.isChecked())
        {
            friend = friendRating.getRating()/100;
            amountBoxes++;
        }
        else
        {
            friend = 0.00;
        }

        if(orderCheck.isChecked())
        {
            double gettingProg = orderSeek.getProgress();
            order = gettingProg/2000;
            amountBoxes++;
        }
        else
        {
            order = 0.00;
        }

        //Now to check how many boxes are on
        if(amountBoxes == 0)
        {
            percent = .15;
        }
        if(amountBoxes == 1)
        {
            percent = (speed + friend + order) * 3;
        }
        if(amountBoxes == 2)
        {
            percent = (speed + friend + order) * 1.5;
        }
        if(amountBoxes == 3)
        {
            percent = (speed + friend + order);
        }
        finalAmount = amount * percent;
        DecimalFormat form = new DecimalFormat("0.00");
        String finalAmo = form.format(finalAmount);
        String finalText = form.format(percent*100);
        //finalTip.setText("$"+finalText);
        //finalAmount = (float) finalAmount;
        finalTip.setText("$"+String.valueOf(finalAmo));
        finalTipPercent.setText(String.valueOf(finalText)+"%");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);
        //Attaching each instance to it's ID
        userAmount = (EditText) findViewById(R.id.bill_text);
        speedCheck = (CheckBox) findViewById(R.id.speed_check);
        speedRating = (RatingBar) findViewById(R.id.speed_rating);
        friendCheck = (CheckBox) findViewById(R.id.friend_check);
        friendRating = (RatingBar) findViewById(R.id.friend_rating);
        orderCheck = (CheckBox) findViewById(R.id.order_check);
        orderSeek = (SeekBar) findViewById(R.id.orderSeekBar);
        seekPercent = (TextView) findViewById(R.id.order_seekValue);
        finalTip = (TextView) findViewById(R.id.tipValue);
        finalTipPercent = (TextView) findViewById(R.id.tipPercent);
        restaurantName = (EditText) findViewById(R.id.restaurantNameEditText);
        saveButton = (Button) findViewById(R.id.tipSaveButton);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Setting restaurant name
                tipThis = new tipData();

                restName = String.valueOf(restaurantName.getText());
                tipThis.setRestaurantName(restName);
                tipThis.setBillAmount(amount);
                tipThis.setTipPercentage(percent);
                tipThis.setTipAmount(finalAmount);
                tipThis.setSpeedService(speed);
                tipThis.setFriendService(friend);
                tipThis.setAccuracyService(order);

                DecimalFormat form = new DecimalFormat("0.00");
                String formatedTip = form.format(tipThis.getTipAmount());
                String formatedPercent = form.format(tipThis.getTipPercentage()*100);
                Context context = getApplicationContext();
                CharSequence text = "Added:"+tipThis.getRestaurantName()+"   $"+formatedTip+"  "+formatedPercent+"%";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Singleton.getInstance().getTipArray().add(tipThis);




                //ContentResolver cr = getContentResolver();
                //ContentValues rowData = new ContentValues();
            }
        });





























        // Below this is data from homework 3, and everything to calculate the tip


        userAmount.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                showValue();
            }
        });

        //set the false by default
        speedRating.setEnabled(false);

        speedCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(((CheckBox) v).isChecked())
                {
                    speedRating.setEnabled(true);
                    //Take these out into the onCreate, this and all other ratings
                    showValue();
                    speedRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
                    {
                        @Override
                        public void onRatingChanged(RatingBar ratingbar, float Rating, boolean fromUser)
                        {
                            showValue();
                        }
                    });
                }
                else
                {
                    showValue();
                    speedRating.setEnabled(false);
                }


            }
        });

        //Friendliness of server

        //set false by default
        friendRating.setEnabled(false);

        friendCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (((CheckBox) v).isChecked())
                {
                    friendRating.setEnabled(true);
                    showValue();
                    friendRating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
                    {
                        @Override
                        public void onRatingChanged(RatingBar ratingbar, float Rating, boolean fromUser)
                        {
                            showValue();
                        }
                    });
                }
                else
                {
                    showValue();
                    friendRating.setEnabled(false);
                }
            }
        });

        // Order accuracy

        //set to false by default
        seekPercent.setEnabled(false);
        orderSeek.setEnabled(false);

        orderCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (((CheckBox) v).isChecked())
                {
                    orderSeek.setEnabled(true);
                    seekPercent.setEnabled(true);
                    showValue();
                    orderSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
                    {
                        @Override
                        public void onProgressChanged(SeekBar seekbar, int progress, boolean fromUser)
                        {
                            seekPercent.setText(String.valueOf(progress)+"%");
                            showValue();
                        }
                        @Override
                        public void onStartTrackingTouch(SeekBar seekbar)
                        {
                            showValue();
                        }
                        @Override
                        public void onStopTrackingTouch(SeekBar seekbar)
                        {
                            showValue();
                        }
                    });
                }
                else
                {
                    showValue();
                    orderSeek.setEnabled(false);
                    seekPercent.setEnabled(false);

                }
            }
        });
    }
}
