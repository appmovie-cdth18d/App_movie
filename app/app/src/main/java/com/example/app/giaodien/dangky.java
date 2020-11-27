package com.example.app.giaodien;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.MainActivity;
import com.example.app.R;

public class dangky extends AppCompatActivity {
    EditText email,user,pass,cfpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        email = (EditText) findViewById(R.id.inputEmail);
        user = (EditText) findViewById(R.id.inputName);
        pass = (EditText) findViewById(R.id.inputPassword);
        cfpass = (EditText) findViewById(R.id.inputCFPassword);
    }

    public void SINGUP(View view) {
        Intent intent = new Intent(dangky.this, MainActivity.class);
        startActivity(intent);

        if (user.getText().toString().equals(cfpass.getText().toString())) {

        } else
            Toast.makeText(getApplicationContext(), "Mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
    }

}