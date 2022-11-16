package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends DatabaseContext implements IProductDAO{
    private int noOfRecords;
    private static final String INSERT_PRODUCTS_SQL = "INSERT INTO products (title, image, price, quantity, description , idcategory) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_ALL_PRODUCTS = "SELECT idproducts, title, image, price, quantity, description, idcategory FROM products;";
    private static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM products WHERE idproducts =?;";
    private static final String UPDATE_PRODUCT = "UPDATE products SET image=?, title =?, price=?, quantity =?, description =?, idcategory=? WHERE idproducts = ?;";
    private static final String DELETE_PRODUCT = "DELETE FROM products WHERE idproducts = ?;";

    @Override
    public List<Product> selectAllProductPagingFilter(int offset, int noOfRecords, String q) throws SQLException {
        Connection connection = getConnection();
        List<Product> listProduct = new ArrayList<>();
        String query = "SELECT SQL_CALC_FOUND_ROWS * FROM products where title like ? limit " + offset + "," + noOfRecords;
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, "%" + q + "%");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            int idProduct = resultSet.getInt("idproducts");
            String title = resultSet.getString("title");
            String images = resultSet.getString("image");
            double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String description = resultSet.getString("description");
            int category = resultSet.getInt("idcategory");
            Product products = new Product(idProduct ,title,images,price,quantity,description,category);
            listProduct.add(products);
        }
        resultSet = ps.executeQuery("SELECT FOUND_ROWS()");
        if (resultSet.next()) {
            this.noOfRecords = resultSet.getInt(1);
        }
        connection.close();
        return listProduct;
    }

    @Override
    public int getNoOfRecords() {
        return noOfRecords;
    }

    @Override
    public void insertProducts(Product products) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_SQL);
            preparedStatement.setString(1, products.getTitle());
            preparedStatement.setString(2, products.getImage());
            preparedStatement.setDouble(3, products.getPrice());
            preparedStatement.setInt(4, products.getQuantity());
            preparedStatement.setString(5, products.getDescription());
            preparedStatement.setInt(6,products.getIdCategory());
            System.out.println(this.getClass() + " insertProduct: " + preparedStatement);
            preparedStatement.executeUpdate();

        } catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Product selectProducts(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(this.getClass() + " selectProducts " + preparedStatement);
            while (resultSet.next()){
                int idProduct = resultSet.getInt("idproducts");
                String title = resultSet.getString("title");
                String images = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                int category = resultSet.getInt("idcategory");
                Product products = new Product(idProduct ,title,images,price,quantity,description,category);
                return products ;
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return null;
    }

    @Override
    public List<Product> selectAllProducts() {
        List<Product> listProduct = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            System.out.println(this.getClass() + " selectAllProducts " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idProduct = resultSet.getInt("idproducts");
                String title = resultSet.getString("title");
                String image = resultSet.getString("image");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String description = resultSet.getString("description");
                int idCategory = resultSet.getInt("idcategory");
                Product products = new Product(idProduct, title, image, price, quantity, description, idCategory);
                listProduct.add(products);
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return listProduct;
    }

    @Override
    public boolean deleteProducts(int id) {
        boolean flag = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            System.out.println(this.getClass() + " deleteProducts " + preparedStatement);
            flag = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            printSQLException(e);
        }
        return flag;
    }

    @Override
    public boolean updateProducts(Product products) {
        boolean flag = false;
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, products.getImage());
            preparedStatement.setString(2, products.getTitle());
            preparedStatement.setDouble(3, products.getPrice());
            preparedStatement.setInt(4, products.getQuantity());
            preparedStatement.setString(5, products.getDescription());
            preparedStatement.setInt(6,products.getIdCategory());
            preparedStatement.setInt(7, products.getIdProduct());
            System.out.println(this.getClass() + " updateProduct " + preparedStatement);
            flag = preparedStatement.executeUpdate() > 0;
            connection.close();
        } catch (SQLException e){
            printSQLException(e);
        }
        return flag;
    }
}
