package com.liaudanskyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
        Company company = new Company();
        SalaryCounter salaryCounter = new SalaryCounter(new SalaryLaborCodeRates(), company);

        company.getEmployeeList().forEach(System.out::println);
        System.out.println(salaryCounter.salaryByWeek(LocalDate.of(2021,10,10)));
        System.out.println(salaryCounter.salaryByWeek(LocalDate.of(2024,10,10)));
        DataTransferService.writeDataLines(company.getEmployeeList());

    }
}
