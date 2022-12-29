package com.example.application.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.wrappers.Wrapper_IB;

@RestController
@RequestMapping(value = "/api/ib")
public class ControllerIB {
    private Wrapper_IB wrapper;

    public ControllerIB() {
        String pathToDataSource = new File("").getAbsolutePath()
                + "/src/main/resources/static/fuentesdatos/fuente_IB.xml";
        this.wrapper = new Wrapper_IB(pathToDataSource);
    }

    // Cada vez que se le solicita los centros sanitarios, se convierte el xml a
    // json gracias al wrapper
    @GetMapping(value = "/health-centers")
    public ResponseEntity<String> testGet() {
        System.out.println(this.wrapper.getJSON());
        return ResponseEntity.status(HttpStatus.OK).body(this.wrapper.getJSON());
    }
}