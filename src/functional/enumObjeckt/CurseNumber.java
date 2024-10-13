package functional.enumObjeckt;

public enum CurseNumber {
    I("1"),
    II("2"),
    III("3");

    private String courseNumber;

    CurseNumber(String s) {

    }


    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }
}
