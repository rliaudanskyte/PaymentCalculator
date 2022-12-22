package com.liaudanskyte.dao;

import com.liaudanskyte.dto.ContractType;
import com.liaudanskyte.dto.Employee;
import com.liaudanskyte.dto.EmployeeFlexible;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataTransferServiceTest {

    private String badEmployeString = "FUX,Monk,z";
    private String fixedEmployeeString = "FIXED,Tommy Grekson,180.00";
    private String flexibleEmployeeString = "FLEXIBLE,Joan Watson,4.00,45";

    @Test
    void convertStringToEmployeeBadType() {
        assertNull(DataTransferService.convertStringToEmployee(badEmployeString));
    }

    @Test
    void successfulConvertingToFixedEmployee() {
        assertEquals(new Employee(ContractType.FIXED, "Tommy Grekson", 180.00), DataTransferService.convertStringToEmployee(fixedEmployeeString));
    }

    @Test
    void successfulConvertingToFlexibleEmployee() {
        assertEquals(new EmployeeFlexible(ContractType.FLEXIBLE, "Joan Watson", 4.00, 45), DataTransferService.convertStringToEmployee(flexibleEmployeeString));
    }
}