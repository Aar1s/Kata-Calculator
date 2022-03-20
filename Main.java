import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] expression = scanner.nextLine().split(" ");
        if (numCheck(expression[0]) != 0 && (numCheck(expression[2]) != 0) {

        }
        numCheck(expression[2]);
        int result;
        switch (expression[1]){
            case "+":
                result = addition(Integer.parseInt(expression[0]), Integer.parseInt(expression[2]));
                System.out.println(result);
                break;
            case "-":
                result = subtraction(Integer.parseInt(expression[0]), Integer.parseInt(expression[2]));
                System.out.println(result);
                break;
            case "*":
                result = multiplication(Integer.parseInt(expression[0]), Integer.parseInt(expression[2]));
                System.out.println(result);
                break;
            case "/":
                result = division(Integer.parseInt(expression[0]), Integer.parseInt(expression[2]));
                System.out.println(result);
                break;
        }
    }
    public static int addition(int a, int b) {
        return a + b;
    }

    public static int subtraction(int a, int b) {
        return a - b;
    }

    public static int multiplication(int a, int b) {
        return a * b;
    }

    public static int division(int a, int b) {
        if (b == 0) {
            System.out.println("Divide by zero!");
        }
        return a / b;

    }

    public static enum Roman {
        I, II, III, IV, V, VI, VII, VIII, IX, X
    }
}
class Parser {
    public static Scanner scanner = new Scanner(System.in);
     int a;
     int b;

    public static void parsing(String expression) {
        String[] scannedExpression = scanner.nextLine().split(" ");
        if (scannedExpression.length != 3 || !scannedExpression[1].equals("+") && !scannedExpression[1].equals("-") &&
                !scannedExpression[1].equals("*") && !scannedExpression[1].equals("/") ) {
            System.out.println("throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else if ((numCheck(scannedExpression[0]) > 0) && numCheck(scannedExpression[2]) > 0){
            numCheck(scannedExpression[0]);
        }
    }
    public static int numCheck(String a) {
        try {
            Integer.parseInt(a);
        } catch (Exception NumberFormatException) {
            if (romanToArabic(a) != 0) {
                return romanToArabic(a);
            }
            System.out.println("Throws exception т.к. не является математической операцией.");
        } return 0;
    }

    public static int romanToArabic(String a) {
        int index = 1;
        for (Main.Roman value : Main.Roman.values()) {
            if (value.name().equals(a)) {
                return index;
            }
            index++;
        }return 0;
    }
}

