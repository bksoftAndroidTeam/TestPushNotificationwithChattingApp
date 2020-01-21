package com.example.singhkshitiz.letschat.Notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.singhkshitiz.letschat.R;

public class SendActivity extends AppCompatActivity {

    private TextView tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        tv_id = findViewById(R.id.tv_id);


    }
}
