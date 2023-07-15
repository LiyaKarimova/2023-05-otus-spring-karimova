package ru.otus.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.homework.service.IOService;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceStream implements IOService {

    private final PrintStream output;

    private final Scanner input;

    public IOServiceStream() {
        this.output = System.out;
        this.input = new Scanner(System.in);
    }

    @Override
    public String readString() {
        return input.nextLine();
    }

    @Override
    public void printString(String str) {
        output.println(str);
    }
}
