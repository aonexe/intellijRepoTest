package com.intellijrepotest.intellijrepotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input");
        Scanner sc = new Scanner(inputFile);
        String[] text = sc.nextLine().split(" ");
        sc.close();

        File outputFile = new File("output");
        PrintWriter pw = new PrintWriter(outputFile);
        double x;
        double y;

        try {
            x = Double.parseDouble(text[0]);
            y = Double.parseDouble(text[2]);
        } catch (Exception e) {
            pw.println("Error! Not number");
            pw.close();
            return;
        }

        String[] operationArray = {"+", "-", "*", "/"};
        List<String> operationList = Arrays.asList(operationArray);

        try {
            boolean isOperator = operationList.contains(text[1]);
            if (!isOperator) {
                throw new Exception();
            }
        } catch (Exception e) {
            pw.println("Operation Error!");
            pw.close();
            return;
        }

        try {
            String operator = text[1];

            switch (operator) {
                case "+" -> {
                    pw.println(x + y);
                    pw.close();
                }
                case "-" -> {
                    pw.println(x - y);
                    pw.close();
                }
                case "*" -> {
                    pw.println(x * y);
                    pw.close();
                }
                case "/" -> {
                    if (y == 0) {
                        throw new Exception();
                    }
                    pw.println(x / y);
                    pw.close();
                }
            }
        } catch (Exception e) {
            pw.println("Error! Division by zero");
            pw.close();
        }
    }
}

