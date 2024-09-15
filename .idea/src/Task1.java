/**
 * Задание 1
 * <p>
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * <p>
 * Протестировать функцию в main.
 */
public class Task1 {
    public static void main(String[] args) {
        int minutes = 16;
        Task1.divideIntoQuarters(minutes);
        int minutes2 = 23;
        Task1.divideIntoQuarters(minutes2);
        int minutes3 = 33;
        Task1.divideIntoQuarters(minutes3);
        int minutes4 = 48;
        Task1.divideIntoQuarters(minutes4);
        int minutes5 = -2;
        Task1.divideIntoQuarters(minutes5);
    }

    public static void divideIntoQuarters(int minutes) {
        if (0 <= minutes && minutes <= 59) {
            if (0 <= minutes && minutes <= 15) {
                System.out.println("I-я четверть");
            } else if (16 <= minutes && minutes <= 30) {
                System.out.println("II-я четверть");
            } else if (31 <= minutes && minutes <= 45) {
                System.out.println("III-я четверть");
            } else if (46 <= minutes && minutes <= 59) {
                System.out.println("IV-четверть");
            }
        } else System.out.println("Введите число от 0 до 59");

    }
}
