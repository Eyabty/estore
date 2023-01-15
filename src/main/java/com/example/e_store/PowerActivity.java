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

public class PowerActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{ "Power Bank Artek ","Power bank S-link", "Power bank sans fil", "Power Bank Xiaomi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power);
        li = findViewById(R.id.li);
        Intent m = getIntent();
        ArrayAdapter<String> p = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(p);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                ShowMyDailog(i);
            }


        });
    }

    private void ShowMyDailog(int pos) {

        Dialog dialog = new Dialog(PowerActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText(" 37967");
            libellé.setText("Power Bank Artek");
            desc.setText(" Puissance 5000 mAh - Batterie Polymer 5000mah - Entrée Micro 5V / 2.1A - Type-C 5V /  2.1A - Sortie : USB1 5V / 1A - USB2 5V / 2.4A");
            prix.setText("20DT");
            image.setImageResource(R.drawable.artek);
        } else if (pos == 1) {

            reférence.setText(" ip-55123k");
            libellé.setText("Power bank S-link");
            desc.setText(" Puissance 5000 mAh - 1x Port USB 5V/ 1A - Micro USB + Connecteur Lightning ");
            prix.setText("35DT");
            image.setImageResource(R.drawable.slink);
        } else if (pos == 2) {
            reférence.setText("P5K0MAPBKS55P0K");
            libellé.setText("Power bank silcon Power");
            desc.setText("Capacité 5000 mAh - Dimensions 124.0 x 68.0 x 9.2 mm - Poids 140g - Batterie Li-Polymer - Tension d\\'entrée (Connecteur Lighting) 5V/1A -");
            prix.setText("50DT");
            image.setImageResource(R.drawable.sp);
        } else {

            reférence.setText("26922 ");
            libellé.setText("POWER BANK XIAOMI Redmi  ");
            desc.setText("18W Fast Charge - Puissance 20 000 mAh - Tension de sortie 4.4V - 1x USB type C ");
            prix.setText("89 DT");
            image.setImageResource(R.drawable.xiaomi);
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
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



                Intent l= new Intent(PowerActivity.this,Ajouter.class);
                startActivity(l);
                break;
            case R.id.it2:
                Intent k=new Intent(PowerActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
}}