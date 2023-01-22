package com.example.application.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.wrappers.Wrapper_CV;

@RestController
@RequestMapping(value = "/api/cv")
public class ControllerCV {
    private Wrapper_CV wrapper;

    // Este controlador extrae el path del fichero de la fuente de Euskadi y lo convierte a un String
    // para pasarselo al objeto Wrapper_EUS que crearemos posteriormente.
    public ControllerCV() {
        String pathToDataSource = new File("").getAbsolutePath()
                + "/src/main/resources/static/fuentesdatos/fuente_CV.csv";
        this.wrapper = new Wrapper_CV(pathToDataSource);
    }

    // Cada vez que se le solicita los centros sanitarios, se convierte el xml a
    // json gracias al wrapper
    @GetMapping(value = "/health-centers")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.status(HttpStatus.OK).body(this.wrapper.getJSON());
    }
}