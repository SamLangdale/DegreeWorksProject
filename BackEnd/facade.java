package BackEnd;

import java.util.ArrayList;

public class facade extends uuid {

    private User user;
    private User currentUser;

    public boolean createAccount(String userName, String password, String firstName, String lastName) {
        return user.addUser(userName, password, firstName, lastName);
    }

    public boolean login(String userName) {
        if(!user.haveUser(userName))return false;
		
		currentUser = user.getUser(userName);
		return true;
    }

    public User getCurrentUser() {
        return currentUser;
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

    }

    public void viewGrades() {
    }

    public void selectStudent() {
    }

}
