package com.pmdm.mviel.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
// IMPORTANT!!!! comproveu si esteu utilitzant la versió de suport dels Fragments, tant ací com
//               a les classes Fragment
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Aquest Fragment només ha de permetre canviar el contingut
 * de l'objecte TextView que conté.
 * Com que aquest fragment no s'ha de comunicar amb l'activity que el conté, no cal que implemente
 * cap interface. Per això les hem eliminat
 * Tampoc rebrà cap paràmetre, per això eliminem el còdi que gestiona els paràmetres
 */
public class Fragment2 extends Fragment {


   //Declare el TextView on mostrarà el missatge
    TextView tv_missatge;


    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Modifiquem el mètode newInstance per a eliminar la gestió dels paràmetres,
     * ja que aquest fragment no rep cap paràmetre
     *
     * @return A new instance of fragment Fragment2.
     */

    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =inflater.inflate(R.layout.fragment_fragment2, container, false);
        //Enllacem l'objecte TextView amb l'element XML definit al layout fragment_fragment2.xml
        tv_missatge = v.findViewById(R.id.missatge);
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * Creem el mètode escriuMissatge que ens permetrà modificar el missatge que mostra el TextView
     *@param  missatge Indica el missatge nou que ha de mostrar el fragment
     *
     *
     */
    public void escriuMissatge(String missatge){
        //Inserim el missatge en el TextView
        tv_missatge.setText(missatge);
    }
}
