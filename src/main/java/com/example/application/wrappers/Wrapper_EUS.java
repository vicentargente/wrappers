package com.example.application.wrappers;

import java.io.FileNotFoundException;

import com.example.application.util.Lector;

public class Wrapper_EUS {
    private String path;

    public Wrapper_EUS(String path) {
        this.path = path;
    }

    public String getJSON(){
        try {
            return Lector.leerFicheroDeTexto(this.path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return "";
    }
}