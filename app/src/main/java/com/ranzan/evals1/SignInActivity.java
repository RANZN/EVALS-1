package com.ranzan.evals1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button btnSignIn;
    private TextView signUP;
    private ImageView back;

    public SignInActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        init();
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validName() && validPassword()) {
                    Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                    intent.putExtra("name", name.getText().toString());
                    startActivity(intent);
                }
            }
        });
        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        name = findViewById(R.id.etNameSignIn);
        password = findViewById(R.id.etPasswordSignIn);
        btnSignIn = findViewById(R.id.btnSignIN);
        signUP = findViewById(R.id.tvSignUP);
        back = findViewById(R.id.backSignIn);
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