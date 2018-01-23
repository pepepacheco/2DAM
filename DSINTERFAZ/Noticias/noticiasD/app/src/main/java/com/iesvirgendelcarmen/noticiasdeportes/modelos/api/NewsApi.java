package com.iesvirgendelcarmen.noticiasdeportes.modelos.api;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.iesvirgendelcarmen.noticiasdeportes.App;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.Noticia;
import com.iesvirgendelcarmen.noticiasdeportes.modelos.NoticiasDataSource;

import java.io.StringReader;
import java.util.List;

public class NewsApi implements NoticiasDataSource {

    private String ENDPOINT_TOP = "https://newsapi.org/v2/top-headlines?sources=%s&apiKey=%s";
    private String ENDPOINT_TODO = "https://newsapi.org/v2/everything?sources=%s&apiKey=%s";
    private String SOURCE = "marca";
    private String APIKEY = "e9e3cbfdc42c4ab295a4cac9f7247401";
    private String url;

    public NewsApi() {
        this.url = String.format(ENDPOINT_TODO, SOURCE, APIKEY);
    }

    /**
     * Hace una consulta GET a url y parsea y devuelve mediante un callback la lista
     * de las últimas noticias deportivas del diario digital Marca.
     * <p>
     * Se hace uso de la librería Volley y Gson
     *
     * @param callback Cuando se ha obtenido y procesado la lista se llama al callback
     */
    @Override
    public void getNoticias(final CargaNoticiasCallback callback) {
        //Se obtiene la cola de peticiones. Sólo debe existir una instancia de Volley
        //para asegurar correcto funcionamiento de la cache.
        RequestQueue req = VolleySingleton.getInstance(App.getAppContext()).getRequestQueue();

        ///Se hace una petición GET a la url
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.i("Respuesta", response);
                        //Parseo la respuesta y me quedo con el atributo articles que contiene el array de noticias
                        JsonParser parser = new JsonParser();
                        JsonElement e = parser.parse(response);
                        JsonElement articulos = e.getAsJsonObject().get("articles");
                        Log.i("Articulos", articulos.toString());

                        //Uso Gson para deserializar el array automaticamente
                        List<Noticia> noticias = new Gson().fromJson(new StringReader(articulos.toString()), new TypeToken<List<Noticia>>() {
                        }.getType());

                        //Llamo al callback para pasar la lista de noticias
                        callback.onNoticiasCargadas(noticias);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onNoticiaError();
                    }
                });

        //Se añade la petición creada a la cola
        req.add(stringRequest);
    }

    @Override
    public void getNoticia(int posicion, CargaNoticiaCallback callback) {
        //No existe una url en newsapi.org para consultar una noticia concreta.
        //No se implementa
    }

}