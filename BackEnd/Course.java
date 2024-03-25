package BackEnd;
import java.util.ArrayList;
import java.util.UUID;

public class Course {
    protected UUID id;
    protected String courseName;
    protected String courseNumber;
    protected int creditHours;
    protected boolean fall;
    protected boolean spring;
    protected String courseAcronym;
    protected ArrayList<PreReq> preReqs;
    protected ArrayList<CoReq> coReqs;
    protected ArrayList<Grades> grades;
    protected ArrayList<RequirementType> requirementTypes;

    public Course(String courseName, String courseNumber, int creditHours, boolean fall, boolean spring,
                  String courseAcronym) {
        this.id = UUID.randomUUID();
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.creditHours = creditHours;
        this.fall = fall;
        this.spring = spring;
        this.courseAcronym = courseAcronym;
        this.preReqs = new ArrayList<>();
        this.coReqs = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.requirementTypes = new ArrayList<>();
    }

    public Course(UUID id, String courseName, String courseNumber, int creditHours, boolean fall, boolean spring,
                  String courseAcronym) {
        this.id = id;
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.creditHours = creditHours;
        this.fall = fall;
        this.spring = spring;
        this.courseAcronym = courseAcronym;
        this.preReqs = new ArrayList<>();
        this.coReqs = new ArrayList<>();
        this.grades = new ArrayList<>();
        this.requirementTypes = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public boolean isFall() {
        return fall;
    }

    public boolean isSpring() {
        return spring;
    }

    public String getCourseAcronym() {
        return courseAcronym;
    }

    public ArrayList<PreReq> getPreReqs() {
        return preReqs;
    }

    public void setPreReqs(ArrayList<PreReq> preReqs) {
        this.preReqs = preReqs;
    }

    public ArrayList<CoReq> getCoReqs() {
        return coReqs;
    }

    public void setCoReqs(ArrayList<CoReq> coReqs) {
        this.coReqs = coReqs;
    }

    public ArrayList<Grades> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grades> grades) {
        this.grades = grades;
    }

    public ArrayList<RequirementType> getRequirementTypes() {
        return requirementTypes;
    }

    public void setRequirementTypes(ArrayList<RequirementType> requirementTypes) {
        this.requirementTypes = requirementTypes;
    }
}



