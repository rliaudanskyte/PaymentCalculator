package com.liaudanskyte;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class DataTransferService {

    static List<String> readDataLines() {
        try {
            var reader = new BufferedReader(new FileReader("./src/main/resources/employeeData.csv"));
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void writeDataLines(List<String> lines) throws IOException {
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
