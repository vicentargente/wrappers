package com.example.application.wrappers;

import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import com.example.application.util.Lector;

public class Wrapper_IB {
    private String xml;

    // El objeto tiene un atributo xml donde se guardará el contenido del archivo que leemos mediante
    // el método leerFicheroDeTexto, al cual le pasamos como argumento la ruta al fichero.
    public Wrapper_IB(String path) {
        try {
            this.xml = Lector.leerFicheroDeTexto(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    // Este método se encarga de coger el contenido del archivo xml para aplicarle la conversión al modelo
    // de datos JSON que vamos a usar en la integración.
    public String getJSON() {
        JSONObject obj = (JSONObject) XML.toJSONObject(this.xml);
        JSONObject response = (JSONObject) obj.get("response");
        JSONObject row1 = (JSONObject) response.get("row");
        JSONArray row2 = (JSONArray) row1.get("row");
        return row2.toString();
    }
}