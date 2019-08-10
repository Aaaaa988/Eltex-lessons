package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "users")
@lombok.Setter
@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String fio;
    private String phone;

    public User(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private Passport passport;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinColumn(name = "language_id")
    private Collection<Lang> lang;

    public String indexLang(){
        String str = "";
        for(Lang i: lang){
            str+= i.getId()+" ";
        }
        return str;
    }
}

