package com.example.mobile_programming;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtEmail, edtPass;
    private AppCompatButton btnSignIn;
    private Toolbar toolbar;
    private TextView txtBCA, txtWelcome, txtForgot, txtAlready, txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_login_layout);
        initToolbar();
        findView();

    }


    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Login Page");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.cart){
            Toast.makeText(this, "Cart Icon clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.search) {
            Toast.makeText(this, "Search Icon clicked", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId()==R.id.setting) {
            Toast.makeText(this, "Setting icon clicked", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }

    private void findView() {
        edtEmail = findViewById(R.id.edtEmail);
        edtPass = findViewById(R.id.edtPass);
        txtForgot = findViewById(R.id.txtForgot);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtSignUp = findViewById(R.id.txtSignUp);
        txtBCA = findViewById(R.id.txtBCA);
        btnSignIn.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
//        btnSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(edtEmail.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty())
//                    ;
//            }
//        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSignIn) {
            if(edtEmail.getText().toString().isEmpty() || edtPass.getText().toString().isEmpty()){

                if (edtEmail.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty() ){
                    Toast.makeText(this, "Please enter Email", Toast.LENGTH_LONG).show();
                }
                else if (edtPass.getText().toString().isEmpty() && !edtEmail.getText().toString().isEmpty() ){
                    Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Please enter Email and Password", Toast.LENGTH_LONG).show();

                }
            }
            else if (!edtEmail.getText().toString().isEmpty() && !edtPass.getText().toString().isEmpty()) {
                Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
                Toast.makeText(this, "You have logged in", Toast.LENGTH_LONG).show();
//            intent.putExtra("Email",edtEmail.getText().toString().trim());
//                intent.putExtra("Email", "Email Address");
                startActivity(intent);
//            startActivityForResult(intent,100);


            }



        } else if (view.getId() == R.id.txtSignUp) {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
//            intent.putExtra("Email",edtEmail.getText().toString().trim());
//            intent.putExtra("Email", "Email Address");
            startActivity(intent);
//            startActivityForResult(intent,100);
//            signupActivityLauncher.launch(intent);


        }
    }

    ActivityResultLauncher<Intent> signupActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        Toast.makeText(LoginActivity.this, data.getStringExtra("Result"), Toast.LENGTH_SHORT).show();
                    }
                }
            }

    );

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringExtra("" + ""), Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}