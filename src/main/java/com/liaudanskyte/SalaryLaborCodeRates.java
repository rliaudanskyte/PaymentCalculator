package com.liaudanskyte;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class SalaryLaborCodeRates {
    private LocalDate dateOfLaborCodeChange = LocalDate.of(2023,1,1);
    private Integer hourlyRateOld = 4;
    private Integer weeklyRateOld = 150;
    private Integer hourlyRateNew = 5;
    private Integer weeklyRateNew = 175;

    public SalaryLaborCodeRates(
            LocalDate dateOfLaborcodeChange,
            Integer fixedHourlyRateNew,
            Integer weeklyRateNew
    ) {
        this.dateOfLaborCodeChange = dateOfLaborcodeChange;
        this.hourlyRateNew = fixedHourlyRateNew;
        this.weeklyRateNew = weeklyRateNew;
    }

    public SalaryLaborCodeRates() {
    }

    public LocalDate getDateOfLaborCodeChange() {
        return dateOfLaborCodeChange;
    }

    public void setDateOfLaborCodeChange(LocalDate dateOfLaborCodeChange) {
        this.dateOfLaborCodeChange = dateOfLaborCodeChange;
    }

    public Integer getHourlyRateOld() {
        return hourlyRateOld;
    }

    public void setHourlyRateOld(Integer hourlyRateOld) {
        this.hourlyRateOld = hourlyRateOld;
    }

    public Integer getWeeklyRateOld() {
        return weeklyRateOld;
    }

    public void setWeeklyRateOld(Integer weeklyRateOld) {
        this.weeklyRateOld = weeklyRateOld;
    }

    public Integer getHourlyRateNew() {
        return hourlyRateNew;
    }

    public void setHourlyRateNew(Integer hourlyRateNew) {
        this.hourlyRateNew = hourlyRateNew;
    }

    public Integer getWeeklyRateNew() {
        return weeklyRateNew;
    }

    public void setWeeklyRateNew(Integer weeklyRateNew) {
        this.weeklyRateNew = weeklyRateNew;
    }
}
