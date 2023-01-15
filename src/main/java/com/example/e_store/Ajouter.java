package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Ajouter extends AppCompatActivity {
    EditText edit;
    Button bnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter);
        edit =findViewById(R.id.edit);
        bnt=findViewById(R.id.bnt);
        Intent l=getIntent();

        bnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a=edit.getText().toString();

           Intent p=new Intent(Ajouter.this,PCActivity.class);
           p.putExtra("list",a);
           startActivity(p);


            }

        });
    }
}