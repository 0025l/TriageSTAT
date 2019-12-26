package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Panduan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panduan);
    }
    public void alurtriase(View view) {
        Intent intent = new Intent(this, Alur.class);
        startActivity(intent);
    }
}
