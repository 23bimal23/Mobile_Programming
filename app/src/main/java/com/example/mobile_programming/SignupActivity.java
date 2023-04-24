package com.example.mobile_programming;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
String email="";

AppCompatButton btnSignUP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnSignUP=findViewById(R.id.btnSignUP);
        email=getIntent().getStringExtra("Email");
        Log.d("Email Address", email);
   Toast.makeText(this, "email", Toast.LENGTH_SHORT).show();
   btnSignUP.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           Intent intent= new Intent();
           intent.putExtra("Result","Result Return");
           setResult(RESULT_OK,intent);
           finish();
       }
   });
    }
}