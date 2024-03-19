package BackEnd;
public class CoReq {
    private String CourseName;
    private String CourseNumber;
    private String CourseAcronym;

    public CoReq(String CourseName, String CourseNumber, String CourseAcronym) {
        this.CourseName = CourseName;
        this.CourseName = CourseNumber;
        this.CourseAcronym = CourseAcronym;
    }
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getCourseNumber() {
        return CourseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        CourseNumber = courseNumber;
    }

    public String getCourseAcronym() {
        return CourseAcronym;
    }

    public void setCourseAcronym(String courseAcronym) {
        CourseAcronym = courseAcronym;
    }
}