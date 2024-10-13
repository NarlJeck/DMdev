package functional.util;

import functional.entity.CoursePerformance;
import functional.entity.Student;
import functional.enumObjeckt.CurseNumber;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class CourseUtil {
    private CourseUtil() {
    }

    public static CoursePerformance createCoursePerformance(List<Student> students, CurseNumber curseNumber) {
        CoursePerformance coursePerformance = new CoursePerformance();
        List<Student> collect = students.stream()
                .filter(student -> student.getUniversityCurseNumber() == curseNumber)
                .filter(student -> student.getGrade().size() > 3)
                .sorted(Comparator.comparing(Student::getFirstName))
                .map(Student::getFullName)
                .collect(Collectors.toList());
        coursePerformance.setStudents(collect);
        coursePerformance.setAvgGradeStudents(coursePerformance.average(collect, curseNumber));
        coursePerformance.setCurseNumber(curseNumber);

        return coursePerformance;

    }
}
