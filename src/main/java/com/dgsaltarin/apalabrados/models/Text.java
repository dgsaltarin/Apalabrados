package com.dgsaltarin.apalabrados.models;

import lombok.Data;

@Data
public class Text {

    private String text;
    private char initial;
    private char last;

    public Text(String text, char initial, char last) {
        this.text = text;
        this.initial = initial;
        this.last = last;
    }
}
