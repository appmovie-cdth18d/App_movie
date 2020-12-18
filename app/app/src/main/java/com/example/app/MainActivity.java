package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.app.giaodien.TrangChu.Trangchu;
import com.example.app.giaodien.TrangTimKiem.TrangTimKiem;
import com.example.app.giaodien.dangky;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = (EditText) findViewById(R.id.inputEmail);
        pass = (EditText) findViewById(R.id.inputPassword);

    }

    public void LOGIN(View view) {
        Intent t = new Intent(this, TrangTimKiem.class);
        startActivity(t);
        /*if (user.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Chưa nhập User", Toast.LENGTH_SHORT).show();
        }
        if (pass.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Chưa nhập PassWord", Toast.LENGTH_SHORT).show();
        }
        if (user.getText().toString().equals(pass.getText().toString())) {
            Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(getApplicationContext(), "Đăng nhập thất bại, vui lòng kiểm tra lại", Toast.LENGTH_SHORT).show();
    */
    }

    public void gotoRegister(View view) {
        Intent intent = new Intent(MainActivity.this, dangky.class);
        startActivity(intent);
    }
}