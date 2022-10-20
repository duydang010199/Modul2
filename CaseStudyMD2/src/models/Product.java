package models;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private Long id;
    private String name;

    private String color;
    private Double price;
    private Double quantity;

    public Product(){}

    public Product(Long id, String name, String color, Double    price, Double quantity) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product parseProduct(String document) {
        String[] array = document.split(",");
        Long id = Long.parseLong(array[0].trim());
        String name = array[1].trim();
        String color = array[2].trim();
        Double price = Double.parseDouble(array[3].trim());
        Double quantity = Double.parseDouble(array[4].trim());
        return new Product(id, name, color, price, quantity);
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",
                id,
                name,
                color,
                price,
                quantity);
    }

    @Override
    public int compareTo(Product o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 && quantity == product.quantity && Objects.equals(name, product.name) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, color, price, quantity);
    }
}
