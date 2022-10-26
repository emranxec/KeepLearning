package com.xec.JavaEight.company.fruitShop;

import java.util.List;

class Fruit {
    String name;
    int price;
    List<FruitVendors> vendors;

    int quantity;


    public Fruit(String name, int price, List<FruitVendors> vendors, int quantity) {
        this.name = name;
        this.price = price;
        this.vendors = vendors;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<FruitVendors> getVendors() {
        return vendors;
    }

    public void setVendors(List<FruitVendors> vendors) {
        this.vendors = vendors;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", vendors=" + vendors +
                ", quantity=" + quantity +
                '}';
    }

    public void printFruit() {
        System.out.println(this);
    }
}
