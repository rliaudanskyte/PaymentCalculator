package com.liaudanskyte.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeFlexible extends Employee{
    private int hoursWorked;

    public EmployeeFlexible(ContractType contractType, String name, Double rate) {
        super(contractType, name, rate);
    }

    public EmployeeFlexible(ContractType contractType, String name, Double rate, int hoursWorked) {
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
    public Double getWeeklySalary() {
        var overtime = hoursWorked > 40 ? hoursWorked - 40 : 0;
        return (super.getRate() * hoursWorked) + (overtime * super.getRate() * 0.5);
    }

    @Override
    public Double getWeeklySalary(int newRate) {
        var overtime = hoursWorked > 40 ? hoursWorked - 40 : 0;
        var rateSelected = Math.max(newRate, super.getRate());
        return (rateSelected * hoursWorked) + (overtime * rateSelected * 0.5);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",%s", hoursWorked);
    }
}
