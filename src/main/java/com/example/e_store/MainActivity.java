package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    String [] mod=new String[]{"Ordinateur Portable","Accessoires ","Imprimant","Power Bank"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid=findViewById(R.id.grid);
        ArrayAdapter<String> g=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mod);
        grid.setAdapter(g);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                switch (i){
                    case 0:
                        Intent a= new Intent(MainActivity.this,PCActivity.class);
                        startActivity(a);
                        break;
                    case 1:

                        Intent b= new Intent(MainActivity.this,SmartphoneActivity.class);
                        startActivity(b);
                        break;
                    case 2:
                        Intent c=new Intent(MainActivity.this,ImprimantActivity.class);
                        startActivity(c);
                        break;
                    case 3:
                        Intent m= new Intent(MainActivity.this, PowerActivity.class);
                        startActivity(m);
                        break;
                }

            }
        });
    }
}