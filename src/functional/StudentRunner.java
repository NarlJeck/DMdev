package functional;
/**
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * *
 * * 1. Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * *
 * * 2. Список студентов данного курса, но только с полями Имя и Фамилия.
 * * Список должен быть отсортированы по этим двум полям
 * *
 * * 3. Объект с двумя полями:
 * * - Отсортированный список студентов с пункта 2
 * * - Средняя оценка этих студентов
 * *
 * * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */


import functional.entity.CoursePerformance;
import functional.entity.Student;
import functional.enumObjeckt.CurseNumber;
import functional.util.CourseUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRunner {
    public static void main(String[] args) {
        Student student1 = new Student("Tyrion", "Lannister", CurseNumber.I, Arrays.asList(4, 4));
        Student student2 = new Student("Cersei", "Lannister", CurseNumber.I, Arrays.asList(4, 5));
        Student student3 = new Student("Daenerys", "Targaryen", CurseNumber.I, Arrays.asList(5, 5, 5, 4, 5, 4));
        Student student4 = new Student("Jon", "Snow", CurseNumber.I, Arrays.asList(4, 5));
        Student student5 = new Student("Jon", "Snow", CurseNumber.I, Arrays.asList(4, 5, 5, 5, 5));
        Student student6 = new Student("Sansa", "Stark", CurseNumber.I, Arrays.asList(4, 4, 5, 4, 5, 5));
        Student student7 = new Student("Arya", "Stark", CurseNumber.I, Arrays.asList(5, 5, 5, 5, 5, 5));
        Student student8 = new Student("Jaime", "Lannister", CurseNumber.I, Arrays.asList(5, 5, 4));
        Student student9 = new Student("Jorah", "Mormont", CurseNumber.I, Arrays.asList(4, 5));
        Student student10 = new Student("Theon", "Greyjoy", CurseNumber.I, Arrays.asList(5, 5));
        Student student11 = new Student("Samwell", "Tarly", CurseNumber.II, Arrays.asList(4, 3));
        Student student12 = new Student("Davos", "Seaworth", CurseNumber.II, Arrays.asList(4, 4, 5, 3, 3, 3));
        Student student13 = new Student("Petyr", "Baelish", CurseNumber.II, Arrays.asList(3, 4, 5, 3, 4, 4));
        Student student14 = new Student("Brandon", "Stark", CurseNumber.II, Arrays.asList(4, 4, 4, 4, 4));
        Student student15 = new Student("Sandor", " Clegane", CurseNumber.II, Arrays.asList(4, 4));
        Student student16 = new Student("Tormund", "Giantsbane", CurseNumber.II, Arrays.asList(3, 5));
        Student student17 = new Student("Tywin", "Lannister", CurseNumber.II, Arrays.asList(4, 4));
        Student student18 = new Student("Joffrey", " Baratheon", CurseNumber.II, Arrays.asList(4, 5));
        Student student19 = new Student("Margaery", " Tyrell", CurseNumber.II, Arrays.asList(4, 5));
        Student student20 = new Student("Daario", " Naharis", CurseNumber.II, Arrays.asList(4, 4));
        Student student21 = new Student("Ramsay", "Bolton", CurseNumber.III, Arrays.asList(3, 3));
        Student student22 = new Student("Jaqen", " H’ghar", CurseNumber.III, Arrays.asList(2, 3, 5));
        Student student23 = new Student("Robert", " Baratheon", CurseNumber.III, Arrays.asList(3, 3, 4, 4));
        Student student24 = new Student("Viserys", " Targaryen", CurseNumber.III, Arrays.asList(3, 5));
        Student student25 = new Student("Myrcella", " Baratheon", CurseNumber.III, Arrays.asList(2, 3, 5));
        Student student26 = new Student("Shireen ", "Baratheon", CurseNumber.III, Arrays.asList(2, 4, 3, 4, 5));
        Student student27 = new Student("Matthos", " Seaworth", CurseNumber.III, Arrays.asList(2, 3));
        Student student28 = new Student("Salladhor", " Saan", CurseNumber.III, Arrays.asList(4, 4, 4, 3, 5));
        Student student29 = new Student("Axel", "Florent", CurseNumber.III, Arrays.asList(2, 3, 4, 5));
        Student student30 = new Student("Walda", " Bolton ", CurseNumber.III, Arrays.asList(3, 4, 4, 5));

        List<Student> students = new ArrayList<>();

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        students.add(student12);
        students.add(student13);
        students.add(student14);
        students.add(student15);
        students.add(student16);
        students.add(student17);
        students.add(student18);
        students.add(student19);
        students.add(student20);
        students.add(student21);
        students.add(student22);
        students.add(student23);
        students.add(student24);
        students.add(student25);
        students.add(student26);
        students.add(student27);
        students.add(student28);
        students.add(student29);
        students.add(student30);

        CoursePerformance coursePerformance = CourseUtil.createCoursePerformance(students, CurseNumber.I);
        CoursePerformance coursePerformance2 = CourseUtil.createCoursePerformance(students, CurseNumber.II);
        CoursePerformance coursePerformance3 = CourseUtil.createCoursePerformance(students, CurseNumber.III);


        List<CoursePerformance> listCourse = new ArrayList<>();
        listCourse.add(coursePerformance);
        listCourse.add(coursePerformance2);
        listCourse.add(coursePerformance3);

        Map<CurseNumber, CoursePerformance> collect = listCourse.stream()
                .collect(Collectors.toMap(
                        CoursePerformance::getCurseNumber,
                        x -> x
                ));
        collect.forEach((k, v) -> System.out.println(k + " " + v));


    }
}
