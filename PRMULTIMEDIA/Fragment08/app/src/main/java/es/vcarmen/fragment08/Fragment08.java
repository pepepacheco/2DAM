package es.vcarmen.fragment08;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.Serializable;

public class Fragment08 extends FragmentActivity implements Cabecera.CabeceraListener {

    Cabecera primerFragmento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment08);

        if(savedInstanceState != null){

            primerFragmento = new Cabecera();

            return ;
        }

        primerFragmento = new Cabecera();

        primerFragmento.setArguments(getIntent().getExtras());

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,primerFragmento).commit();




    }

    public void tocado(int position){
       // Toast.makeText(getBaseContext(),"TOCADO EL " + String.valueOf(position+1), Toast.LENGTH_SHORT ).show();
        Contenido detalle = new Contenido();
        Bundle args = new Bundle();
        args.putInt(Contenido.ARG_POSITION,position);
        detalle.setArguments(args);

        FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
        FT.replace(R.id.contenedor,detalle);
        FT.addToBackStack(null);
        FT.commit();
    }

/*    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }*/
}