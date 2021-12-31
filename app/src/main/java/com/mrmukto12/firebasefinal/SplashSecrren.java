package com.mrmukto12.firebasefinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashSecrren extends AppCompatActivity {
private  FirebaseAuth auth;
private  FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_secrren);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();


         CountDownTimer c=new CountDownTimer(6000,1000) {
             @Override
             public void onTick(long millisUntilFinished) {

             }

             @Override
             public void onFinish() {
                 startApp();
             }
         }.start();
   }

   private  void  startApp(){

        if (user !=null){
            startActivity(new Intent(SplashSecrren.this,MainActivity.class));

        }else {

            startActivity(new Intent(SplashSecrren.this,Register.class));

        }
        finish();

   }
}