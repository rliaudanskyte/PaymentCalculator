package com.liaudanskyte;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Company {
    private List<Employee> employeeList;

    public Company() {
        this.employeeList = DataTransferService.readDataLines();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Double calculateTotal() {
        AtomicReference<Double> total = new AtomicReference<>((double) 0);
        employeeList.stream().forEach(x -> {
            total.updateAndGet(v -> v + x.weeklySalary());
        });
        return total.get();
    }
}
