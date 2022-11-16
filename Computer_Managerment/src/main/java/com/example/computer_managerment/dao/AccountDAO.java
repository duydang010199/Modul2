package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO extends DatabaseContext implements IAccountDAO{

    private static final String SELECT_ALL_USERS = "SELECT * FROM account;";

    @Override
    public List<Account> selectAllAccount() {
        List<Account> listAccount = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int idAccount = resultSet.getInt("idaccount");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullname");
                int idCountry = resultSet.getInt("idcountry");
                Account account = new Account(idAccount,email,password,fullName,idCountry);
                listAccount.add(account);
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return listAccount;
    }


}
