package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public List<Product> selectAllProductPagingFilter(int offset, int noOfRecords, String q) throws SQLException;
    public int getNoOfRecords();
    public void insertProducts(Product products);
    public Product selectProducts(int id);
    public List<Product> selectAllProducts();
    public boolean deleteProducts(int id);
    public boolean updateProducts(Product products);
}
