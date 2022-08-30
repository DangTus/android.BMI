package com.dmt.dangtus.th_ui_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextCanNang, editTextChieuCao;
    Button btnTinhBMI;
    TextView txtChiSoBMI, txtPhanLoaiBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        //khi load
        txtChiSoBMI.setText("");
        txtPhanLoaiBMI.setText("");

        //su kien khi click vao button
        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(editTextCanNang.getText().toString().equals("") || editTextChieuCao.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    Double canNang = Double.parseDouble(editTextCanNang.getText().toString());
                    Double chieuCao = Double.parseDouble(editTextChieuCao.getText().toString());

                    Double BMI = canNang / (chieuCao*chieuCao);

                    //hien ra chi so BMI
                    txtChiSoBMI.setText("" + (double) Math.round(BMI * 100) / 100);

                    //hien ra phan loai
                    if(BMI < 18) {
                        txtPhanLoaiBMI.setText("Người gầy");
                    } else if(BMI < 24.9) {
                        txtPhanLoaiBMI.setText("Người bình thường");
                    } else if(BMI < 29.9) {
                        txtPhanLoaiBMI.setText("Người béo phì độ I");
                    } else if(BMI < 34.9) {
                        txtPhanLoaiBMI.setText("Người béo phì độ II");
                    } else {
                        txtPhanLoaiBMI.setText("Người béo phì độ III");
                    }
                }
            }
        });
    }

    private void anhXa() {
        editTextCanNang = (EditText) findViewById(R.id.canNangEditText);
        editTextChieuCao = (EditText) findViewById(R.id.chieuCaoEditText);
        btnTinhBMI = (Button) findViewById(R.id.tinhBMIButton);
        txtChiSoBMI = (TextView) findViewById(R.id.chiSoBMI);
        txtPhanLoaiBMI = (TextView) findViewById(R.id.phanLoaiBMI);
    }
}