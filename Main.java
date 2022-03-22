import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Expression expression = new Expression();
        expression.parsing(line);
        int result;
        if (!expression.roman) {
            System.out.println(Calculation.opChoice(expression.operator, expression.a, expression.b));
        } else {
            result = (Calculation.opChoice(expression.operator, expression.a, expression.b));
            if (result < 1) {
                throw new Exception("Throws an exception, результат операций с римскими числами может быть только положительный!");
            } else
            System.out.println(Expression.toRoman(result));
        }
    }

    public enum Roman {
        I, II, III, IV, V, VI, VII, VIII, IX, X
    }
}


class Calculation {

    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) throws Exception {
        if (b == 0) {
            throw new Exception("throws Exception // Divide by zero!");
        }
        return a / b;
    }

    public static int opChoice(String operator, int operand1, int operand2) throws Exception {
        switch (operator){
            case "+":
                return Calculation.addition(operand1, operand2);
            case "-":
                return Calculation.subtraction(operand1, operand2);
            case "*":
                return Calculation.multiplication(operand1, operand2);
            case "/":
                return Calculation.division(operand1, operand2);
            default:
                String details = String.format("throws Exception //т.к. %s не является оператором.", operator);
                throw new Exception(details);
        }
    }
}


class Expression {
    public static Scanner scanner = new Scanner(System.in);
    public static int  []A = { 1, 4, 5, 9, 10, 40, 50, 90, 100};
    public static String []R = {"I","IV","V","IX","X","XL","L","XC","C"};
    int a;
    int b;
    String operand1;
    String operand2;
    String operator;
    static boolean roman = false;

    public void parsing(String expression) throws Exception {
        String[] scannedExpression = expression.split(" ");
        if (scannedExpression.length != 3) {
            throw new Exception("throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        try {
            operand1 = scannedExpression[0];
            operand2 = scannedExpression[2];
            operator = scannedExpression[1];
        } catch (Exception ArrayIndexOutOfBoundsException) {
            throw new Exception("throws Exception // т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
         if (!isRoman(scannedExpression[0]) && !isRoman(scannedExpression[2])){
                try {
                    a = Integer.parseInt(operand1);
                    b = Integer.parseInt(operand2);
                } catch (Exception NumberFormatException) {
                    throw new Exception("throws Exception // т.к. строка не является математической операцией");
                }
                if (a > 10 || b > 10 || a == 0 || b == 0) {
                    throw new Exception("throws Exception // т.к. не поддерживаются операции с числами больше 10");
                }
        } else if (isRoman(operand1) && isRoman(operand2)) {
                a = toArabic(operand1);
                b = toArabic(operand2);
                roman = true;
        } else {
            throw new Exception("throws Exception // т.к. используются одновременно разные системы счисления");
        }
    }


    public static boolean isRoman(String operand) throws Exception { // проверка, является ли число римским от 1 до 10
        if (operand.charAt(0) == 'X' && operand.length() > 1) {
            throw new Exception("throws Exception // т.к. поддерживаются только числа меньше 10");
        }
        int index = 1;
        for (Main.Roman value : Main.Roman.values()) {
            if (value.name().equals(operand)) {
                return true;
            }
            index++;
        } return false;
    }


    public static int toArabic(String operand) { // перевод из римских чисел в арабские
        int index = 0;
        int result = 0;
        for (Main.Roman value : Main.Roman.values()) {
            if (value.name().equals(operand)) {
                result = index + 1;
            }
            index++;
        } return result;
    }


    public static String toRoman(int num) { // перевод в римские числа из арабских
        int i = 8;
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            while (A[i] > num){
                i--;
            }
            result.append(R[i]);
            num -= A[i];

        }
        return result.toString();
    }
}

