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
import android.widget.Button;
import android.widget.TextView;


/**
 * Aquest Fragment només ha de permetre canviar el contingut
 * de l'objecte TextView que conté.
 * Com que aquest fragment no s'ha de comunicar amb l'activity que el conté, no cal que implemente
 * cap interface. Per això les hem eliminat
 * Tampoc rebrà cap paràmetre, per això eliminem el còdi que gestiona els paràmetres
 */
public class Fragment2 extends Fragment implements View.OnClickListener{


   //Declare el TextView on mostrarà el missatge
    TextView tv_missatge;
    Button btn_rebutjar;
    int fragmentId;

    // Creem un objecte per comunicar el fragment amb l'Activity que el conté
    private ComunicaFragment2AmbActivity comunicador;


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
        fragmentId = v.getId();
        //Enllacem l'objecte TextView amb l'element XML definit al layout fragment_fragment2.xml
        tv_missatge = v.findViewById(R.id.missatge);
        btn_rebutjar = v.findViewById(R.id.btn_rebutjar_missatge);
        btn_rebutjar.setOnClickListener(this);
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ComunicaFragment2AmbActivity){
            comunicador  = (ComunicaFragment2AmbActivity) context;
        }else{
            new RuntimeException(context.toString()
                    + " has d'implementar la interfície ComunicaFragment1AmbActivity");
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        comunicador = null;
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

    @Override
    public void onClick(View v) {
        if(!tv_missatge.getText().toString().isEmpty()){
            int numfragment;
            if (fragmentId==R.id.fragment2){
                numfragment=2;
            }else{
                numfragment=3;
            }

            comunicador.notificaMissatgeRebutjat(fragmentId==R.id.fragment2?2:3,tv_missatge.getText().toString());
            //Esborrem el missatge del fragment
            tv_missatge.setText("");
        }
    }

    /* Creem una interfície de comunicació entre el fragment2 i l'Activity que el conté
    */
    public interface  ComunicaFragment2AmbActivity {
        void notificaMissatgeRebutjat(int numFragment, String missatgeRebutjat);
    }
}
