package com.iesvirgendelcarmen.dam.fragment10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by matinal on 26/10/17.
 */

public class Fragmento3 extends Fragment {
    public static final String ARG_ID_eNTRADA_SELECCIONADA = "item_id";

    private Contenido.Lista_entrada miItem;

    public Fragmento3(){

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments().containsKey(ARG_ID_eNTRADA_SELECCIONADA)){
            miItem = Contenido.ENT_LISTA_HASHMAP.get(getArguments().getString(ARG_ID_eNTRADA_SELECCIONADA));
            Log.v("Prueba1", "Item");

        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_detalle, container, false);
        Log.v("Prueba3", "Create View");

        if(miItem != null){
            ((TextView)rootView.findViewById(R.id.textotitulo)).setText((miItem.textoEncima));
            ((TextView)rootView.findViewById(R.id.textocontenido)).setText((miItem.textoDebajo));
            ((ImageView)rootView.findViewById(R.id.imagen)).setImageResource(miItem.idImagen);
            Log.v("Prueba2", "Texto");
        }

        return rootView;
    }
}
