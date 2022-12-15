package com.liaudanskyte;

public class Employee {
    private String name;
    private ContractType contractType;
    private Integer rate;

    public Employee(String name, ContractType contractType, Integer rate) {
        this.name = name;
        this.contractType = contractType;
        this.rate = rate;
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
}
