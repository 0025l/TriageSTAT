package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void launchPertanyaan1Activity(View view) {
        Intent intent = new Intent(this, pertanyaan1Activity.class);
        startActivity(intent);
    }

    public void launchLoginActivity(View view) {
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
    public void launchDataKorban(View view) {
        Intent intent = new Intent(this, dataKorban.class);
        startActivity(intent);
    }
    public void launchPanduan(View view) {
        Intent intent = new Intent(this, Panduan.class);
        startActivity(intent);
    }
    public static Intent getActIntent(Activity activity) {



        return new Intent(activity, HomeActivity.class);

    }

    public void tentangg(View view) {
        Intent intent = new Intent(this, Tentang.class);
        startActivity(intent);
    }
}
