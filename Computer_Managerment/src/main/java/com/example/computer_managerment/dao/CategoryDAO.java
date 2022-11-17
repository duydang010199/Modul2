package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends DatabaseContext implements ICategoryDAO{
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (name) VALUES (?);";
    private static final String SELECT_CATEGORY_BY_ID = "SELECT * FROM category WHERE idcategory = ?;";
    private static final String SELECT_ALL_CATEGORY = "SELECT * FROM category;";
    private static final String UPDATE_CATEGORY_SQL = "UPDATE category SET name = ? WHERE idcategory = ?;";
    private static final String DELETE_CATEGORY_SQL = "DELETE FROM category WHERE idcategory = ?;";

    @Override
    public void insertCategory(Category category) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL);
            preparedStatement.setString(1, category.getName());
            System.out.println(this.getClass() + " insertCategory " + preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        }
    }

//    @Override
//    public Category selectCategory(int id) {
//        Category category = null;
//        try {
//            Connection connection = getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
//            preparedStatement.setInt(1, id);
//            System.out.println(this.getClass() + " selectCategory " + preparedStatement);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                String name = resultSet.getString("name");
//                category = new Category(id, name);
//            }
//        } catch (SQLException e){
//            printSQLException(e);
//        }
//        return category;
//    }

    @Override
    public List<Category> selectAllCategory() {
        List<Category> category = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            System.out.println(this.getClass() + " selectAllCategory " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idcategory");
                String name = resultSet.getString("name");
                category.add(new Category(id,name));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return category;
    }

    @Override
    public boolean updateCategory(Category category) {
        boolean rowUpdate = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_SQL);
            System.out.println(this.getClass() + " updateCategory " + preparedStatement);
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            printSQLException(e);
        }
        return rowUpdate;
    }

    @Override
    public boolean deleteCategory(int id) {
        boolean rowDelete = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY_SQL);
            preparedStatement.setInt(1,id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e){
            printSQLException(e);
        }
        return rowDelete;
    }

    @Override
    public Category selectByIdCategory(int id) {
        Connection connection = getConnection();
        Category category = new Category();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idCategory = resultSet.getInt("idcategory");
                String name = resultSet.getString("name");
                category = new Category(idCategory, name);

            }

//            int idCategory = resultSet.getInt("idcategory");
//            System.out.println("id" + idCategory);
//            String name = resultSet.getString("name");
//            System.out.println("name" + name);
//            category = new Category(idCategory, name);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return category;
    }
}
