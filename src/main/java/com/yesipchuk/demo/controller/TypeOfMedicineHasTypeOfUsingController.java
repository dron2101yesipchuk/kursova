package com.yesipchuk.demo.controller;

import com.yesipchuk.demo.model.TypeOfMedicineHasTypeOfUsing;
import com.yesipchuk.demo.service.typeOfMedicineHasTypeOfUsing.impls.TypeOfMedicineHasTypeOfUsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TypeOfMedicineHasTypeOfUsingController {
    @Autowired
    TypeOfMedicineHasTypeOfUsingService typeOfMedicineHasTypeOfUsingService;

    @RequestMapping("/type_medicine_has_type_using")
    public List<TypeOfMedicineHasTypeOfUsing> showTypeOfMedicineHasTypeOfUsing() throws SQLException {
        return typeOfMedicineHasTypeOfUsingService.getAll();
    }

    @RequestMapping("/type_medicine_has_type_using/del")
    public TypeOfMedicineHasTypeOfUsing deleteTypeOfMedicineHasTypeOfUsing(@RequestParam int id) throws SQLException{
        return typeOfMedicineHasTypeOfUsingService.deleteTypeOfMedicineHasTypeOfUsing(id);
    }
}
