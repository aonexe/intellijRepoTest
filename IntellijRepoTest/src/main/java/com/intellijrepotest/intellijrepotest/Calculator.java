package com.intellijrepotest.intellijrepotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("calculatorText");
        Scanner sc = new Scanner(file);
        String[] text = sc.nextLine().split(" ");
        sc.close();
        double x;
        double y;

        try {
            x = Double.parseDouble(text[0]);
            y = Double.parseDouble(text[2]);
        } catch (Exception e) {
            System.out.println("Error! Not number");
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
            System.out.println("Operation Error!");
            return;
        }

        try {
            String operator = text[1];

            switch (operator) {
                case "+" -> System.out.println(x + y);
                case "-" -> System.out.println(x - y);
                case "*" -> System.out.println(x * y);
                case "/" -> {
                    if (y == 0) {
                        throw new Exception();
                    }
                    System.out.println(x / y);
                }
            }
        } catch (Exception e) {
            System.out.println("Error! Division by zero");
        }
    }
}

