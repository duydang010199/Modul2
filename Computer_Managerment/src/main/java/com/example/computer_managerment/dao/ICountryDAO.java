package com.example.computer_managerment.dao;

import com.example.computer_managerment.model.Country;

import java.util.List;

public interface ICountryDAO {
    public List<Country> selectAllCountry();
}
