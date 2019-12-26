package com.example.proyekbesar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pertanyaan3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan3);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void launchTriaseHijauActivity(View view) {
        Intent intent = new Intent(this, TriaseHijauActivity.class);
        startActivity(intent);
    }

    public void launchTriasePutihActivity(View view) {
        Intent intent = new Intent(this, TriasePutihActivity.class);
        startActivity(intent);
    }

    public void launchKategoriLukaActivity(View view) {
        Intent intent = new Intent(this, KategoriLukaActivity.class);
        startActivity(intent);
    }

    public void ShowDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Intruksi ")
                .setMessage("Lihat luka apakah parah / tidak")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alert.show();
    }
}
