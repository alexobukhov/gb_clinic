package ru.gb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    private long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private int age;
}
