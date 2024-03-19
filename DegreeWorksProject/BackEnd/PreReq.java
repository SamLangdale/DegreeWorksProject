package BackEnd;
import java.util.ArrayList;
public class PreReq {
    private String CourseName;
    private String CourseNumber;
    private String CourseAcronym;
    private ArrayList<Grades> grades;

    public PreReq(String CourseName, String CourseNumber, String CourseAcronym, ArrayList<Grades> grades) {
        this.CourseName = CourseName;
        this.CourseNumber = CourseNumber;
        this.CourseAcronym = CourseAcronym;
        this.grades = grades;
    }
  
    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }

    public String getCourseNumber() {
        return CourseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.CourseNumber = courseNumber;
    }

    public String getCourseAcronym() {
        return CourseAcronym;
    }

    public void setCourseAcronym(String courseAcronym) {
        this.CourseAcronym = courseAcronym;
    }

    public ArrayList<Grades> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grades> grades) {
        this.grades = grades;
    }
}