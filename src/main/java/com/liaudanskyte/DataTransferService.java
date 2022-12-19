package com.liaudanskyte;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataTransferService {

    static List<Employee> readDataLines() {
        try {
            var reader = new BufferedReader(new FileReader("./src/main/resources/employeeData.csv"));
            return reader.lines().map(DataTransferService::convertStringToEmployee).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Employee convertStringToEmployee(String line) {
        List<String> elements = Arrays.asList(line.split(","));
        if (elements.get(0).equals(ContractType.FIXED.toString())) {
            return new Employee(ContractType.valueOf(elements.get(0)), elements.get(1), Integer.valueOf(elements.get(2)));
        } else if (elements.get(0).equals(ContractType.FLEXIBLE.toString())) {
            return new EmployeeFlexible(ContractType.valueOf(elements.get(0)), elements.get(1), Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)));
        } else {
            return new Employee();
        }
    }

    static void writeDataLines(List<Employee> lines) throws IOException {
        var writer = new BufferedWriter(new FileWriter("./src/main/resources/employeeData.csv"));
        lines.forEach(line -> {
            try {
                writer.write(line + "\n");
            } catch (IOException e) {
                throw new RuntimeException("Unable to write to file", e);
            }
        });

        writer.flush();
        writer.close();
    }
}
