package ru.kiselev;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Manager extends User{
    private Sale[] product;

    public Manager(){
    }

    public Manager(String name, Integer phone, Integer id, Sale[] product) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.product = product;
    }

    public void setProduct(Sale[] product) {
        this.product = product;
    }

     public ArrayList<String> ProductString() {
        ArrayList<String> buffer = new ArrayList<>();
        for (Sale i : product) {
            buffer.add(i.getProductName() + " стоимостью: " + i.getProductPrice());
        }
        return buffer;
    }

    public String Sale_String(){
        String string = "";

        for (Sale i : product) {
            string+=(i.getProductName() + " cost: " + i.getProductPrice()) + "; ";
        }

        return string;
    }

    public Sale[] getProduct() {
        return product;
    }

    @Override
    public String toString() {
        return getId() + " " + getName() + " " + getPhone()+ " " + ProductString();
    }

    @Override
    public String writeToJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("Manager.json"), this);

        return objectMapper.writeValueAsString(this);
    }

    @Override
    public void readFromJSON(String filename) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        Manager manager = objectMapper.readValue(filename, Manager.class);

        this.id = manager.id;
        this.phone = manager.phone;
        this.name = manager.name;
        this.product = manager.product;
    }
}
