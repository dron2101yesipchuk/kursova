package com.yesipchuk.demo.DAO.generalTypeOfMedicine.interfaces;

import com.yesipchuk.demo.model.GeneralTypeOfMedicine;

import java.sql.SQLException;
import java.util.List;

public interface IGeneralTypeOfMedicineDao {
    public List<GeneralTypeOfMedicine> getAll() throws SQLException;
}
