package com.pmdm.mviel.fragments;

import android.content.Context;
import android.os.Bundle;
// IMPORTANT!!!! comproveu si esteu utilitzant la versió de suport dels Fragments, tant ací com
//               a les classes Fragment
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Aquest Fragment sí que s'ha de comunicar amb l'activity, per tant crearem una interface
 * de comunicació {@link Fragment1.ComunicaFragment1AmbActivity}.
 * Aquest fragment rebrà un missatge en un objecte EditText, i depenent del botó que polse l'usuari
 * enviarà eixe missatge a un fragment o a un altre.
 *
 */
public class Fragment1 extends Fragment implements View.OnClickListener{

    private EditText tv_missatge; // Objecte on escriurem el missatge
    private Button b2,b3;       //Botons per enviar el missatge al fragment 2 o al fragment 3
    private TextView tv_missatgesRebutjats;
    private ComunicaFragment1AmbActivity mListener;  //Objecte que ens permetrà comunicar el
                                                      // fragment amb l'activity

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Com que no rebrem paràmetres, eliminem la gestió dels paràmetres.
     */

    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
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
        View v= inflater.inflate(R.layout.fragment_fragment1, container, false);
        // Assignem objectes a elements de l'XML
        tv_missatge = v.findViewById(R.id.missatgeAEnviar);
        tv_missatgesRebutjats = v.findViewById(R.id.tv_missatges_rebutjats);
        b2 = v.findViewById(R.id.b_f2);
        b3 = v.findViewById(R.id.b_f3);

        //Als dos botons els afegim un listener per a escoltar els event de click
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);

        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //comprovem si tenim l'activity que conté este fragment implementa la interficie requerida
        if (context instanceof ComunicaFragment1AmbActivity) {
            mListener = (ComunicaFragment1AmbActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " has d'implementar la interfície ComunicaFragment1AmbActivity");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; //Asignem null a l'objecte que ens permetrà la comunicació amb l'activity
                            // per a evitar "fugues de memòria", i que el garbage collector puga
                            // alliberar eixa memòria.
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b_f2){
            mListener.enviaMissatgeEscritAActivity(2,tv_missatge.getText().toString());
        }
        if(v.getId()==R.id.b_f3){
            mListener.enviaMissatgeEscritAActivity(3,tv_missatge.getText().toString());
        }
    }

    public void afegeixMissatgeRebutjat(int fragmentOrigen, String missatge){
        /* Utilitzem la classe SpannableString per a cadenes de text que mostraran format HTML,
           però seran IMMUTABLES durant l'execució d'aquest mètode
         */
        SpannableString missatgeInicial = new SpannableString(tv_missatgesRebutjats.getText());
        /* Utilitzem SpannableStringBuilder per a cadenes de text que mostraran format HTML , però
           el seu contingut serà alterable durant l'execució d'aquest mètode
         */
        SpannableStringBuilder missatgeFinal = new SpannableStringBuilder(Html.toHtml(missatgeInicial,Html.FROM_HTML_MODE_COMPACT));

        if (fragmentOrigen==2){
            missatgeFinal.append("<font color='red'>f2: "+missatge+"</font>\n");
        }else{
            missatgeFinal.append("<font color='blue'>f3: "+missatge+"</font>\n");
        }
        tv_missatgesRebutjats.setText(Html.fromHtml(missatgeFinal.toString(),Html.FROM_HTML_MODE_COMPACT));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ComunicaFragment1AmbActivity {
        // Mètode que ens enviarà el botó polsat i el missatge a enviar a l'activity
        void enviaMissatgeEscritAActivity(int destinatari,String missatge);
    }
}
