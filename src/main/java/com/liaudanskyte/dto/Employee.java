package com.liaudanskyte.dto;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Employee {
    private String name;
    private ContractType contractType;
    private Double rate;

    public Employee(ContractType contractType, String name, Double rate) {
        this.contractType = contractType;
        this.name = name;
        this.rate = rate;
    }

    public Employee() {
    }

    public Double getWeeklySalary() {
        return getRate();
    }

    public Double getWeeklySalary(int newRate) {
        return (double) Math.max(getRate(), newRate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ContractType getContractType() {
        return contractType;
    }

    public void setContractType(ContractType contractType) {
        this.contractType = contractType;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%.2f", contractType, name, rate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && contractType == employee.contractType && Objects.equals(rate, employee.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, contractType, rate);
    }
}
