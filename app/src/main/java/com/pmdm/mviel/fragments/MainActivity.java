package com.pmdm.mviel.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements Fragment1.ComunicaFragment1AmbActivity {
    Fragment2 f2,f3;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getSupportFragmentManager();
        f2 = (Fragment2) fm.findFragmentById(R.id.fragment2);
        f3 = (Fragment2) fm.findFragmentById(R.id.fragment3);
    }

    @Override
    public void enviaMissatgeEscritAActivity(int destinatari,String missatge) {
        if(destinatari==2){
            Log.d("Manel","Al fragment2: "+missatge);
            f2.escriuMissatge(missatge);
        }else{
            Log.d("Manel","Al fragment1: "+missatge);
            f3.escriuMissatge(missatge);
        }

    }
}
