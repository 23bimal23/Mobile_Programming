package com.example.mobile_programming;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editEmail, editPassword;
    private AppCompatButton btnLogin;
    private Toolbar toolbar;
    private TextView txtForget, txtSignup, txtWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_login_layout);
        initToolbar();
        findViews();
    }

    private void initToolbar(){
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Login Page");
    }
    private void findViews() {
        txtWelcome = findViewById(R.id.txtWelcome);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtForget = findViewById(R.id.txtForget);
        txtSignup = findViewById(R.id.txtSignup);
        btnLogin.setOnClickListener(this);
        txtSignup.setOnClickListener(this);

//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!editEmail.getText().toString().isEmpty()&& !editPassword.getText().toString().isEmpty()){
//
//                }
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnLogin) {
        } else if (view.getId() == R.id.txtSignup) {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            intent.putExtra("Email",editEmail.getText().toString().trim());
            intent.putExtra("Email","Email Address");
//            startActivityForResult(intent,100);
//            startActivity(intent);
//            finish();
            signupActivityLauncher.launch(intent);
        }
    }
    ActivityResultLauncher<Intent> signupActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()== Activity.RESULT_OK){
                        //There are no result code
                        Intent data = result.getData();
                        Toast.makeText(LoginActivity.this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show();
                    }
                }
            });

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringExtra("" + ""), Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}