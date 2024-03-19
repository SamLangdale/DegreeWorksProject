package BackEnd;
import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    private ArrayList<Note> notes;
    private ArrayList<Warning> warnings;
    private static UserList list = UserList.getInstance();
    
    private UUID majorId;
    private String minor;
    private double GPA;
    private ArrayList<Course> takenCourses;
    private ArrayList<Course> currentCourses;
    private ArrayList<Course> requiredCourses;
    private int expectedGradYear;
    private String currentStudentYear;
    private Advisor Advisor;
    public Student(UUID id, String userName, String firstName, String lastName, String email, String uscid,
            ArrayList<Note> notes, ArrayList<Warning> warnings, UUID majorId, String minor, double GPA,
            ArrayList<Course> takenCourses, ArrayList<Course> currentCourses, ArrayList<Course> requiredCourses,
            int expectedGradYear, String currentStudentYear, String password, Advisor Advisor) {// new parm advisor
                super(id, userName, firstName, lastName, email, uscid, password);
                this.notes = notes;
                this.warnings = warnings;
                this.majorId = majorId;
                this.minor = minor;
                this.GPA = GPA;
                this.takenCourses = takenCourses;
                this.currentCourses = currentCourses;
                this.requiredCourses = requiredCourses;
                this.expectedGradYear = expectedGradYear;
                this.currentStudentYear = currentStudentYear;
                if(hasAdvisor(this) || list == null )// if the list is null then no advisors should be assigned yet
                    this.Advisor = Advisor;
                else
                    AssignAdvisor(this);
                    //System.out.println(this.firstName+" your advsor is: "+this.Advisor); // code check
                }


    public Advisor getAdvisor() {
        return this.Advisor;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public ArrayList<Warning> getWarnings() {
        return warnings;
    }

    public UUID getMajorId() {
        return majorId;
    }
    private boolean hasAdvisor(Student Student) {return Student.Advisor != null; }

    public void setMajorId(UUID majorId) {
        this.majorId = majorId;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public ArrayList<Course> getTakenCourses() {
        return takenCourses;
    }

    public void setTakenCourses(ArrayList<Course> takenCourses) {
        this.takenCourses = takenCourses;
    }

    public ArrayList<Course> getCurrentCourses() {
        return currentCourses;
    }

    public void setCurrentCourses(ArrayList<Course> currentCourses) {
        this.currentCourses = currentCourses;
    }

    public ArrayList<Course> getRequiredCourses() {
        return requiredCourses;
    }

    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public int getExpectedGradYear() {
        return expectedGradYear;
    }

    public void setExpectedGradYear(int expectedGradYear) {
        this.expectedGradYear = expectedGradYear;
    }

    public String getCurrentStudentYear() {
        return currentStudentYear;
    }

    public void setCurrentStudentYear(String currentStudentYear) {
        this.currentStudentYear = currentStudentYear;
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void removeNote(Note note) {
        notes.remove(note);
    }

    public void editNote(Note oldNote, Note newNote) {
        int index = notes.indexOf(oldNote);
        if (index != -1) {
            notes.set(index, newNote);
        }
    }

    public void displayWarnings() {
        for (Warning warning : warnings) {
            System.out.println(warning);
        }
    }

    public void AssignAdvisor(Student student) {
        while (!student.hasAdvisor(student)) {
            student.Advisor = list.getAdvisors().get(0); // temp code
            list.getAdvisors().get(0).addAssignedStudent(student);
        }

    }
    public String getUSCID(){
        return uscid;
    }
    public void setUSCID(String uscid) {
        this.uscid = uscid;
    }
}




