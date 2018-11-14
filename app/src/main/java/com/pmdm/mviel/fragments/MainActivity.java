package com.pmdm.mviel.fragments;

import android.support.v4.app.FragmentManager;
// IMPORTANT!!!! comproveu si esteu utilitzant la versió de suport dels Fragments, tant ací com
//               a les classes Fragment
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Fragment1.ComunicaFragment1AmbActivity {
    Fragment2 f2,f3;
    FragmentManager fm;  //Objecte que ens permet gestionar els fragments que hi han en aquest Activity.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        fm = getSupportFragmentManager();
        //Enllacem cada objecte Fragment2 amb el contenidor assignat amb l'XML
        f2 = (Fragment2) fm.findFragmentById(R.id.fragment2);
        f3 = (Fragment2) fm.findFragmentById(R.id.fragment3);
    }

    @Override
    public void enviaMissatgeEscritAActivity(int destinatari,String missatge) {
        if(destinatari==2){
            Log.d("Manel","Al fragment2: "+missatge);
            f2.escriuMissatge(missatge);  //indiquem al fragment2 que modifique el missatge,
                                          // i pose el que ens ha comunicat el fragment1
        }else{
            Log.d("Manel","Al fragment1: "+missatge);
            f3.escriuMissatge(missatge);  //indiquem al fragment3 que modifique el missatge,
                                          // i pose el que ens ha comunicat el fragment1
        }

    }
}
