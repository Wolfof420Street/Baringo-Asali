package com.wolf.baringoasali.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.wolf.baringoasali.R;

public class MainActivity extends AppCompatActivity {

    private TextView logo;
    private TextView signin;
    private TextView create;
    private EditText email;
    private EditText password;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener =  new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                mUser = firebaseAuth.getCurrentUser();

                if (mUser != null) {

                }
                Toast.makeText(MainActivity.this, "Not Signed In", Toast.LENGTH_LONG).show();
            }
        };

        logo = findViewById(R.id.wolf);
        signin = findViewById(R.id.signin);
        create = findViewById(R.id.Create);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(email.getText().toString()) && !TextUtils.isEmpty(password.getText().toString()));
                String emailField = email.getText().toString();
                String pwd = password.getText().toString();
                login(emailField, pwd);
            }
        });


    }

    private void login(String emailField, String pwd) {
        mAuth.signInWithEmailAndPassword(emailField, pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                } else
                    Toast.makeText(MainActivity.this, "Authentication Failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
