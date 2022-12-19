package com.liaudanskyte;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        Employee employeeMarcus = new Employee(ContractType.FIXED, "Marcus Bell", 150);
        Employee employeeTommy = new Employee(ContractType.FIXED, "Tommy Grekson", 180);
        Employee employeeJoan = new EmployeeFlexible(ContractType.FLEXIBLE, "Joan Watson", 4, 45);

        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(employeeMarcus);
        listOfEmployees.add(employeeTommy);
        listOfEmployees.add(employeeJoan);

        Company company = new Company(listOfEmployees);

        company.getEmployeeList().forEach(System.out::println);
        DataTransferService.writeDataLines(company.getEmployeeList());

    }
}
