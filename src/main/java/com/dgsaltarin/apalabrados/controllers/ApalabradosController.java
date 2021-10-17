package com.dgsaltarin.apalabrados.controllers;

import com.dgsaltarin.apalabrados.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/input")
public class ApalabradosController {

    private InputService inputService;

    @Autowired
    public ApalabradosController(InputService inputService) {
        this.inputService = inputService;
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<String> input(@RequestBody Map<String, Object> input) {
        return new ResponseEntity<>(this.inputService.evaluateInput(input.get("input").toString()), HttpStatus.OK);
    }
}
