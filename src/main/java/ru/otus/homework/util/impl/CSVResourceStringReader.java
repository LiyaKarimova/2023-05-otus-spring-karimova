package ru.otus.homework.util.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import ru.otus.homework.config.AppProperties;
import ru.otus.homework.exception.StringReaderException;
import ru.otus.homework.util.StringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVResourceStringReader implements StringReader {

    private final String fileName;

    private final MessageSource messageSource;

    private final AppProperties prop;

    public CSVResourceStringReader(@Value("${question.bundleFileName}") String fileName, MessageSource messageSource, AppProperties prop) {
        this.messageSource = messageSource;
        this.prop = prop;
        this.fileName = messageSource.getMessage(fileName, null,prop.getLocale() );
    }

    @Override
    public List<String> readAllStrings() throws StringReaderException {

        if (fileName == null) {
            throw new StringReaderException("File name is null");
        }

        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        if (is == null) {
            throw new StringReaderException("File not found: " + fileName);
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
