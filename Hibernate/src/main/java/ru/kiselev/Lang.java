package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "languages")
@lombok.Setter
@lombok.Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lang {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;

    public Lang(String title) {
        this.title = title;
    }

    @ManyToMany(mappedBy = "lang", fetch = FetchType.EAGER)
    private Collection <User> users;
}
