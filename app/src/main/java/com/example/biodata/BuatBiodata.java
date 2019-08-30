package com.example.biodata;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuatBiodata extends AppCompatActivity {
    protected Cursor cursor;
    DataHelper dbHelper;
    Button ton1,ton2;
    EditText text1,text2,text3,text4,text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        dbHelper=new DataHelper(this);
        text1=(EditText)findViewById(R.id.edt_tex1);
        text2=(EditText)findViewById(R.id.edt_tex2);
        text3=(EditText)findViewById(R.id.edt_tex3);
        text4=(EditText)findViewById(R.id.edt_tex4);
        text5=(EditText)findViewById(R.id.edt_tex5);
        ton1=(Button)findViewById(R.id.btn_ton1);
        ton2=(Button)findViewById(R.id.btn_ton2);
        ton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into biodata(no,nama,tgl,jk,alamat)values('" +
                        text1.getText().toString() + "','" +
                        text2.getText().toString() + "','" +
                        text3.getText().toString() + "','" +
                        text4.getText().toString() + "','" +
                        text5.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                MainActivity.utama.RefreshList();
                finish();
            }
        });
        ton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
