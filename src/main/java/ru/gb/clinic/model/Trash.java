package ru.gb.clinic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "trash")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trash {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    @Column(name = "purchase_date")
    private Date puchaseDate;

    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Client client;
}
