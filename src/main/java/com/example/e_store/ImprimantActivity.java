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

public class ImprimantActivity extends AppCompatActivity {
    ListView li;
    String[] bd = new String[]{"Imprimante hp", "Imprimante epson", "Imprimante brother", "Imprimante canon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imprimant);
        li = findViewById(R.id.li);
        Intent c = getIntent();
        ArrayAdapter<String> g = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, bd);
        li.setAdapter(g);
        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println(i);
                ShowMyDailog(i);
            }
        });
    }

    private void ShowMyDailog(int pos) {
        Dialog dialog = new Dialog(ImprimantActivity.this);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dailog);
        TextView reférence = dialog.findViewById(R.id.l1);
        TextView libellé = dialog.findViewById(R.id.l2);
        TextView desc = dialog.findViewById(R.id.l3);
        TextView prix = dialog.findViewById(R.id.l4);
        Button b = dialog.findViewById(R.id.ok);
        ImageView image = dialog.findViewById(R.id.imag);

        if (pos == 0) {
            reférence.setText(" 7MD67A");
            libellé.setText("HP");
            desc.setText("Vitesse d'impression: Jusqu’à 20 ppm - Résolution d'impression: Jusqu'à 600 x 600 ppp - Format A4 - Interface USB 2.0 ");
            prix.setText("360dT");
            image.setImageResource(R.drawable.hp);
        } else if (pos == 1) {
            reférence.setText("C11CJ67408");
            libellé.setText("EPSON");
            desc.setText("Imprimante à Réservoir Intégré EPSON ECOTANK L3250 3En1 Couleur - Fonction: Impression, Copie, Numérisation - Technologie d'impression: Jet d'encre ");
            prix.setText("699T");
            image.setImageResource(R.drawable.eps);
        } else if (pos == 2) {
            reférence.setText("BMCJ-DCPJ1200W");
            libellé.setText("brother ");
            desc.setText("Imprimante Multifonction Jet d'encre Couleur Brother 3 en1 DCP-J1200W - Photocopie, Scan, Impression - Format A4 ");
            prix.setText("350 DT");
            image.setImageResource(R.drawable.brother);
        } else {

            reférence.setText(" S-TS-3140");
            libellé.setText("Canon ");
            desc.setText("Format A4 - Résolution d'impression: Jusqu'à 4800 x 1200 dpi - Vitesse d'impression Noir/Couleur: 7.7 ppm / 4 ppm - Impression mobile iOS, Android, Windows 10 Mobile - Résolution de numérisation: 600 x 1200 dpi - Interface: USB / Wifi - Dimensions: 435 x 316 x 145 mm");
            prix.setText("136 DT");
            image.setImageResource(R.drawable.canon);
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
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.it1:


                Intent l = new Intent(ImprimantActivity.this, Ajouter.class);
                startActivity(l);

                break;
            case R.id.it2:
                Intent k=new Intent(ImprimantActivity.this,Rechercher.class);
                startActivity(k);
                break;

        }

        return false;
    }
}