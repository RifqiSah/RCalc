package com.alriftech.rcalc;

import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity {

    TextView txtHasil;
    Double nilai, hasil;
    Integer fnal = 0;
    Character operate = 'A';

    protected void masukan(Integer angka)
    {
        if (fnal == 1) {
            fnal = 0;
            reset();
        }

        if (txtHasil.getText().toString().matches("0"))
            txtHasil.setText(angka.toString());
        else
            txtHasil.setText(txtHasil.getText() + angka.toString());
    }

    protected void operasi(Character operate)
    {
        this.operate = operate;
        if (txtHasil.getText().toString().length() > 0)
            nilai = Double.parseDouble(txtHasil.getText().toString());

        txtHasil.setText("");
    }

    protected void reset()
    {
        txtHasil.setText("");
        operate = 'A';
        hasil = 0.0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        txtHasil = (TextView)findViewById(R.id.txtNumber);

        Button btn0 = (Button)findViewById(R.id.btn0);
        Button btn1 = (Button)findViewById(R.id.btn1);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn4 = (Button)findViewById(R.id.btn4);
        Button btn5 = (Button)findViewById(R.id.btn5);
        Button btn6 = (Button)findViewById(R.id.btn6);
        Button btn7 = (Button)findViewById(R.id.btn7);
        Button btn8 = (Button)findViewById(R.id.btn8);
        Button btn9 = (Button)findViewById(R.id.btn9);

        Button btnKali = (Button)findViewById(R.id.btnKali);
        Button btnBagi = (Button)findViewById(R.id.btnBagi);
        Button btnTambah = (Button)findViewById(R.id.btnTambah);
        Button btnKurang = (Button)findViewById(R.id.btnMin);
        Button btnHasil = (Button)findViewById(R.id.btnHasil);
        Button btnHapus = (Button)findViewById(R.id.btnHapus);
        Button btnBack = (Button)findViewById(R.id.btnBackspace);
        Button btnKoma = (Button)findViewById(R.id.btnKoma);

        // Buat nomor
        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(0);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(1);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(4);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(5);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(6);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(7);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(8);
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                masukan(9);
            }
        });

        btnKoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtHasil.setText(txtHasil.getText() + ".");
            }
        });

        // Buat operasi
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operasi('X');
            }
        });

        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operasi('/');
            }
        });

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operasi('+');
            }
        });

        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operasi('-');
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tmp = (String)txtHasil.getText().toString();
                if (tmp.length() > 0) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                    txtHasil.setText(tmp);
                }
                tmp = "";
            }
        });

        // Buat hasil
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operate == 'X')
                    hasil = nilai * Double.parseDouble(txtHasil.getText().toString());
                else if (operate == '/')
                    hasil = nilai / Double.parseDouble(txtHasil.getText().toString());
                else if (operate == '+')
                    hasil = nilai + Double.parseDouble(txtHasil.getText().toString());
                else if (operate == '-')
                    hasil = nilai - Double.parseDouble(txtHasil.getText().toString());

                txtHasil.setText(hasil.toString());
                operate = 'A';
                fnal = 1;
            }
        });
    }
}
