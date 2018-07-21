package com.example.dell.firebase2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;

public class Main2Activity extends AppCompatActivity {
TextView textView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.txt);
        button = (Button)findViewById(R.id.sgo);
        FirebaseUser currentuser = MainActivity.mauth.getCurrentUser();
        Log.i("current user", currentuser.getEmail());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.mauth.signOut();

            }
        });
        Intent intent = getIntent();
        String mess = intent.getStringExtra("msg");
        textView.setText(mess);

    }
}
