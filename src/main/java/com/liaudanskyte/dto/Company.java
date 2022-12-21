package com.liaudanskyte.dto;

import com.liaudanskyte.dao.DataTransferService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Company {
    private List<Employee> employeeList;

    public Company(String fileUrl) {
        this.employeeList = DataTransferService.readDataLines(fileUrl);
    }

    public Company(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> addEmployeeToList(Employee newEmployee) {
        getEmployeeList().add(newEmployee);
        return getEmployeeList();
    }

    public List<Employee> removeEmployeeFromList(int index) {
        getEmployeeList().remove(index);
        return getEmployeeList();
    }

    public void printOutEmployeeList() {
        AtomicInteger index = new AtomicInteger();
        employeeList.forEach(x -> {
            System.out.println(index + ". " + x);
            index.addAndGet(1);
        });
    }

}
