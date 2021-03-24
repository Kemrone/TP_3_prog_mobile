package com.example.listeplanetes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {

    private final MainActivity mainActivityContext;
    private Data data;
    private ArrayList<Planete> planetes;
    public static int nb = 0;

    public PlanetAdapter(MainActivity context, Data data){
        this.data = data;
        this.mainActivityContext = context;


    }
    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int i) {
        return planetes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView( int position, View convertView, ViewGroup parent) {


        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    mainActivityContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem,null);

        }
        final TextView nomPlanete = itemView.findViewById(R.id.textView);
        final CheckBox checkbox = itemView.findViewById(R.id.checkbox);
        final Spinner spinner = itemView.findViewById(R.id.spinner);

        nomPlanete.setText(planetes.get(position).getNom());

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(mainActivityContext, android.R.layout.simple_spinner_item, data.getTaillePlanetes());
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);


        checkbox.setOnCheckedChangeListener((compoundButton,b) -> {
            CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
            spinner.setEnabled(!checkBox.isChecked());

            if(checkBox.isChecked()){
                nb++;
            }
            else{
                nb--;
            }
            Button btn = mainActivityContext.btn;

            if(nb == planetes.size()){
                btn.setEnabled(true);
            }
            else{
                btn.setEnabled(false);
            }
        });
    return itemView;

    }





}