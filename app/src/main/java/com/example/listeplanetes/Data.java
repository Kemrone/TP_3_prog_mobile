package com.example.listeplanetes;

import java.util.ArrayList;

public class Data {
    private ArrayList<Planete> planetes;

    public Data(){

        this.planetes = new ArrayList<Planete>();
    }


    public Planete get(int position){

        return this.planetes.get(position);
    }

    public int size(){

        return this.planetes.size();
    }

    public void installePlanetes() {

       this.planetes.add(new Planete("Mercure","4900"));
       this.planetes.add(new Planete("Venus","12000"));
       this.planetes.add(new Planete("Terre","12800"));
       this.planetes.add(new Planete("Mars","6800"));
       this.planetes.add(new Planete("Jupiter","144000"));
       this.planetes.add(new Planete("Saturne","120000"));
       this.planetes.add(new Planete("Uranus","52000"));
       this.planetes.add(new Planete("Neptune","50000"));
       this.planetes.add(new Planete("Pluton","2300"));
    }

    public String[] getTaillePlanetes(){
        String[] listPlanetes = new String[0];
        int i = 0;
        for (Planete planete : this.planetes){

            listPlanetes[i] = planete.getTaille();
            i++;
        }
    return  listPlanetes;
    }


}
