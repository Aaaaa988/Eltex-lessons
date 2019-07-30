package ru.kiselev;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Developer extends User{
    ArrayList<String> prog_langs;

    public Developer(){
        super();
    }

    public Developer(String name, Integer phone, Integer id){
        this.name = name;
        this.phone = phone;
        this.id = id;
        prog_langs = new ArrayList<String>();
    }

    public void setProg_langs(ArrayList<String> prog_langs) {
        this.prog_langs = prog_langs;
    }

    public ArrayList<String> getProg_langs() {
        return prog_langs;
    }

    public String Langs_String(){
        String string = "";

        for(int i = 0; i< prog_langs.size(); i++){
            string += prog_langs.get(i)+ " ";
        }

        return string;
    }

    public void addLang(String... args) {
        for (String str : args) {
            prog_langs.add(str);
        }
    }

    @Override
    public String toString() {
        return getId()+" "+getName()+" "+getPhone() + " " + getProg_langs();
    }

    @Override
    public String writeToJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("Developer.json"), this);
        return objectMapper.writeValueAsString(this);
    }

    @Override
    public void readFromJSON(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Developer dump = objectMapper.readValue(filename ,Developer.class);

        this.id = dump.id;
        this.phone = dump.phone;
        this.name = dump.name;
        this.prog_langs = dump.prog_langs;
    }

}
