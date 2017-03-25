package com.adammcneilly.mhacks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView myImageView = (ImageView) findViewById(R.id.my_image);
        Button myButton = (Button) findViewById(R.id.my_button);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to move from MainActivity to BrandActivity
                Intent intent = new Intent(MainActivity.this, BrandActivity.class);
                startActivity(intent);
            }
        });
    }
}
