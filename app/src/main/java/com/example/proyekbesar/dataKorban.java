package com.example.proyekbesar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyekbesar.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class dataKorban extends AppCompatActivity implements AdapterKorbanRecyclerView.FirebaseDataListener{

    /**

     * Mendefinisikan variable yang akan dipakai

     */

    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Korban> daftarKorban;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_korban);
        /**

         * Inisialisasi RecyclerView & komponennya

         */
        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);
/**

 * Inisialisasi dan mengambil Firebase Database Reference

 */

        database = FirebaseDatabase.getInstance().getReference();

/**

 * Mengambil data barang dari Firebase Realtime DB

 */

        database.child("korban").addValueEventListener(new ValueEventListener() {

            @Override

            public void onDataChange(DataSnapshot dataSnapshot) {


                daftarKorban = new ArrayList<>();

                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {


                    Korban korban = noteDataSnapshot.getValue(Korban.class);

                    korban.setKey(noteDataSnapshot.getKey());

/**

 * Menambahkan object Barang yang sudah dimapping

 * ke dalam ArrayList

 */

                    daftarKorban.add(korban);

                }

/**

 * Inisialisasi adapter dan data barang dalam bentuk ArrayList

 * dan mengeset Adapter ke dalam RecyclerView

 */

                adapter = new AdapterKorbanRecyclerView(daftarKorban, dataKorban.this);

                rvView.setAdapter(adapter);

            }

            @Override

            public void onCancelled(DatabaseError databaseError) {

/**

 * Kode ini akan dipanggil ketika ada error dan

 * pengambilan data gagal dan memprint error nya

 * ke LogCat

 */

                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());

            }

        });

    }

    public static Intent getActIntent(Activity activity){

        return new Intent(activity, dataKorban.class);

    }

    @Override

    public void onDeleteData(Korban korban, final int position) {

/**

 * Kode ini akan dipanggil ketika method onDeleteData

 * dipanggil dari adapter lewat interface.

 * Yang kemudian akan mendelete data di Firebase Realtime DB

 * berdasarkan key barang.

 * Jika sukses akan memunculkan Toast

 */

        if(database!=null){ database.child("korban").child(korban.getKey()).removeValue().addOnSuccessListener(new
                                                                                                                       OnSuccessListener<Void>() {

                                                                                                                           @Override

                                                                                                                           public void onSuccess(Void aVoid) {

                                                                                                                               Toast.makeText(dataKorban.this,"success delete", Toast.LENGTH_LONG).show();

                                                                                                                           }

                                                                                                                       });

        }

    }


    public void launchHomeActivity(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    public void alur(View view)
    {Intent intent = new Intent(this, Alur.class);
        startActivity(intent);
    }
    public void tentangg(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
    public void backhome(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }


}