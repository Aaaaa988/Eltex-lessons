package ru.kiselev;

public class Sale {
    private String productName;
    private Integer productPrice;

    public Sale() {
    }

    public Sale(String product, Integer priseProduct) {
        productName = product;
        productPrice = priseProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
