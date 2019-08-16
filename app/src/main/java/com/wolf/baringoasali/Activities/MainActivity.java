package com.wolf.baringoasali.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.wolf.baringoasali.R;

public class MainActivity extends AppCompatActivity {

    private TextView logo;
    private TextView signin;
    private TextView create;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.wolf);
        signin = findViewById(R.id.signin);
        create = findViewById(R.id.Create);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);


    }
}
