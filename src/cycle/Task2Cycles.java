package cycle;

/**
 * Задание 2
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */

public class Task2Cycles {
    public static void main(String[] args) {
        valueReversal(84155745);
    }

    private static int getMaxPower(int value) {
        int maxPower = 0;
        int currentValue = value;
        for (int i = 0; i < currentValue; i++) {
            maxPower += 1;
            currentValue /= 10;
        }
        return maxPower;
    }

    public static int exponentiation(int number, int power) {
        return (int) (number * Math.pow(10, power));
    }

    public static void valueReversal(int value) {
        System.out.print(value + " -> ");
        int maxPower = getMaxPower(value);
        int sum = 0;
        int currentValue = value;
        for (int i = 0; i < currentValue; i++) {
            int number = currentValue % 10;
            currentValue /= 10;
            maxPower -= 1;
            number = exponentiation(number, maxPower);
            sum += number;
        }
        System.out.println(sum);

    }

}

