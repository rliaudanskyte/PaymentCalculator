package com.liaudanskyte;

import java.time.LocalDate;

public class SalaryCounter {
    private LocalDate dateOfLaborcodeChange;
    private Integer fixedHourlyRateOld = 4;
    private Integer fixedMonthlyRateOld = 150;
    private Integer fixedHourlyRateNew;
    private Integer fixedMonthlyRateNew;

    public SalaryCounter(
            LocalDate dateOfLaborcodeChange,
            Integer fixedHourlyRateNew,
            Integer fixedMonthlyRateNew
    ) {
        this.dateOfLaborcodeChange = dateOfLaborcodeChange;
        this.fixedHourlyRateNew = fixedHourlyRateNew;
        this.fixedMonthlyRateNew = fixedMonthlyRateNew;
    }

    public SalaryCounter() {
    }

    public LocalDate getDateOfLaborcodeChange() {
        return dateOfLaborcodeChange;
    }

    public void setDateOfLaborcodeChange(LocalDate dateOfLaborcodeChange) {
        this.dateOfLaborcodeChange = dateOfLaborcodeChange;
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
