package com.keyeonacole.funny;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class funnyActivity extends AppCompatActivity {
    public static final String KEY_JOKE = "jokes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.funny_activity_main);

        //get joke
        Intent intent = getIntent();
        String joke = intent.getStringExtra(KEY_JOKE);

        //Set Views
        TextView jokeView = findViewById(R.id.android_lib_textview);
        jokeView.setText(joke);
    }

}
