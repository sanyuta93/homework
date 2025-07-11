package org.example;

public class NumberComparison {
    public static String compare(int num1, int num2) {
        if (num1 > num2) {
            return num1 + " больше " + num2;
        } else if (num1 < num2) {
            return num1 + " меньше " + num2;
        } else {
            return "Числа равны";
        }
    }
}
