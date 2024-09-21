package arrays;

/**
 * ﻿Задание 1
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class ArraysTask1 {
    private static final int[] array = {0, -4, 0, -5, 3, 1, -5, -9, 0, 5, 0, -8};

    public static void main(String[] args) {
        int quantityNegativeNumbers = calculatingNegativeNumbers(array);

        createPositiveArray(quantityNegativeNumbers, array);
    }

    public static int calculatingNegativeNumbers(int[] array) {
        int negativeNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                negativeNumber = negativeNumber + 1;
            }
        }

        return negativeNumber;
    }

    public static int[] createPositiveArray(int negativeNumber, int[] array) {
        int sizeArrayPositive = array.length - negativeNumber;
        int[] arrayPositive = new int[sizeArrayPositive];
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 0) {
                arrayPositive[count] = array[i] * arrayPositive.length;
                System.out.print(arrayPositive[count] + " ");
                count++;
            }
        }
        return arrayPositive;
    }
}



