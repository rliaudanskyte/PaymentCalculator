package com.liaudanskyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public SalaryCounter(@Autowired SalaryLaborCodeRates salaryLaborCodeRates) {
        this.salaryLaborCodeRates = salaryLaborCodeRates;
    }

    public Double salaryByWeek(LocalDate dateOfPayment) {
        Double result;
        if (dateOfPayment.isBefore(salaryLaborCodeRates.getDateOfLaborCodeChange())) {
            result = company.getEmployeeList().stream()
                    .map(Employee::weeklySalary)
                    .reduce(0.0, Double::sum);
        } else {
            result = company.getEmployeeList().stream()
                    .map(employee -> {
                        double sum = 0.0;
                        if (employee.getContractType() == ContractType.FIXED) {
                            sum = Math.max(employee.getRate(), salaryLaborCodeRates.getFixedMonthlyRateNew());
                        } else if (employee.getContractType() == ContractType.FLEXIBLE){
                            EmployeeFlexible employeeFlexible = (EmployeeFlexible) employee;
                            sum = (double) employeeFlexible.getHoursWorked() * Math.max(employee.getRate(), salaryLaborCodeRates.getFixedHourlyRateNew());
                        }
                        return sum;
                    })
                    .reduce(0.0, Double::sum);
        }
        return result;
    }
}
