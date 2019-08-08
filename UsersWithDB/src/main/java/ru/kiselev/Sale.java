package ru.kiselev;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    @Getter @Setter
    private String productName;
    @Getter @Setter
    private Integer productPrice;

    public ArrayList<Sale> packageSale(String name, Integer cost){
        ArrayList<Sale> sale = new ArrayList<>();
        sale.add(new Sale(name,cost));
        return sale;
    }
    public ArrayList<Sale> packageSale(String name, Integer cost, String name1, Integer cost1){
        ArrayList<Sale> sale = new ArrayList<>();
        sale.add(new Sale(name,cost));
        sale.add(new Sale(name1,cost1));
        return sale;
    }
}
