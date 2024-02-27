package BackEnd;

import java.util.ArrayList;

public class facade extends uuid {

    private User users;
    private User currentUser;
<<<<<<< HEAD:BackEnd/facade.java
    private String userName;
    private String password;

    public User login(String userName, String password, UserType userType) {
        this.userName = userName;
        this.password = password;

=======
    UserType usertype;


    public boolean createAccount(String userName, String password, UserType usertype) {
        return users.addUser(userName, password, usertype);
    }

    public User login(String userName, String password, UserType userType) {
        
>>>>>>> workingonthefacde:facade.java
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

<<<<<<< HEAD:BackEnd/facade.java
        this.major = major;

    }

=======
>>>>>>> workingonthefacde:facade.java
    public void viewGrades() {
    }

    public void selectStudent() {
    }

}
