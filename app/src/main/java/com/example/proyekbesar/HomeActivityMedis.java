package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivityMedis extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_medis);
    }


    public void launchDataKorbanMedis(View view) {
        Intent intent = new Intent(this, dataKorban.class);
        startActivity(intent);
    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();//logout
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
