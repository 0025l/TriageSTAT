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

public class TriaseHitamActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {
    private Context context;
    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;
    private EditText kejadian_sp;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText nama;
    private EditText usia;
    private EditText tmp_tgl;
    private ImageView btSubmit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triase_hitam);
        nama = (EditText) findViewById(R.id.nama1);
        usia = (EditText) findViewById(R.id.usia1);
        tmp_tgl = (EditText) findViewById(R.id.tmp_tgl1);
        btSubmit1 = (ImageView) findViewById(R.id.save1);

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

                    submitBerjalan(new Korban(nama.getText().toString(), radioSexButton.getText().toString(), usia.getText().toString(), tmp_tgl.getText().toString(), "Hitam"));

                else

                    Snackbar.make(findViewById(R.id.save1), "Data Korban tidak boleh kosong", Snackbar.LENGTH_LONG).show();

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

        database.child("korban").push().setValue(korban).addOnSuccessListener(TriaseHitamActivity.this, new OnSuccessListener<Void>() {

            @Override

            public void onSuccess(Void aVoid) {
                Intent intent = new Intent(TriaseHitamActivity.this, HomeActivity.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
