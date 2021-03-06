package com.iesvirgendelcarmen.dam.fragment09;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by matinal on 25/10/17.
 */

public class Fragmento3 extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmento3,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,Contenido.pintores));

        int tipoLista = (int) (Math.random()*3);
        switch (tipoLista) {
            case 0:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.pintores));
                break;
            case 1:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.escultores));
                break;
            case 2:
                setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Contenido.arquitectos));
                break;
        }

        super.onViewCreated(view, savedInstanceState);
    }
}
