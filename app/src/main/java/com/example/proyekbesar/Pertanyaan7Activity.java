package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pertanyaan7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan7);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


    public void launchTriaseMerahActivity(View view) {
        Intent intent = new Intent(this, TriaseMerahActivity.class);
        startActivity(intent);
    }

    public void launchPertanyaan8Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan8Activity.class);
        startActivity(intent);
    }
}
