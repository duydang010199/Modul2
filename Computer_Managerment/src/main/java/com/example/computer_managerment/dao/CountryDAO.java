package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO extends DatabaseContext implements ICountryDAO{
    private static final String SELECT_ALL_COUNTRY = "SELECT * FROM country";


    @Override
    public List<Country> selectAllCountry() {
        List<Country> listCountry = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRY);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(this.getClass() + " selectAllCountry " + preparedStatement);
            while (resultSet.next()){
                int id = resultSet.getInt("idcountry");
                String name = resultSet.getString("name");
                Country country = new Country(id,name);
                listCountry.add(country);
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return listCountry;
    }
}
