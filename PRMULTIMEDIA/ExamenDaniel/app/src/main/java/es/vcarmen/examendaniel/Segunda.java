package es.vcarmen.examendaniel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by matinal on 19/01/18.
 */

public class Segunda extends AppCompatActivity{

TextView texto2;
TextView texto3;
TextView texto4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda);

        texto2 = findViewById(R.id.texto2);
        texto3 = findViewById(R.id.texto3);
        texto4 = findViewById(R.id.texto4);

        Bundle extras = getIntent().getExtras();

        texto2.setText(extras.get("name").toString());
        //texto3.setText(extras.get("anio").toString());
        String fecha =  extras.get("dia")+"/".toString()
                + extras.get("mes")+"/".toString()
                + extras.get("anio").toString();

        texto3.setText(fecha);

        texto4.setText(extras.get("extra").toString());

    }
}