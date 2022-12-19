package com.liaudanskyte;

public class Employee {
    private String name;
    private ContractType contractType;
    private Integer rate;

    public Employee(ContractType contractType, String name, Integer rate) {
        this.contractType = contractType;
        this.name = name;
        this.rate = rate;
    }

    public Employee() {
    }

    public Double weeklySalary() {
        return Double.valueOf(getRate());
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

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%d", contractType, name, rate);
    }
}
