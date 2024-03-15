package BackEnd;

import java.util.ArrayList;
import java.util.UUID;

public class StudentProfile {
    private UUID studentProfileId;
    private UUID majorId;
    private String minor;
    private double GPA;
    private ArrayList<UUID> takenCourses;
    private ArrayList<UUID> currentCourses;
    private ArrayList<UUID> requiredCourses;
    private int ExpectedGradYear;
    private String currentStudentYear;
    public StudentProfile(UUID studentProfileId, UUID majorId, String minor, double GPA,
    ArrayList<UUID> takenCourses, ArrayList<UUID> currentCourses, ArrayList<UUID> requiredCourses, int ExpectedGradYear) {
        this.studentProfileId = studentProfileId;
        this.majorId = majorId;
        this.minor = minor;
        this.GPA = GPA;
        this.takenCourses = takenCourses;
        this.currentCourses = currentCourses;
        this.requiredCourses = requiredCourses;
        this.ExpectedGradYear = ExpectedGradYear;
        this.currentStudentYear = currentStudentYear;
    }

    

}
