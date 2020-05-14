package com.example.raj.bcs421rajdeliwalahwktip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import static android.R.attr.button;

public class helpActivity extends AppCompatActivity {

    TextView scrollableText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);



        scrollableText = (TextView) findViewById(R.id.scrollTextview);
        scrollableText.setMovementMethod(new ScrollingMovementMethod());
    }
}
