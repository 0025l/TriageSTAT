package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pertanyaan8Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan8);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void launchTriaseMerahActivity(View view) {
        Intent intent = new Intent(this, TriaseMerahActivity.class);
        startActivity(intent);
    }

    public void launchPertanyaan9Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan9Activity.class);
        startActivity(intent);
    }
}
