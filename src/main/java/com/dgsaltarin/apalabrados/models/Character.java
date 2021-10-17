package com.dgsaltarin.apalabrados.models;

import lombok.Data;

@Data
public class Character {

    private String character;

    public Character(String character) {
        this.character = character;
    }
}
