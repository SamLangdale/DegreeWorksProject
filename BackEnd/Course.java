package BackEnd;
import java.util.*;

public class Course {
    protected String CourseName;
    protected int CourseNum;
    protected int CredHours;
    protected boolean fall;
    protected boolean spring;
    protected ArrayList<PreReq> PreReq;
    protected ArrayList<CoReq> Coreq;
    protected ArrayList<Grades> Grades;
    protected boolean honors;
    protected CreditType CreditType;
    protected UUID courseID;
    protected String id;
    protected String courseAcronym; //

    public Course(String CourseName, int courseNum, int credHours, boolean fall, boolean spring,ArrayList<course> preReq, 
     ArrayList<Coreq> Coreq, boolean honors,CreditType CreditType, String id, String coureAcronym) {
        this.CourseName = CourseName;
        this.CourseNum = CourseNum;
        this.CredHours = CredHours;
        this.fall = fall;
        this.spring = spring;
        this.PreReq = preReq;
        this.Grades = Grades;
        this.honors = honors;
        this.CreditType = CreditType;
        this.courseID = courseID;
        this.id = id;
        this.courseAcronym = coureAcronym;

     }
    
}
