package services;

import models.Product;
import until.CSVUntil;
import java.util.ArrayList;
import java.util.List;

public class ProductServices implements ExtendProductServices {
    private static final String fileName = "C:\\Users\\ADMIN\\OneDrive\\Máy tính\\Modul2\\CaseStudyMD2\\data\\product.csv";
    private static ProductServices instanceProduct;
    public ProductServices(){}
    public static ProductServices getInstanceProduct(){
        if (instanceProduct == null){
            instanceProduct = new ProductServices();
        }
        return instanceProduct;
    }

    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        List<String> documents = CSVUntil.readFile(fileName);
        for (String document : documents) {
            products.add(Product.parseProduct(document));
        }
        return products;
    }

    @Override
    public void add(Product newProduct) {
        List<Product> products = findAllProduct();
        products.add(newProduct);
        CSVUntil.writeFile(fileName, products);

    }

    @Override
    public void editNameProduct(Product newProduct) {
        List<Product> products = findAllProduct();
        for (Product product : products) {
            if (product.getId().equals(newProduct.getId())) {
                String name = newProduct.getName();
                if (name != null && !name.isEmpty()) {
                    product.setName(newProduct.getName());
                }
//                String color = newProduct.getColor();
//                if (color != null && !color.isEmpty()) {
//                    product.setColor(newProduct.getColor());
//                }
//                Double price = newProduct.getPrice();
//                if (price != 0 && price != null) {
//                    product.setPrice(newProduct.getPrice());
//                }
//                Double quantity = newProduct.getQuantity();
//                if (quantity != 0 && quantity != null) {
//                    product.setQuantity(newProduct.getQuantity());
//                }
                CSVUntil.writeFile(fileName, products);
                break;
            }
        }
    }
    public void editColorProduct(Product newProduct) {
        List<Product> products = findAllProduct();
        for (Product product : products) {
            if (product.getId().equals(newProduct.getId())) {
                String color = newProduct.getColor();
                if (color != null && !color.isEmpty()) {
                    product.setColor(newProduct.getColor());
                }
                CSVUntil.writeFile(fileName, products);
                break;
            }
        }
    }
    public void editPriceProduct(Product newProduct) {
        List<Product> products = findAllProduct();
        for (Product product : products) {
            if (product.getId().equals(newProduct.getId())) {
                Double price = newProduct.getPrice();
                if (price != 0 && price != null) {
                    product.setPrice(newProduct.getPrice());
                }
                CSVUntil.writeFile(fileName, products);
                break;
            }
        }
    }
    public void editQuantityProduct(Product newProduct){
        List<Product> products = findAllProduct();
        for (Product product : products) {
            if (product.getId().equals(newProduct.getId())) {
                Double quantity = newProduct.getQuantity();
                if (quantity != 0 && quantity != null) {
                    product.setQuantity(newProduct.getQuantity());
                }
                CSVUntil.writeFile(fileName, products);
                break;
            }
        }
    }

    @Override
    public void removeProduct(Long idProduct) {
        List<Product> products = findAllProduct();
        products.removeIf(id -> id.getId().equals(idProduct));
        CSVUntil.writeFile(fileName, products);
    }
    @Override
    public boolean exitsById(Long id) {
        return checkId(id) != null;
    }
    @Override
    public Product checkId(Long id) {
        List<Product> products1 = findAllProduct();
        for (Product product : products1) {
            if (product.getId().equals(id)) ;
            return product;
        }
        return null;
    }
    @Override
    public List<Product> findProductByName(String name) {
        List<Product> products = findAllProduct();
        List<Product> listFind = new ArrayList<>();
        if (name != null) {
            for (Product oldProduct : products) {
                if (oldProduct.getName().toLowerCase().contains(name)) {
                    listFind.add(oldProduct);
                }
            }
        }
        return listFind;
    }
    @Override
    public void updateQuantity(Long idProduct, Double quantity){
        List<Product> products = findAllProduct();
        for (Product product : products){
            if (product.getId().equals(idProduct)){
                Double isQuantity = product.getQuantity();
                if (isQuantity >= quantity){
                    product.setQuantity(isQuantity - quantity);
                    CSVUntil.writeFile(fileName,products);
                    break;
                }
            }
        }
    }


}
