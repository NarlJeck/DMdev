package lines;

/**
 * Задание 1
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */

public class Task1 {

    public static void main(String[] args) {

        StringBuilder line = new StringBuilder("abc Cpddd Dio OsfWw");
        StringBuilder lineNew = new StringBuilder();
        lineNew.append(Character.toUpperCase(line.charAt(0)));

        for (int i = 1; i < line.length(); i++) {

            if (line.charAt(i) == ' ') {
                line.deleteCharAt(i);
            }
        }
        for (int i = 1; i < line.length(); i++) {
            char current = line.charAt(i);
            char back = lineNew.charAt(lineNew.length() - 1);

            if (Character.toLowerCase(current) != Character.toLowerCase(back)) {
                lineNew.append(Character.toUpperCase(current));
            }
        }
        System.out.println(lineNew);
    }


}

