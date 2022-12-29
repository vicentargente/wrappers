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

    public ControllerCV() {
        String pathToDataSource = new File("").getAbsolutePath()
                + "/src/main/resources/static/fuentesdatos/fuente_CV.csv";
        this.wrapper = new Wrapper_CV(pathToDataSource);
    }

    @GetMapping(value = "/health-centers")
    public ResponseEntity<String> testGet() {
        return ResponseEntity.status(HttpStatus.OK).body(this.wrapper.getJSON());
    }
}