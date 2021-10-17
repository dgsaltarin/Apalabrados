package com.dgsaltarin.apalabrados.controllers;

import com.dgsaltarin.apalabrados.models.Text;
import com.dgsaltarin.apalabrados.services.InputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/input")
public class ApalabradosController {

    private InputService inputService;

    @Autowired
    public ApalabradosController(InputService inputService) {
        this.inputService = inputService;
    }

    @PostMapping("/")
    @ResponseBody
    public ResponseEntity<Text> input(@RequestBody String input) {
        return new ResponseEntity<>(this.inputService.storeInput(input), HttpStatus.OK);
    }
}
