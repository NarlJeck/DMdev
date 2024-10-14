package functional.entity;

import functional.enumObjeckt.CurseNumber;

import java.util.List;

/**
 * Задание 1
 * <p>
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * <p>
 * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * 3. Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * <p>
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class Student {
    private String firstName;
    private String lastName;
    CurseNumber curseNumber;
    private List<Integer> grade;

    public Student() {
    }

    public Student(String firstName, String lastName, CurseNumber curseNumber, List<Integer> grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.curseNumber = curseNumber;
        this.grade = grade;
    }

    public Student getFullName() {
        Student student = new Student();
        student.setGrade(this.grade);
        student.setUniversityCurseNumber(this.curseNumber);
        student.setFirstName(this.getFirstName() + " " + this.lastName);
        return student;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public CurseNumber getUniversityCurseNumber() {
        return curseNumber;
    }

    public void setUniversityCurseNumber(CurseNumber curseNumber) {
        this.curseNumber = curseNumber;
    }

    public List<Integer> getGrade() {
        return grade;
    }

    public void setGrade(List<Integer> grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student{" +
                "FullName='" + firstName + '\'' +
                ", universityCurseNumber=" + curseNumber +
                ", grade=" + grade +
                '}';
    }
}
