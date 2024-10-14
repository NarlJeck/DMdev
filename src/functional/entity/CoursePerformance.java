package functional.entity;

import functional.enumObjeckt.CurseNumber;

import java.util.List;
import java.util.OptionalDouble;

public class CoursePerformance {
    private List<Student> students;
    private Double avgGradeStudents;
    private CurseNumber curseNumber;


    public CoursePerformance(List<Student> students, Double avgGradeStudents, CurseNumber curseNumber) {
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

    public Double getAvgGradeStudents() {
        return avgGradeStudents;
    }

    public void setAvgGradeStudents(Double avgGradeStudents) {
        this.avgGradeStudents = avgGradeStudents;
    }

    public CurseNumber getCurseNumber() {
        return curseNumber;
    }

    public void setCurseNumber(CurseNumber curseNumber) {
        this.curseNumber = curseNumber;
    }

    public Double average(List<Student> students, CurseNumber curseNumber) {
        return students.stream()
                .filter(student -> student.getUniversityCurseNumber() == curseNumber)
                .filter(student -> student.getGrade().size() > 3)
                .map(student -> student.getGrade()
                        .stream()
                        .mapToDouble(Integer::doubleValue)
                        .average().getAsDouble())
                .mapToDouble(Double::doubleValue)
                .average().getAsDouble();
    }

    @Override
    public String toString() {
        return "CoursePerformance{" +
                "students=" + students +
                ", avgGradeStudents=" + avgGradeStudents +
                '}';
    }
}
