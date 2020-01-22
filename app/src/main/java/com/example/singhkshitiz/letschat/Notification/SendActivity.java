package com.example.singhkshitiz.letschat.Notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.singhkshitiz.letschat.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;

public class SendActivity extends AppCompatActivity {

    private TextView tv_id;
    private String mName;
    private EditText notification_msg;
    private Button send_btn;

    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private String mCurrentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        databaseReference = FirebaseDatabase.getInstance().getReference("msgNotification");

        firebaseAuth = FirebaseAuth.getInstance();
        mCurrentId = firebaseAuth.getCurrentUser().getUid();

        mName = getIntent().getStringExtra("user_name");
        tv_id = findViewById(R.id.user_name);
        tv_id.setText(mName);

        notification_msg = findViewById(R.id.notification_msg);
        send_btn = findViewById(R.id.send_btn);
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String msg = notification_msg.getText().toString().trim();



                if (!TextUtils.isEmpty(msg)){
                    firebaseAuth.getCurrentUser().getIdToken(true).addOnSuccessListener(new OnSuccessListener<GetTokenResult>() {
                        @Override
                        public void onSuccess(GetTokenResult getTokenResult) {
                            String token_id = getTokenResult.getToken();
                            Map<String,Object> notificationMessage = new HashMap<>();
                            notificationMessage.put("message",msg);
                            notificationMessage.put("from",mCurrentId);
                            notificationMessage.put("token_id",token_id);

                            databaseReference.push().setValue(notificationMessage);
                            notification_msg.setText("");
                            Toast.makeText(SendActivity.this, "Notification Send", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
