/**
 * Задание 3
 * <p>
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * <p>
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {

    public static void main(String[] args) {

        int sideAofTriangleFirst = 2;
        int sideBofTriangleFirst = 2;

        int sideAofTriangleTwo = 2;
        int sideBofTriangleTwo = 2;

        double area1 = calculatingAreaTriangle(sideAofTriangleFirst, sideBofTriangleFirst);
        double area2 = calculatingAreaTriangle(sideAofTriangleTwo, sideBofTriangleTwo);

        comparisonTriangles(area1, area2);
    }
    public static double calculatingAreaTriangle(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println("Стороны должны быть положительными и больше нуля");

        }
        double area = (a * b) / 2;
        return area;
    }

    public static void comparisonTriangles(double area1, double area2) {
        if (area1 > 0 && area2 > 0) {
            if (area1 == area2) {
                System.out.println("Тругольники равны");
            } else if (area1 < area2) {
                System.out.println("Первый треугольник меньше второго");
            } else System.out.println("Первый треугольник больше второго");
        }
    }

}