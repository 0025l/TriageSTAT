package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Pertanyaan2Activity extends AppCompatActivity {
    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;

//    String i = getIntent().getStringExtra("EXTRA_SESSION_ID");
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan2);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void launchPertanyaan4Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan4Activity.class);
        startActivity(intent);
    }
    public void launchPertanyaan6Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan6Activity.class);
        startActivity(intent);
    }
}
