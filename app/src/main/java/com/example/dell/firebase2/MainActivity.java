package com.example.dell.firebase2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText editText1;
    EditText editText2;
    Button button;
    static FirebaseAuth mauth;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = (EditText)findViewById(R.id.em);
        editText2 = (EditText)findViewById(R.id.pss);
        button = (Button)findViewById(R.id.btn);
        mauth = FirebaseAuth.getInstance();
        intent = new Intent(this, Main2Activity.class);
        intent.putExtra("msg", "You are signed in");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signingin();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentuser = mauth.getCurrentUser();
        Log.i("user is", "logged in");
    }

    private void signingin() {
    String email = editText1.getText().toString();
    String pass = editText2.getText().toString();
    mauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()) {
                startActivity(intent);

                Log.i("user with", "email and password logged in");
            }
            else
                Log.i("problem in ", "signing up the user");
        }
    });

    }
}
