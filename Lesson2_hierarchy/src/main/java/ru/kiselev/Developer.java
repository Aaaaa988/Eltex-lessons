package ru.kiselev;

import java.util.ArrayList;

public class Developer extends User{
    ArrayList<String> prog_langs;

    public Developer(String name, Integer phone, Integer id){
        this.name = name;
        this.phone = phone;
        this.id = id;
        prog_langs = new ArrayList<String>();
    }

    public ArrayList<String> getProg_langs() {
        return prog_langs;
    }

    public void addLang(String... args) {
        for (String str : args) {
            prog_langs.add(str);
        }
    }

}
