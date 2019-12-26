package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Context;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TriaseKuningActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;
    private Context context;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText nama;
    private EditText usia;
    private EditText tmpt_tgl;
    private ImageView btSubmit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triase_kuning);
        nama = (EditText) findViewById(R.id.nama2);
        usia = (EditText) findViewById(R.id.usia2);
        tmpt_tgl = (EditText) findViewById(R.id.tmpt_tgl2);
        btSubmit1 = (ImageView) findViewById(R.id.save2);

        addListenerOnButton();

// inisialisasi fields EditText dan Button
        database = FirebaseDatabase.getInstance().getReference();


    }
    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup4);

        btSubmit1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) findViewById(selectedId);

                if (!isEmpty(nama.getText().toString()))

                    submitBerjalan(new Korban(nama.getText().toString(), radioSexButton.getText().toString(), usia.getText().toString(), tmpt_tgl.getText().toString(), "Kuning"));

                else

                    Snackbar.make(findViewById(R.id.save2), "Data Korban tidak boleh kosong", Snackbar.LENGTH_LONG).show();

                InputMethodManager imm = (InputMethodManager)

                        getSystemService(Context.INPUT_METHOD_SERVICE);

                imm.hideSoftInputFromWindow(

                        nama.getWindowToken(), 0);

            }


        });
    }

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    private boolean isEmpty(String s) {

// Cek apakah ada fields yang kosong, sebelum disubmit

        return TextUtils.isEmpty(s);

    }
    private void submitBerjalan(Korban korban) {

/**
 * Ini adalah kode yang digunakan untuk mengirimkan data ke Firebase Realtime Database
 * dan juga kita set onSuccessListener yang berisi kode yang akan dijalankan
 * ketika data berhasil ditambahkan

 */

        database.child("korban").push().setValue(korban).addOnSuccessListener(TriaseKuningActivity.this, new OnSuccessListener<Void>() {

            @Override

            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TriaseKuningActivity.this, HomeActivity.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
