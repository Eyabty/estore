package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SmartphoneActivity extends AppCompatActivity {
ListView li;
String [] bd= new String[] {"Iphone","Samsung","Huawei","Xiaomi " };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);
        li=findViewById(R.id.li);
        Intent b=getIntent();
        ArrayAdapter<String> k= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,bd);
        li.setAdapter(k);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ShowMyDialog( i);
            }
        });
    }

    private void ShowMyDialog(int pos) {
        Dialog dialog = new Dialog(SmartphoneActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence= dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix =dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image =dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText("MQ023AA/A");
            libellé.setText("Iphone 13 mini ");
            desc.setText(" Ecran: 5.4 ,  Stockage 64 Go ,  Processeur Apple A16  ");
            prix.setText("3.500 DT");
            image.setImageResource(R.drawable.iphone);
        }
        else if(pos == 1) {
            reférence.setText("  SM-A515FD-WH");
            libellé.setText("samsung A51");
            desc.setText(" Ecran 6.5 , 6 RAM , 128 Go   ");
            prix.setText("999 DT");
            image.setImageResource(R.drawable.sumsung);
        }
        else if(pos==2) {
            reférence.setText(" MATE10-LTE-GO");
            libellé.setText("Huawei nova 7i");
            desc.setText("  RAM: 8 Go ,128 Go,Batterie ; 4200mAh ");
            prix.setText("899 DT");
            image.setImageResource(R.drawable.huawei);
        }
        else {

            reférence.setText("REDMI10_22-64-GR");
            libellé.setText("Xiaomi Redmi 10 ");
            desc.setText(" Écran 6.5 , 64 Go,Batterie 5000 mAh, RAM 4 Go");
            prix.setText("769 DT");
            image.setImageResource(R.drawable.redmi);
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

        return true ;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(SmartphoneActivity.this, Ajouter.class);
                startActivity(l);
                break;
            case R.id.it2:
                Intent k=new Intent(SmartphoneActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
    }
}