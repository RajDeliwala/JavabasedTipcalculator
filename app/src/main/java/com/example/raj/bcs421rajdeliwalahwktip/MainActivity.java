package com.example.raj.bcs421rajdeliwalahwktip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton tipButton;
    ImageButton helpButton;
    ImageButton listButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declaring the new image buttons
        tipButton = (ImageButton) findViewById(R.id.tip_image_button);
        helpButton = (ImageButton) findViewById(R.id.help_image_button);
        listButton = (ImageButton) findViewById(R.id.list_image_view);

        //Creating
        tipButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLoadtip = new Intent (MainActivity.this,tipActivity.class);
                startActivity(IntentLoadtip);
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLoadhelp = new Intent (MainActivity.this,helpActivity.class);
                startActivity(IntentLoadhelp);
            }
        });

        listButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent IntentLoadList = new Intent (MainActivity.this, listActivity.class );
                startActivity(IntentLoadList);
            }
        });
    }
}
