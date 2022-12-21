package com.liaudanskyte;

import com.liaudanskyte.dao.DataTransferService;
import com.liaudanskyte.dao.SalaryCounter;
import com.liaudanskyte.dto.Company;
import com.liaudanskyte.dto.SalaryLaborCodeRates;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.time.LocalDate;

public class App {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(App.class, args);
/*        System.out.println("Hello World!");
        Employee employeeMarcus = new Employee(ContractType.FIXED, "Marcus Bell", 150);
        Employee employeeTommy = new Employee(ContractType.FIXED, "Tommy Grekson", 180);
        Employee employeeJoan = new EmployeeFlexible(ContractType.FLEXIBLE, "Joan Watson", 4, 45);

        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employeeMarcus);
        listOfEmployees.add(employeeTommy);
        listOfEmployees.add(employeeJoan);

        Company company = new Company(listOfEmployees);*/
        Company company = new Company("./src/main/resources/employeeData.csv");
        SalaryCounter salaryCounter = new SalaryCounter(new SalaryLaborCodeRates(), company);

        company.printOutEmployeeList();
        System.out.println(salaryCounter.salaryByWeek(LocalDate.of(2021,10,10)));
        System.out.println(salaryCounter.salaryByWeek(LocalDate.of(2024,10,10)));
        DataTransferService.writeDataLines(company.getEmployeeList(), "./src/main/resources/employeeData.csv");

    }
}
