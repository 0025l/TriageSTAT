package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static android.text.TextUtils.isEmpty;

public class TriasePutihActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText nama;
    private Context context;
    private EditText usia;
    private EditText tmpt_tgl;
    private ImageView btSubmit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triase_putih);
        nama = (EditText) findViewById(R.id.nama4);
        usia = (EditText) findViewById(R.id.usia4);
        tmpt_tgl = (EditText) findViewById(R.id.tmpt_tgl4);
        btSubmit1 = (ImageView) findViewById(R.id.save4);

        addListenerOnButton();
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

                    submitBerjalan(new Korban(nama.getText().toString(), radioSexButton.getText().toString(), usia.getText().toString(), tmpt_tgl.getText().toString(), "Putih"));
                else
                    Snackbar.make(findViewById(R.id.save4), "Data korban tidak boleh kosong", Snackbar.LENGTH_LONG).show();
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

        database.child("korban").push().setValue(korban).addOnSuccessListener(TriasePutihActivity.this, new OnSuccessListener<Void>() {

            @Override

            public void onSuccess(Void aVoid) {


                Intent intent = new Intent(TriasePutihActivity.this, HomeActivity.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
