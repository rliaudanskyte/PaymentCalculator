## Salary Counter 


Program runs on Spring framework. 

There are few DTO classes, like `Employee` with a *fixed salary* and `EmployeeFlexible` with a *flexible contract*. 
These hold variables like `name`, `contractType`, `rates` and `hoursWorked`.

Class `Company` contains `List<Employee>`, which can be filled with new list as a `param` or from file `employeeData.csv` by default.

For the latter there is a service class `DataTransferService`. It can: 
 * write to file, 
 * reads from file,
 * convert read data to `Employee` instances.

With changes in the labor code helps DTO `SalaryLaborCodeRates`, which containes default and new labor rates, and a date of labor rates change.

Finally, `SalaryCounter` does exactly that, it counts weekly salaries, that a company has to pay on a given day.
However, this does not take into account, that some weeks may have days with old and new rates. It could on fixed salaries, but could not work out an easy way to determine worked hours for flexible contracts.
In addition, employees with flexible contracts have same amount of hours worked on each calculation. Although, it could be adjusted with dynamic `setHoursWorked()` method for each `employeeFlexible` instance individually or edit `employeeData.csv` file.

### Testing
Testing is done with unit tests in `AppTest` class in `test.java.com.liaudanslyte` package. 

