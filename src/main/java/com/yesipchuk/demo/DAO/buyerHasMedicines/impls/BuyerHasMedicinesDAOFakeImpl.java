package com.yesipchuk.demo.DAO.buyerHasMedicines.impls;

import com.yesipchuk.demo.DAO.buyerHasMedicines.interfaces.IBuyerHasMedicinesDao;
import com.yesipchuk.demo.datastorage.DataStorageJDBC;
import com.yesipchuk.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuyerHasMedicinesDAOFakeImpl implements IBuyerHasMedicinesDao {
    @Autowired
    DataStorageJDBC dataStorage;


    @Override
    public List<BuyersHasMedicines> getAll() throws SQLException {
        List<BuyersHasMedicines> list = new ArrayList<>();
        ResultSet resultSet;
        resultSet = dataStorage.executeQuery("SELECT * FROM drugstore.buyer_has_medicine\n" +
                "JOIN medicine ON medicine.id = buyer_has_medicine.medicine_id\n" +
                "JOIN buyer ON buyer.id = buyer_has_medicine.buyer_id\n" +
                "JOIN dates_of_ordering_and_receiving ON dates_of_ordering_and_receiving.id" +
                " = buyer_has_medicine.dates_of_ordering_and_receiving_id\n" +
                "JOIN type_of_medicine ON type_of_medicine.id = medicine.type_of_medicine_id\n" +
                "JOIN order_status ON order_status.id = dates_of_ordering_and_receiving.order_status_id\n" +
                "JOIN general_type_of_medicine ON general_type_of_medicine.id " +
                "= type_of_medicine.general_type_of_medicine_id\n" +
                "JOIN type_of_production ON type_of_production.id = type_of_medicine.type_of_production_id;");
        while(resultSet.next()){
            list.add(new BuyersHasMedicines(
                    new Buyer(resultSet.getInt("buyer.id"),
                            resultSet.getString("buyer.PIB"),
                            resultSet.getInt("buyer.age")),
                    new Medicine(resultSet.getInt("medicine.id"),
                            resultSet.getString("medicine.name_of_medicine"),
                            new TypeOfMedicine(resultSet.getInt("type_of_medicine.id"),
                                    resultSet.getString("type_of_medicine.name_of_type"),
                                    new GeneralTypeOfMedicine(resultSet.getInt("general_type_of_medicine.id"),
                                            resultSet.getString("general_type_of_medicine.name_of_general_type")),
                                    new TypeOfProduction(resultSet.getInt("type_of_production.id"),
                                            resultSet.getString("type_of_production.type_of_production"))),
                            resultSet.getInt("medicine.critical_rate"),
                            resultSet.getInt("medicine.amount"),
                            resultSet.getDouble("medicine.price"),
                            resultSet.getDate("medicine.manufacture_date"),
                            resultSet.getInt("medicine.expiration_term")),
                    new DatesOfOrderingAndReceiving(
                            resultSet.getInt("dates_of_ordering_and_receiving.id"),
                            resultSet.getDate("dates_of_ordering_and_receiving.date_of_ordering"),
                            resultSet.getDate("dates_of_ordering_and_receiving.date_of_receiving"),
                            new OrderStatus(resultSet.getInt("order_status.id"),
                                    resultSet.getString("order_status.name_of_status"))),
                    resultSet.getString("PIB_of_doctor"),
                    resultSet.getString("diagnosis"),
                    resultSet.getInt("amount_of_medicine")));
        }
        return list;
    }
}
