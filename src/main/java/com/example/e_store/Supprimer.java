package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class Supprimer extends AppCompatActivity {
    ListView list;
    Button bnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        list = findViewById(R.id.lis);
        ArrayAdapter<String> e = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, (List<String>) list);
        list.setAdapter(e);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ((List<?>) list).remove(i);
            }
        });


        }


    }

