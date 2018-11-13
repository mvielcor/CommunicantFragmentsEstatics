package com.pmdm.mviel.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.ComunicaFragment1AmbActivity} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements View.OnClickListener{

    private EditText tv_missatge;
    private Button b2,b3;
    private ComunicaFragment1AmbActivity mListener;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
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
        b2 = v.findViewById(R.id.b_f2);
        b3 = v.findViewById(R.id.b_f3);

        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        return v;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicaFragment1AmbActivity) {
            mListener = (ComunicaFragment1AmbActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.b_f2){
            Log.d("Manel","He entrat en 2 ");
            mListener.enviaMissatgeEscritAActivity(2,tv_missatge.getText().toString());
        }
        if(v.getId()==R.id.b_f3){
            Log.d("Manel","He entrat en 3 ");
            mListener.enviaMissatgeEscritAActivity(3,tv_missatge.getText().toString());
        }
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
        // TODO: Update argument type and name
        void enviaMissatgeEscritAActivity(int destinatari,String missatge);
    }
}
