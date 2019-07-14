package ru.kiselev;

public abstract class User implements Comparable<User>{
    String name;
    Integer phone;
    Integer id;

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

}
