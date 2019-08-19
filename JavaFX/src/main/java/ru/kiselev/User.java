package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Getter
@lombok.Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String fio;
    private String phone;
}
