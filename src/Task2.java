/**
 * Задание 2
 * <p>
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */
public class Task2 {

    public static void main(String[] args) {
        double operand1 = 20.3;
        double operand2 = 2.3;
        char addition = '+';
        char subtraction = '-';
        char multiplication = '*';
        char division = '/';
        char divisionRemainder = '%';

        calculate(operand1, operand2, addition);
        calculate(operand1, operand2, subtraction);
        calculate(operand1, operand2, multiplication);
        calculate(operand1, operand2, division);
        calculate(operand1, operand2, divisionRemainder);

    }
    public static void calculate(double operand1, double operand2, char operation) {
        switch (operation) {
            case '+' -> System.out.println(operand1 + operand2 + " " + "(" + operand1 + " + " + operand2 + ")");
            case '-' -> System.out.println(operand1 - operand2 + " " + "(" + operand1 + " - " + operand2 + ")");
            case '*' -> System.out.println(operand1 * operand2 + " " + "(" + operand1 + " * " + operand2 + ")");
            case '/' -> System.out.println(operand1 / operand2 + " " + "(" + operand1 + " / " + operand2 + ")");
            case '%' -> System.out.println(operand1 % operand2 + " " + "(" + operand1 + " % " + operand2 + ")");
            default -> System.out.println("Данная операция не поддерживается");

        }
    }

}
