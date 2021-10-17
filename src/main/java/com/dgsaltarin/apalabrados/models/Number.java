package com.dgsaltarin.apalabrados.models;

import lombok.Data;

@Data
public class Number {

    private long number;
    private long accumulated;

    public Number(long number, long accumulated) {
        this.number = number;
        this.accumulated = accumulated;
    }
}
