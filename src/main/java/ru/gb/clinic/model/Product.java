package ru.gb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private long id;

    private String title;

    private float cost;
}
