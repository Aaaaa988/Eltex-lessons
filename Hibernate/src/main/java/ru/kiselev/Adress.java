package ru.kiselev;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "adress")
@lombok.Setter
@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String street;
    private String building;

    public Adress(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @OneToMany(mappedBy = "adress", fetch = FetchType.EAGER)
    private Collection <User> owner;
}
