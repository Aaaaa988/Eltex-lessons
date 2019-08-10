package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "passports")
@lombok.Setter
@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    public Passport(String series, String number) {
        this.series = series;
        this.number = number;
    }

    @OneToOne(mappedBy = "passport")
    private User user;
    private String series;
    private String number;
}
