package com.ranzan.evals1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    private EditText email;
    private EditText name;
    private EditText password;
    private Button SignUp;
    private TextView SignIn;
    private String validE = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validName() && validEmail() && validPassword()) {
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    startActivity(intent);
                }
            }
        });
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void init() {
        email = findViewById(R.id.etEmail);
        name = findViewById(R.id.etName);
        password = findViewById(R.id.etPassword);
        SignUp = findViewById(R.id.btnSignUP);
        SignIn = findViewById(R.id.tvSignIn);
        back = findViewById(R.id.backSignUP);
    }

    private boolean validEmail() {
        if (email.getText().toString().matches(validE))
            return true;
        else {
            email.setError("Invalid Email");
            return false;
        }
    }

    private boolean validName() {
        if (name.getText().toString().length() > 4)
            return true;
        else {
            name.setError("Minimum 4 character needed");
            return false;
        }
    }

    private boolean validPassword() {
        if (password.getText().toString().length() > 6)
            return true;
        else {
            password.setError("Password is weak");
            return false;
        }
    }
}