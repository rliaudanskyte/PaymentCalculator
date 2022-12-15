package com.liaudanskyte;

public class EmployeeFlexible extends Employee{
    private int hoursWorked;

    public EmployeeFlexible(String name, ContractType contractType, Integer rate) {
        super(name, contractType, rate);
    }

    public EmployeeFlexible(String name, ContractType contractType, Integer rate, int hoursWorked) {
        super(name, contractType, rate);
        this.hoursWorked = hoursWorked;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public Double weeklySalary() {
        var overtime = hoursWorked - 40;
        return (super.getRate() * hoursWorked) + (overtime * super.getRate() * 1.5);
    }
}
