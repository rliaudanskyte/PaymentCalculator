package com.liaudanskyte;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SalaryLaborCodeRates {
    private LocalDate dateOfLaborCodeChange = LocalDate.of(2023,1,1);
    private Integer fixedHourlyRateOld = 4;
    private Integer fixedMonthlyRateOld = 150;
    private Integer fixedHourlyRateNew = 5;
    private Integer fixedMonthlyRateNew = 175;

    public SalaryLaborCodeRates(
            LocalDate dateOfLaborcodeChange,
            Integer fixedHourlyRateNew,
            Integer fixedMonthlyRateNew
    ) {
        this.dateOfLaborCodeChange = dateOfLaborcodeChange;
        this.fixedHourlyRateNew = fixedHourlyRateNew;
        this.fixedMonthlyRateNew = fixedMonthlyRateNew;
    }

    public SalaryLaborCodeRates() {
    }

    public LocalDate getDateOfLaborCodeChange() {
        return dateOfLaborCodeChange;
    }

    public void setDateOfLaborCodeChange(LocalDate dateOfLaborCodeChange) {
        this.dateOfLaborCodeChange = dateOfLaborCodeChange;
    }

    public Integer getFixedHourlyRateOld() {
        return fixedHourlyRateOld;
    }

    public void setFixedHourlyRateOld(Integer fixedHourlyRateOld) {
        this.fixedHourlyRateOld = fixedHourlyRateOld;
    }

    public Integer getFixedMonthlyRateOld() {
        return fixedMonthlyRateOld;
    }

    public void setFixedMonthlyRateOld(Integer fixedMonthlyRateOld) {
        this.fixedMonthlyRateOld = fixedMonthlyRateOld;
    }

    public Integer getFixedHourlyRateNew() {
        return fixedHourlyRateNew;
    }

    public void setFixedHourlyRateNew(Integer fixedHourlyRateNew) {
        this.fixedHourlyRateNew = fixedHourlyRateNew;
    }

    public Integer getFixedMonthlyRateNew() {
        return fixedMonthlyRateNew;
    }

    public void setFixedMonthlyRateNew(Integer fixedMonthlyRateNew) {
        this.fixedMonthlyRateNew = fixedMonthlyRateNew;
    }
}
