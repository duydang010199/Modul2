package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Account;

import java.util.List;

public interface IAccountDAO {
    public List<Account> selectAllAccount();
}
