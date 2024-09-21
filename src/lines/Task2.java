package lines;

/**
 * Задание 2
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */

public class Task2 {
    private static String line = "vjnvnv3 3 jnjj5 jjn78jn 9fg0";

    public static void main(String[] args) {
        int[] ints = returnArrayNumbers(line);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        int sum = sumNumberArray(ints);
        System.out.println();
        System.out.println("Сумма чисел: " + sum);
    }

    public static int sumNumberArray(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = array[i] + sum;
        }
        return sum;
    }

    public static int[] returnArrayNumbers(String line) {

        int count = 0;
        for (int i = 0; i < line.length(); i++) {

            if (Character.isDigit(line.charAt(i))) {
                count++;
            }

        }
        int[] lineNumber = new int[count];
        int countNumber = 0;
        for (int i = 0; i < line.length(); i++) {

            if (Character.isDigit(line.charAt(i))) {
                lineNumber[countNumber] = Character.getNumericValue(line.charAt(i));
                countNumber++;
            }
        }
        return lineNumber;
    }
}

