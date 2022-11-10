package ru.gb.clinic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String password;

    @ManyToMany
    private List<Authority> authorities;
}
