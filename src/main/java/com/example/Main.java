package com.example;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int sum = calculator.add(10, 5);
        int diff = calculator.subtract(10, 5);
        int prod = calculator.multiply(10, 5);
        int quot = calculator.divide(10, 5);

        System.out.println("10 + 5 = " + sum);
        System.out.println("10 - 5 = " + diff);
        System.out.println("10 * 5 = " + prod);
        System.out.println("10 / 5 = " + quot);

        if (sum == 15 && diff == 5 && prod == 50 && quot == 2) {
            System.out.println("All basic tests passed.");
        } else {
            System.err.println("Some tests failed.");
            System.exit(1);
        }
    }
}
