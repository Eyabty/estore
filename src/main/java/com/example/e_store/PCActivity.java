package com.example.e_store;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class PCActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"Hp", "MSI ", "ASUS", "LENOVO"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcactivity);
        li = findViewById(R.id.li);
        Intent a = getIntent();
        Intent p = getIntent();
        ArrayAdapter<String> h = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(h);


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);

                ShowMyDialog(i);
            }


        });

        li.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });
        li.setOnCreateContextMenuListener(this);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cont, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo i = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.it1:

                break;
            default:

        }
        return super.onContextItemSelected(item);


    }


    private void ShowMyDialog(int pos) {
        Dialog dialog = new Dialog(PCActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText(" 2U2M4EA");
            libellé.setText("HP 15s ");
            desc.setText("Ecran 15.6 ,Intel Core i5 , Disque 256 Go ,8Go RAm ");
            prix.setText("1795 DT");
            image.setImageResource(R.drawable.hpp);
        } else if (pos == 1) {
            reférence.setText("  GF63TH11SC-613X-2Y");
            libellé.setText("MSI GAMING GF63");
            desc.setText(" 15.6 , Intel core i7 , 512 GO SSD , Nivédia Gtx 1650 ");
            prix.setText("2399DT");
            image.setImageResource(R.drawable.msi5);
        } else if (pos == 2) {
            reférence.setText("82H8020QFG");
            libellé.setText("ASUS i5 ");
            desc.setText("Ecran 15.6 ,Intel i5 , 8Go Ram  ");
            prix.setText("1750 DT");
            image.setImageResource(R.drawable.asus);
        } else {

            reférence.setText("  82H8020SFG");
            libellé.setText("LENOVO idea pad ");
            desc.setText("Ecran 15.6 , RAM4 Go , Disque 1 To ");
            prix.setText("1050DT");
            image.setImageResource(R.drawable.lenovo);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(PCActivity.this, Ajouter.class);

                startActivity(l);
                break;

            case R.id.it2:
                Intent m = new Intent(PCActivity.this,Supprimer.class);
                startActivity(m);
                break;
        }

        return false;
    }
}