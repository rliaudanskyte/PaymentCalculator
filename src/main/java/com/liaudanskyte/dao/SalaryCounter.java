package com.liaudanskyte.dao;

import com.liaudanskyte.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SalaryCounter {
    private SalaryLaborCodeRates salaryLaborCodeRates;
    private Company company;

    public SalaryCounter(
            @Autowired SalaryLaborCodeRates salaryLaborCodeRates,
            @Autowired Company company
    ) {
        this.salaryLaborCodeRates = salaryLaborCodeRates;
        this.company = company;
    }

    public Double salaryByWeek(LocalDate dateOfPayment) {
        Double result;
        if (dateOfPayment.isBefore(salaryLaborCodeRates.getDateOfLaborCodeChange())) {
            result = company.getEmployeeList().stream()
                    .map(Employee::getWeeklySalary)
                    .reduce(0.0, Double::sum);
        } else {
            result = company.getEmployeeList().stream()
                    .map(employee -> {
                        double sum = 0.0;
                        if (employee.getContractType() == ContractType.FIXED) {
                            sum = employee.getWeeklySalary(salaryLaborCodeRates.getWeeklyRateNew());
                        } else if (employee.getContractType() == ContractType.FLEXIBLE){
                            EmployeeFlexible employeeFlexible = (EmployeeFlexible) employee;
                            sum = employeeFlexible.getWeeklySalary(salaryLaborCodeRates.getHourlyRateNew());
                        }
                        return sum;
                    })
                    .reduce(0.0, Double::sum);
        }
        //todo: think about a scenario with days from both years
        return result;
    }
}
