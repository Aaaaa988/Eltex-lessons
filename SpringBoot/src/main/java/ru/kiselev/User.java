package ru.kiselev;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String fio;
    private String phone;
}
