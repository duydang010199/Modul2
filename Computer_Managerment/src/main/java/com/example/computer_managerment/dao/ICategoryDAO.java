package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Category;

import java.util.List;

public interface ICategoryDAO {
    public void insertCategory(Category category);
//    public Category selectCategory(int id);
    public List<Category> selectAllCategory();
    public boolean updateCategory(Category category);
    public boolean deleteCategory(int id);
    public Category selectByIdCategory(int id);
}
