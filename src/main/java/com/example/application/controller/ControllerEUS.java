package com.example.application.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.wrappers.Wrapper_EUS;

@RestController
@RequestMapping(value = "/api/eus")
public class ControllerEUS {
    private Wrapper_EUS wrapper;

    public ControllerEUS() {
        String pathToDataSource = new File("").getAbsolutePath()
                + "/src/main/resources/static/fuentesdatos/fuente_EUS.json";
        this.wrapper = new Wrapper_EUS(pathToDataSource);
    }

    // Cada vez que se le solicita los centros sanitarios, se convierte el xml a
    // json gracias al wrapper
    @GetMapping(value = "/health-centers")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.status(HttpStatus.OK).body(this.wrapper.getJSON());
    }
}