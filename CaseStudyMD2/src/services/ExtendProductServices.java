package services;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public interface ExtendProductServices {
    List<Product> findAllProduct();
    void add(Product newProduct);
    void editNameProduct(Product newProduct);
    void removeProduct(Long idProduct);
    boolean exitsById(Long id);
    Product checkId(Long id);
    List<Product> findProductByName(String name);
    void updateQuantity(Long idProduct, Double quantity);

}
