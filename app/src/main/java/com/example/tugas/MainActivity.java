package com.example.tugas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.DisplayMetrics;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Calendar myCalendar;
    DatePickerDialog.OnDateSetListener date;
    EditText etnamadepan,etnamabelakang,ettempatlahir,ettanggallahir,etalamat,ettelepon,etemail,etpassword,etulangi;
    Button btndaftar;
    String namaDpn, namaBlkng, tempat, tanggal, alamat, telp, email;

    AwesomeValidation validation;

    private void updateLabel() {
        String myFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        ettanggallahir.setText(sdf.format(myCalendar.getTime()));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etnamadepan = findViewById(R.id.id_namadepan);
        etnamabelakang = findViewById(R.id.id_namabelakang);
        ettempatlahir = findViewById(R.id.id_tempatlahir);
        ettanggallahir = findViewById(R.id.idtanggallahir);
        etalamat = findViewById(R.id.id_alamat);
        ettelepon = findViewById(R.id.id_telepon);
        etemail = findViewById(R.id.id_email);
        etpassword = findViewById(R.id.id_pass);
        etulangi = findViewById(R.id.id_passlagi);
        btndaftar = findViewById(R.id.btn_daftar);


        namaDpn = etnamadepan.getText().toString();


        namaBlkng = etnamabelakang.getText().toString();


        tempat = ettempatlahir.getText().toString();


        myCalendar = Calendar.getInstance();


        alamat = etalamat.getText().toString();


        telp = ettelepon.getText().toString();


        email = etemail.getText().toString();


        etulangi = (EditText) findViewById(R.id.id_passlagi);


        btndaftar = (Button) findViewById(R.id.btn_daftar);

        date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        ettanggallahir.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        validation = new AwesomeValidation(ValidationStyle.BASIC);

        validation.addValidation(this, R.id.id_namadepan,
                RegexTemplate.NOT_EMPTY, R.string.invalid_name);
        validation.addValidation(this, R.id.id_namabelakang,
                RegexTemplate.NOT_EMPTY, R.string.invalid_belakang);
        validation.addValidation(this, R.id.id_tempatlahir,
                RegexTemplate.NOT_EMPTY, R.string.invalid_tl);
        validation.addValidation(this, R.id.idtanggallahir,
                RegexTemplate.NOT_EMPTY, R.string.invalid_tanggal);
        validation.addValidation(this, R.id.id_alamat,
                RegexTemplate.NOT_EMPTY, R.string.invalid_alamat);
        validation.addValidation(this, R.id.id_telepon,
                RegexTemplate.NOT_EMPTY, R.string.invalid_telepon);
        validation.addValidation(this, R.id.id_email,
                Patterns.EMAIL_ADDRESS, R.string.invalid_email);
        validation.addValidation(this, R.id.id_pass,
                RegexTemplate.NOT_EMPTY, R.string.invalid_password);
        validation.addValidation(this, R.id.id_pass,
                ".{8,}", R.string.invalid_password);
        validation.addValidation(this, R.id.id_passlagi,
                RegexTemplate.NOT_EMPTY, R.string.invalid_ulangi);
        validation.addValidation(this, R.id.id_passlagi,
                R.id.id_pass, R.string.invalid_ulangi);





//        btndaftar.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                showDialog();
//                if (validation.validate()){
//                   ;
//                }
//                else{
//                    Toast.makeText(getApplicationContext(),
//                            "Mohon Isi Data Yang Kosong",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        btnkembali.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                finish();
//                System.exit(0);
//            }
//        });
//    }
//
//    private void showDialog() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
//
//        // set title dialog
//        alertDialogBuilder.setTitle("Konfirmasi...");
//
//        // set pesan dari dialog
//        alertDialogBuilder
//                .setMessage("Apakah data yang anda masukkan sudah benar?")
//                .setIcon(R.mipmap.ic_launcher)
//                .setCancelable(false)
//                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                            showDetailPendaftaran();
//                    }
//                })
//                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int id) {
//                        // jika tombol ini diklik, akan menutup dialog
//                        // dan tidak terjadi apa2
//                        dialog.cancel();
//                    }
//                });
//
//        // membuat alert dialog dari builder
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // menampilkan alert dialog
//        alertDialog.show();
//    }
//
//    private void showDetailPendaftaran(){
//        final Dialog dialog = new Dialog(this);
//        //AlertDialog.Builder dialog2 = new AlertDialog.Builder(this);
//
//        //judul dialog
//        dialog.setTitle("Detail Pendaftaran");
//
//        //memilih layout
//        dialog.setContentView(R.layout.activity_detail);
//
//        //agar dialog tidak hilang saat di click di area luar dialog
//        dialog.setCanceledOnTouchOutside(false);
//
//        DisplayMetrics metrics = getResources().getDisplayMetrics();
//        int width = metrics.widthPixels;
//        dialog.getWindow().setLayout((6 * width) / 7, LinearLayout.LayoutParams.WRAP_CONTENT);
//
//        Button btnKeluar = (Button) dialog.findViewById(R.id.keluar);
//        Button btnOke = (Button) dialog.findViewById(R.id.oke);
//
//        btnOke.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public  void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//
//        btnKeluar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//                System.exit(0);
//            }
//        });
//
//        //menampilkan custom dialog
//        dialog.show();
//        //dialog2.show();
////    }
    }}