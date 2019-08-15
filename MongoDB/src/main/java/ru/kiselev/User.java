package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Getter @Setter
    protected Integer id;
    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String phone;

    @Override
    public String toString() {
        return getId()+getName()+getPhone();
    }
}
