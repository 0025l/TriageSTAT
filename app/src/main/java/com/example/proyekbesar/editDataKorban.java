package com.example.proyekbesar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.proyekbesar.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class editDataKorban extends AppCompatActivity {

    private DatabaseReference database;
    private ArrayList<Korban> daftarKorban;
    private Context context;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private EditText nama;
    private EditText usia;
    private EditText warn;
    private EditText tmpt_tgl;
    private Button btSubmit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data_korban);
        nama = (EditText) findViewById(R.id.ireum);
        warn = (EditText) findViewById(R.id.war);
        usia = (EditText) findViewById(R.id.nai);
        tmpt_tgl = (EditText) findViewById(R.id.jib);
        btSubmit1 = (Button) findViewById(R.id.updt);

        addListenerOnButton();

// inisialisasi fields EditText dan Button



    }
    public void addListenerOnButton() {

        database = FirebaseDatabase.getInstance().getReference();
        final Korban korban = (Korban) getIntent().getSerializableExtra("data");
        radioSexGroup = (RadioGroup) findViewById(R.id.radioGroup0);



            nama.setText(korban.getNama());

            usia.setText(korban.getUsia());

            tmpt_tgl.setText(korban.getTempat_tgl());
        warn.setText(korban.getkTriase());

            btSubmit1.setOnClickListener(new View.OnClickListener() {

                @Override

                public void onClick(View view) {

                    korban.setNama(nama.getText().toString());

                    korban.setUsia(usia.getText().toString());

                    korban.setTempat_tgl(tmpt_tgl.getText().toString());
//                     getTextet selected radio button from radioGroup
                    int selectedId = radioSexGroup.getCheckedRadioButtonId();

                    // find the radiobutton by returned id
                    radioSexButton = (RadioButton) findViewById(selectedId);

                    korban.setJk(radioSexButton.getText().toString());
                    korban.setkTriase(warn.getText().toString());
                    updateKorban(korban);

                }

            });

        }


//

    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }



    private boolean isEmpty(String s) {

// Cek apakah ada fields yang kosong, sebelum disubmit

        return TextUtils.isEmpty(s);

    }


    private  void updateKorban(Korban korban){

        /**

         * Baris kode yang digunakan untuk mengupdate data barang

         * yang sudah dimasukkan di Firebase Realtime Database

         */

        database.child("korban") //akses parent index, ibaratnya seperti nama tabel

                .child(korban.getKey()) //select barang berdasarkan key

                .setValue(korban) //set value barang yang baru

                .addOnSuccessListener(this, new OnSuccessListener<Void>() {

                    @Override

                    public void onSuccess(Void aVoid) {

/**

 * Baris kode yang akan dipanggil apabila proses update barang sukses

 */
                    context.startActivity(dataKorban.getActIntent((Activity) context));

                    }

                });

    }
    public static Intent getActIntent(Activity activity) {



        return new Intent(activity, editDataKorban.class);

    }
}
