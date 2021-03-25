package com.example.listeplanetes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Data> planetes;
    ListView listview;
    PlanetAdapter adapter;
    Data data;
    Button btn;
    Spinner spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
        listview = (ListView) findViewById(R.id.listView);
        data =new Data();
        data.installePlanetes();
        adapter = new PlanetAdapter(this, data);
        listview.setAdapter(adapter);
        btn.setEnabled(false);


        btn.setOnClickListener((view) -> {

            int score = 0;
            String[] taillePlanetes = data.getTaillePlanetes();

            for(int i =0; i< taillePlanetes.length;i++){
                View v = listview.getChildAt(i);
                spinner = v.findViewById(R.id.spinner);
                String taille = spinner.getSelectedItem().toString();
                if(taille.equals(taillePlanetes[i])){
                    score++;
                }
            }


            Toast.makeText(MainActivity.this, "Score"  +score +" / " + taillePlanetes.length, Toast.LENGTH_LONG).show();
        });




    }
/*
    private View.OnClickListener tailleListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            int score = 0;
            String[] taillePlanetes = data.getTaillePlanetes();

            for (int i = 0; i < taillePlanetes.length; i++) {
                 v = listview.getChildAt(i);
                spinner = v.findViewById(R.id.spinner);
                String taille = spinner.getSelectedItem().toString();
                if (taille.equals(taillePlanetes[i])) {
                    score++;
                }
            }
            Toast.makeText(MainActivity.this, "Score " + score + " / " + taillePlanetes.length, Toast.LENGTH_LONG).show();
        }
    };
*/
}







