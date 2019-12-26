package com.example.proyekbesar;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterKorbanRecyclerView2 extends RecyclerView.Adapter<AdapterKorbanRecyclerView2.ViewHolder>
{



    //Membuat Konstruktor, untuk menerima input dari Database


    private ArrayList<Korban> daftarKorban;

    private Context context;
    FirebaseDataListener listener;
    public AdapterKorbanRecyclerView2(ArrayList<Korban> korbans, Context ctx){

/**

 * Inisiasi data dan variabel yang akan digunakan

 */

        daftarKorban = korbans;

        context = ctx;

        listener = (dataKorbanMedis) ctx;

    }


    class ViewHolder extends RecyclerView.ViewHolder {

        /**

         * Inisiasi View

         * Di tutorial ini kita hanya menggunakan data String untuk tiap item

         * dan juga view nya hanyalah satu TextView

         */

        TextView tvTitle;
        TextView tvJk;
        TextView tvUsia;
        TextView tvTgl;
        TextView tvTria;

        ViewHolder(View v) {

            super(v);

            tvTitle = (TextView) v.findViewById(R.id.tv_namakorban);
            tvJk = (TextView) v.findViewById(R.id.tv_jk);
            tvUsia = (TextView) v.findViewById(R.id.tv_usia);
            tvTgl = (TextView) v.findViewById(R.id.tv_ttgl);
            tvTria = (TextView) v.findViewById(R.id.tv_triase);


        }

    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

/**

 * Inisiasi ViewHolder

 */

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_korban, parent, false);

// mengeset ukuran view, margin, padding, dan parameter layout lainnya

        ViewHolder vh = new ViewHolder(v);

        return vh;

    }
    @Override

    public void onBindViewHolder(ViewHolder holder, final int position) {

/**

 * Menampilkan data pada view

 */

        final String name = daftarKorban.get(position).getNama();
        final String usia = daftarKorban.get(position).getUsia();
        final String jk = daftarKorban.get(position).getJk();
        final String ttgl = daftarKorban.get(position).getTempat_tgl();
        final String triase = daftarKorban.get(position).getkTriase();
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

            }

        });

        holder.tvTitle.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(final View view) {
                final Dialog dialog = new Dialog(context);

                dialog.setContentView(R.layout.dialog_view);

                dialog.setTitle("Pilih Aksi");

                dialog.show();
                Button editButton = (Button) dialog.findViewById(R.id.bt_edit_data);

                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol edit diklik

                editButton.setOnClickListener(

                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {

                                dialog.dismiss();

                                context.startActivity(editDataKorban.getActIntent((Activity) context).putExtra("data", daftarKorban.get(position)));

                            }

                        }

                );

//apabila tombol delete diklik

                delButton.setOnClickListener(

                        new View.OnClickListener() {

                            @Override

                            public void onClick(View view) {

                                dialog.dismiss();

                                listener.onDeleteData(daftarKorban.get(position), position);
                            }

                        }

                );

                return true;
            }

        });

        holder.tvTitle.setText(name);
        holder.tvUsia.setText("Usia :" + usia);
        holder.tvJk.setText("Jenis Kelamin :" + jk);
        holder.tvTgl.setText("Tempat tinggal :" + ttgl);
        holder.tvTria.setText("Warna triase :" + triase);

    }

    @Override

    public int getItemCount() {

/**

 * Mengembalikan jumlah item pada barang

 */

        return daftarKorban.size();

    }

    public interface FirebaseDataListener{

        void onDeleteData(Korban korban, int position);

    }

}