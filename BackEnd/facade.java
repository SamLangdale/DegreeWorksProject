package BackEnd;

import java.util.ArrayList;

public class facade extends uuid {

    private User currentUser;
    private String userName;
    private String password;

    public User login(String userName, String password, UserType userType) {
        this.userName = userName;
        this.password = password;

    }

    public void createSchedule(ArrayList<Course> takenCourses, ArrayList<Course> currentCourses,
                               ArrayList<Course> requiredCourses, ArrayList<PreReq> prereqs,
                               Major major, ArrayList<Grade> grades) {
        
    }

    public void logout() {
        
    }

    public void selectMajor() {
        
    }

    public void viewMajorMap(Major major, ArrayList<CourseList> takenCourses,
                             ArrayList<CurrentCourse> currentCourses,
                             ArrayList<CourseList> requiredCourses, ArrayList<PreReq> preReqs) {

        this.major = major;

    }

    public void viewGrades() {
    }

    public void selectStudent() {
    }

}
