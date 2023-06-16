package ru.otus.homework.util;

import lombok.Setter;
import ru.otus.homework.exception.StringReaderException;
import ru.otus.homework.util.Interfaces.StringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CSVResourceStringReader implements StringReader {

    @Setter
    private String fileName;


    @Override
    public List<String> readAllStrings() throws StringReaderException {

        if (fileName == null) {
            throw new StringReaderException("File name is null");
        }

        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new StringReaderException("File not found");
        }
        List <String> result = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new InputStreamReader(is));) {
            String row = "";
            while ((row = csvReader.readLine()) != null) {
                result.add (row);
            }
        } catch (IOException e) {
            throw new StringReaderException("Failed to read file: " + fileName + e.getMessage());
        }

        return result;
    }
}
