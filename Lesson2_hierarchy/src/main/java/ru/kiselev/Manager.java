package ru.kiselev;

import java.util.ArrayList;

public class Manager extends User{
    ArrayList<Sale> product;

    public Manager(String name, Integer phone, Integer id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        product = new ArrayList<>();
    }

    public void addProduct(Sale products) {
        product.add(products);
    }

    public ArrayList<String> getProduct() {
        ArrayList<String> buffer = new ArrayList<>();
        for (Sale i : product) {
            buffer.add(i.productName + " стоимостью: " + i.productPrice);
        }
        return buffer;
    }
}
