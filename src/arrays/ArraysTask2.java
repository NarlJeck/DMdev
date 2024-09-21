package arrays;

/**
 * ﻿Задание 2
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести
 * на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class ArraysTask2 {
    private static char[] array = {'2', '+','r','3','@','_','-'};

    public static void main(String[] args) {

        int[] number = determiningSymbolNumber(array);
        System.out.println();
        int avg = definitionArithmeticMeanArray(number);
        System.out.println("Среднего арифметическое: " + avg);
        chooseValueGreaterAverage(number,avg);
    }

    public static int[] determiningSymbolNumber(char[] array) {
        int[] numberSymbol = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int number = array[i];
            numberSymbol[i] = number;
            System.out.print(number + " ");
        }
        return numberSymbol;
    }

    public static int definitionArithmeticMeanArray(int array[]) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum=sum+array[i];
        }
        return sum/array.length;
    }
    public static void chooseValueGreaterAverage(int [] array, int avg){
        for (int i = 0; i < array.length; i++) {
            if(array[i]>avg){
                System.out.print( array[i]+" ");
            }
        }
    }




}
