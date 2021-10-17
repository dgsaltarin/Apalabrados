package com.dgsaltarin.apalabrados.repository;

import org.springframework.data.annotation.Id;

public class CharacterEntity {

    @Id
    private int id;

    private char character;
}
