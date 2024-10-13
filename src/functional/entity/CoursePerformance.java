package functional.entity;

import functional.enumObjeckt.CurseNumber;

import java.util.List;
import java.util.OptionalDouble;

public class CoursePerformance {
    private List<Student> students;
    private OptionalDouble avgGradeStudents;
    private CurseNumber curseNumber;


    public CoursePerformance(List<Student> students, OptionalDouble avgGradeStudents, CurseNumber curseNumber) {
        this.students = students;
        this.avgGradeStudents = avgGradeStudents;
        this.curseNumber = curseNumber;
    }

    public CoursePerformance() {
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public OptionalDouble getAvgGradeStudents() {
        return avgGradeStudents;
    }

    public void setAvgGradeStudents(OptionalDouble avgGradeStudents) {
        this.avgGradeStudents = avgGradeStudents;
    }

    public CurseNumber getCurseNumber() {
        return curseNumber;
    }

    public void setCurseNumber(CurseNumber curseNumber) {
        this.curseNumber = curseNumber;
    }

    public OptionalDouble average(List<Student> students, CurseNumber curseNumber) {
        OptionalDouble average = students.stream()
                .filter(student -> student.getUniversityCurseNumber() == curseNumber)
                .filter(student -> student.getGrade().size() > 3)
                .map(student -> student.getGrade()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .average())
                .mapToDouble(OptionalDouble::getAsDouble)
                .average();
        return average;
    }

    @Override
    public String toString() {
        return "CoursePerformance{" +
                "students=" + students +
                ", avgGradeStudents=" + avgGradeStudents +
                '}';
    }
}
