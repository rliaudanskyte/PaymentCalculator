package com.liaudanskyte;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFlexible extends Employee{
    private int hoursWorked;

    public EmployeeFlexible(ContractType contractType, String name, Integer rate) {
        super(contractType, name, rate);
    }

    public EmployeeFlexible(ContractType contractType, String name, Integer rate, int hoursWorked) {
        super(contractType, name, rate);
        this.hoursWorked = Math.min(hoursWorked, 60);
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = Math.min(hoursWorked, 60);
    }

    @Override
    public Double weeklySalary() {
        var overtime = hoursWorked - 40;
        return (super.getRate() * hoursWorked) + (overtime * super.getRate() * 1.5);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",%s", hoursWorked);
    }
}
