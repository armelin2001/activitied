package com.example.galeria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextName;
    EditText editTextPassword;
    String name;
    String password;
    final int RESULT_CAME_FROM_LOG_IN = 10001;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.main_title);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);

    }
    public void buttonSignIn(View view){
        if(TextUtils.isEmpty(editTextName.getText().toString())||TextUtils.isEmpty(editTextPassword.getText().toString())){
            Toast.makeText(MainActivity.this,"O nome ou senha não pode ser vazios",Toast.LENGTH_LONG).show();
        }
        else {
            name = editTextName.getText().toString();
            password = editTextPassword.getText().toString();
            Toast.makeText(MainActivity.this,"Usuario criado com sucesso",Toast.LENGTH_LONG).show();
        }
        editTextName.setText("");
        editTextPassword.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_CAME_FROM_LOG_IN){
            if(resultCode == RESULT_OK){
                String aux = data.getStringExtra("data");
                setTitle(aux);
            }
        }
    }

    public void buttonLogIn(View view){
        if(name.equals(editTextName.getText().toString())&& password.equals(editTextPassword.getText().toString())){
            Intent intent = new Intent(
                    MainActivity.this, GalleryActivity.class);
            intent.putExtra("data",name);
            startActivityForResult(intent,RESULT_CAME_FROM_LOG_IN);
        }
        else {
            Toast.makeText(MainActivity.this,"Nome ou senha invalidos",Toast.LENGTH_LONG).show();
            editTextName.setText("");
            editTextPassword.setText("");
        }
    }
}