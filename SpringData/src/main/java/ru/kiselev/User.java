package ru.kiselev;

import lombok.*;;
import javax.persistence.*;

@lombok.Setter
@lombok.Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String fio;
    private String phone;

    public User(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }
}
