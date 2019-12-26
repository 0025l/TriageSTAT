package com.example.proyekbesar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Pertanyaan4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan4);
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void launchPertanyaan5Activity(View view) {
        Intent intent = new Intent(this, Pertanyaan5Activity.class);
        startActivity(intent);
    }

    public void launchBebaskanJalurNapas(View view) {
        Intent intent = new Intent(this, BebaskanPernapasanActivity.class);
        startActivity(intent);
    }

    public void ShowDialog(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Intruksi ")
                .setMessage("Lihat pernapasan korban apakah terhambat. apabila terhambat coba berikan pertolong dan bebaskan jalur pernapasan")
                .setPositiveButton("Paham", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        alert.show();
    }

}
