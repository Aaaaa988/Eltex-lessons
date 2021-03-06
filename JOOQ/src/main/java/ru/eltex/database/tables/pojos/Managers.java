/*
 * This file is generated by jOOQ.
 */
package ru.eltex.database.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.11"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Managers implements Serializable {

    private static final long serialVersionUID = 536682710;

    private final Integer id;
    private final String  name;
    private final String  phone;

    public Managers(Managers value) {
        this.id = value.id;
        this.name = value.name;
        this.phone = value.phone;
    }

    public Managers(
        Integer id,
        String  name,
        String  phone
    ) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Managers (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(phone);

        sb.append(")");
        return sb.toString();
    }
}
