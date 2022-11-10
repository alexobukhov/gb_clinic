package ru.gb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@Table(name = "authority")
public class Authority {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @ManyToMany
    private List<User> users;
}
