package ru.kiselev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public abstract class User implements Comparable<User>, JSON{
    protected String name;
    protected Integer phone;
    protected Integer id;

    public User(){

    }

    public User( Integer id, String name, Integer phone) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getPhone() {
        return phone;
    }

    public Integer getId() {
        return id;
    }

    public int compareTo(User user2) {
        return this.id.compareTo(user2.id);
    }

    public boolean equals(User user2) {
        return this.name.equals(user2.name);
    }

    @Override
    public String toString() {
        return getId()+getName()+getPhone();
    }

    @Override
    public String writeToJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("User.json"), this);
        return objectMapper.writeValueAsString(this);
    }

    @Override
    public void readFromJSON(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        User dump = objectMapper.readValue(filename,User.class);
        this.id = dump.id;
        this.phone = dump.phone;
        this.name = dump.name;


    }

}
