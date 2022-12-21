package com.liaudanskyte.dao;

import com.liaudanskyte.dto.Company;
import com.liaudanskyte.dto.SalaryLaborCodeRates;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCounterTest {
    private SalaryLaborCodeRates salaryLaborCodeRates = new SalaryLaborCodeRates();
    private Company company2 = new Company("src/main/resources/employeeDataTest1.csv");
    private Company companyWithSingleEmployee = new Company("src/main/resources/employeeDataTest2WithSingleEmployee.csv");
    private Company companyWithSingleEmployeeFlexibleUnderworked = new Company("src/main/resources/employeeDataTest3WithSingleEmployeeFlexibleUnderworked.csv");
    private Company companyWithSingleEmployeeFlexibleOverworked = new Company("src/main/resources/employeeDataTest4WithSingleEmployeeFlexibleOverworked.csv");
    private Company companyWithSingleEmployeeFlexible70hours = new Company("src/main/resources/employeeDataTest5WithSingleEmployeeFlexible70hours.csv");
    private LocalDate dateBeforeChange = LocalDate.of(2022, 2, 12);
    private LocalDate dateAfterChange = LocalDate.of(2023, 4, 21);

    @Test
    void salaryByWeekForSingleEmployeeBeforeChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployee);
        assertEquals(155, salaryCounter.salaryByWeek(dateBeforeChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeAfterChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployee);
        assertEquals(175, salaryCounter.salaryByWeek(dateAfterChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexibleUnderworkedBeforeChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexibleUnderworked);
        assertEquals(140, salaryCounter.salaryByWeek(dateBeforeChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexibleUnderworkedAfterChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexibleUnderworked);
        assertEquals(175, salaryCounter.salaryByWeek(dateAfterChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexibleOverworkedBeforeChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexibleOverworked);
        assertEquals(274, salaryCounter.salaryByWeek(dateBeforeChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexibleOverworkedAfterChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexibleOverworked);
        assertEquals(342.5, salaryCounter.salaryByWeek(dateAfterChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexible70HoursBeforeChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexible70hours);
        assertEquals(280, salaryCounter.salaryByWeek(dateBeforeChange));
    }

    @Test
    void salaryByWeekForSingleEmployeeFlexible70HoursAfterChange() {
        SalaryCounter salaryCounter = new SalaryCounter(salaryLaborCodeRates, companyWithSingleEmployeeFlexible70hours);
        assertEquals(350, salaryCounter.salaryByWeek(dateAfterChange));
    }
}