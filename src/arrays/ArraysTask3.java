package arrays;

/**
 * ﻿Задание 3
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */
public class ArraysTask3 {
    private static int[] array = {0, 4, 5, 6, -7, 9, -0, 2, -5, -9, 6, -5, -7, -7, 8, 6, -4, -5, -2, 0, 0, 0,};

    public static void main(String[] args) {
        int sizeNegativeArray = countNegativeNumber(array);
        int sizeNullArray = countNullNumber(array);
        int sizePositiveArray = countPositiveNumber(array);
        int maxLine = definingMaxNumberLines(sizeNegativeArray, sizePositiveArray, sizeNullArray);
        int[] arraysPositive = createArraysPositive(sizePositiveArray, array);
        int[] arraysNegative = createArraysNegative(sizeNegativeArray, array);
        int[] arraysNull = createArraysNull(sizeNullArray, array);


        createTwoDimensionalArray(arraysPositive, arraysNegative, arraysNull, maxLine);

    }

    public static void createTwoDimensionalArray(int[] positiveArray, int[] negativeArray, int[] nullArray, int maxLine) {
        int[][] twoDimensionArray = new int[3][maxLine];

        twoDimensionArray[0] = new int[positiveArray.length];
        for (int i = 0; i < positiveArray.length; i++) {
            twoDimensionArray[0][i] = positiveArray[i];
            System.out.print(twoDimensionArray[0][i] + " ");
        }
        System.out.println();
        twoDimensionArray[1] = new int[negativeArray.length];
        for (int i = 0; i < negativeArray.length; i++) {
            twoDimensionArray[1][i] = negativeArray[i];
            System.out.print(twoDimensionArray[1][i] + " ");
        }

        System.out.println();

        twoDimensionArray[2] = new int[nullArray.length];
            for (int i = 0; i < nullArray.length; i++) {
                twoDimensionArray[2][i] = nullArray[i];

                System.out.print(twoDimensionArray[2][i] + " ");
        }

    }

    public static int definingMaxNumberLines(int sizeNegative, int sizePositive, int sizeNull) {
        return Math.max(sizeNegative, Math.max(sizePositive, sizeNull));
    }

    public static int countPositiveNumber(int[] array) {
        int countPositive = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                countPositive++;
            }
        }
        return countPositive;
    }

    public static int countNegativeNumber(int[] array) {
        int countNegative = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                countNegative++;
            }
        }
        return countNegative;
    }

    public static int countNullNumber(int[] array) {
        int countNull = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                countNull++;
            }
        }
        return countNull;
    }


    public static int[] createArraysPositive(int lenght, int[] array) {
        if (lenght == 0) {
            int[] arrayPositive = new int[0];
        }
        int countPositive = 0;
        int[] arrayPositive = new int[lenght];
        for (int i = 0; i < array.length; i++) {

            if (array[i] > 0) {
                arrayPositive[countPositive] = array[i];
                countPositive++;
            }
        }
        return arrayPositive;
    }

    public static int[] createArraysNegative(int lenght, int[] array) {
        if (lenght == 0) {
            int[] arrayNegative = new int[0];
        }
        int countNegative = 0;
        int[] arrayNegative = new int[lenght];
        for (int i = 0; i < array.length; i++) {

            if (array[i] < 0) {
                arrayNegative[countNegative] = array[i];
                countNegative++;
            }
        }
        return arrayNegative;
    }

    public static int[] createArraysNull(int lenght, int[] array) {
        if (lenght == 0) {
            int[] arrayNull = new int[0];
        }
        int countNull = 0;
        int[] arrayNull = new int[lenght];
        for (int i = 0; i < array.length; i++) {

            if (array[i] == 0) {
                arrayNull[countNull] = array[i];
                countNull++;
            }
        }
        return arrayNull;
    }
}