package com.liaudanskyte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Company {
    private List<Employee> employeeList;

    public Company() {
        this.employeeList = DataTransferService.readDataLines();
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

//    public Double calculateTotal() {
//        AtomicReference<Double> total = new AtomicReference<>((double) 0);
//        employeeList.forEach(x -> {
//            total.updateAndGet(v -> v + x.weeklySalary());
//        });
//        return total.get();
//    }
}
