package com.pemesanan.TiketKapal.activity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.pemesanan.TiketKapal.R;
import com.pemesanan.TiketKapal.database.DatabaseHelper;

public class UpdateUserActivity extends AppCompatActivity {
    EditText txtusername, txtpassword, txtnama;
    Button btnUpdateUser;

    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    String name, username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);


        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

        txtusername = findViewById(R.id.edtUsername);
        txtpassword = findViewById(R.id.edtPassword);
        txtnama = findViewById(R.id.edtNama);

        btnUpdateUser = findViewById(R.id.btnUpdateUser);

        btnUpdateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = txtnama.getText().toString();
                username = txtusername.getText().toString();
                password = txtpassword.getText().toString();
                try {
                    db.execSQL("UPDATE TB_USER SET  password='" +
                            password + "',name='" +
                            name + "'where username='" +
                            username + "'");
                    Toast.makeText(UpdateUserActivity.this, "Update berhasil", Toast.LENGTH_LONG).show();
                    finish();
                    }catch (Exception e) {
                    Toast.makeText(UpdateUserActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();}
            }

    });
}}