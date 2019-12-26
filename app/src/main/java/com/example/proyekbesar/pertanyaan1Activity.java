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

public class pertanyaan1Activity extends AppCompatActivity {
    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;
    public String i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan1);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void launchPertanyaan2Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan2Activity.class);
        startActivity(intent);

    }

    public void launchPertanyaan3Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan3Activity.class);
        startActivity(intent);
    }
}
