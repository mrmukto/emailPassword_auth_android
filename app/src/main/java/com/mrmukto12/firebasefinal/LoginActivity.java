package com.mrmukto12.firebasefinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
private EditText emailEt,passEt;
private Button singin;
private TextView singup;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth=FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.eamilEtLogin);
        passEt=findViewById(R.id.passwordEtLogin);
        singin=findViewById(R.id.login);
        singup=findViewById(R.id.SingUp);

        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(LoginActivity.this,Register.class);
                startActivity(in);
            }
        });

        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=emailEt.getText().toString();
                String password=passEt.getText().toString();

                if (TextUtils.isEmpty(email)){
                    emailEt.setError("need");
                    return;
                }if (TextUtils.isEmpty(password)){
                    passEt.setError("neede");
                    return;
                }
                singIn(email,password);
            }
        });
    }

    private  void  singIn(String email,String password){

        auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(LoginActivity.this, "Register is not Successfully"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}