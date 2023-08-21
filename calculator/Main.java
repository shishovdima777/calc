package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = calc(input);
        System.out.println(result);
    }

    public static String calc(String input) {
        String[] split = input.split(" ");
        if (split.length != 3) {
            throw new IllegalArgumentException("No more than three variables should be accepted as input.");
        }
        int operand1;
        int operand2;
        char operator = split[1].charAt(0);
        int result;
        boolean isRoman = false;

        if (isRoman(split[0]) && isRoman(split[2])) {
            operand1 = toArabic(split[0]);
            operand2 = toArabic(split[2]);
            isRoman = true;
        } else {
            operand1 = Integer.parseInt(split[0]);
            operand2 = Integer.parseInt(split[2]);
        }
        if (operand1 > 10 || operand2 > 10) {
            throw new IllegalArgumentException("We work with numbers from 1 to 10 inclusive.");
        }

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            default:
                throw new IllegalArgumentException("String is not a mathematical operation.");
        }
        if (isRoman) {
            if (result < 1) {
                throw new IllegalArgumentException("There are no negative numbers in the roman system.");
            }
            return toRoman(result);
        } else {
            return Integer.toString(result);
        }
    }

    public static boolean isRoman(String str) {
        for (int i = 0; i < str.length(); i++) {
            char sym = str.charAt(i);
            if (sym != 'I' && sym != 'V' && sym != 'X') {
                return false;
            }
        }
        return true;
    }

    public static int toArabic(String roman) {
        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        } else {
            throw new IllegalArgumentException("We work with numbers from 1 to 10 inclusive.");
        }
    }

    public static String toRoman(int num) {
        String roman = "";
        while (num > 0) {
            if (num == 100) {
                return "C";
            } else if (num >= 90) {
                roman = roman + "XC";
                num = num - 90;
            } else if (num >= 50) {
                roman = roman + "L";
                num = num - 50;
            } else if (num >= 40) {
                roman = roman + "XL";
                num = num - 40;
            } else if(num >= 10) {
                roman = roman + "X";
                num = num - 10;
            } else if(num >= 9) {
                roman = roman + "IX";
                num = num - 9;
            } else if(num >= 5) {
                roman = roman + "V";
                num = num - 5;
            } else if(num >= 4) {
                roman = roman + "IV";
                num = num - 4;
            } else if(num >= 1) {
                roman = roman + "I";
                num = num - 1;
            }
        }
        return roman;
    }
}
