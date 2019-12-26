package com.example.proyekbesar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pertanyaan9Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan9);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


    public void launchTriaseKuningActivity(View view) {
        Intent intent = new Intent(this, TriaseKuningActivity.class);
        startActivity(intent);
    }


    public void launchTriaseMerahActivity(View view) {
        Intent intent = new Intent(this, TriaseMerahActivity.class);
        startActivity(intent);
    }

    public void launchPerintahSederhana(View view) {
        Intent intent = new Intent(this, PerintahSederhanaActivity.class);
        startActivity(intent);
    }

    public void ShowDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Intruksi ")
                .setMessage("Berikan perintah sederhana seperti, Angkat tanganmu, kedipkan mata. Lihat respon korban")
                .setPositiveButton("Paham", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alert.show();
    }
}
