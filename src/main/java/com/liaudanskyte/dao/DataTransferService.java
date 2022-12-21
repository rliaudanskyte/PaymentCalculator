package com.liaudanskyte.dao;

import com.liaudanskyte.dto.ContractType;
import com.liaudanskyte.dto.Employee;
import com.liaudanskyte.dto.EmployeeFlexible;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class DataTransferService {

    public static List<Employee> readDataLines(String fileUrl) {
        try {
            var reader = new BufferedReader(new FileReader(fileUrl));
            return reader.lines().map(DataTransferService::convertStringToEmployee).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee convertStringToEmployee(String line) {
        List<String> elements = Arrays.asList(line.split(","));
        if (elements.get(0).equals(ContractType.FIXED.toString())) {
            return new Employee(ContractType.valueOf(elements.get(0)), elements.get(1), Integer.valueOf(elements.get(2)));
        } else if (elements.get(0).equals(ContractType.FLEXIBLE.toString())) {
            return new EmployeeFlexible(ContractType.valueOf(elements.get(0)), elements.get(1), Integer.parseInt(elements.get(2)), Integer.parseInt(elements.get(3)));
        } else {
            return new Employee();
        }
    }

    public static void writeDataLines(List<Employee> lines, String fileUrl) throws IOException {
        var writer = new BufferedWriter(new FileWriter(fileUrl));
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
