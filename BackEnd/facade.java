package BackEnd;

import java.util.ArrayList;

public class facade {

    private UserList userList;
    private User currentUser;
    private ArrayList <UserType> userType;
    
  

   public facade() {
    userList = UserList.getInstance();
}
    public boolean login(String userName) {
        // to Check if the provided userName belongs to either a student or an advisor
        Student student = userList.getStudent(userName);
        Advisor advisor = userList.getAdvisor(userName);
    
        if (student != null || advisor != null) {
            currentUser = (student != null) ? student : advisor;
            return true;
        } else {
            return false; // No user found with the provided userName
        }
    }
     

    public User getCurrentUser() {
        return currentUser;
    }
    public boolean signUp(String firstName, String lastName, String email, String uscid, ArrayList <UserType> userType) {

        

    }
}



  

 // public void createSchedule(ArrayList<Course> takenCourses, ArrayList<Course> currentCourses,
    //                            ArrayList<Course> requiredCourses, ArrayList<PreReq> prereqs,
    //                            Major major, ArrayList<Grade> grades) {
        
    // }

    // public void logout() {
        
    // }

    // public void selectMajor() {
        
    // }

    // public void viewMajorMap(Major major, ArrayList<CourseList> takenCourses,
    //                          ArrayList<CurrentCourse> currentCourses,
    //                          ArrayList<CourseList> requiredCourses, ArrayList<PreReq> preReqs) {

    // }

    // public void viewGrades() {
    // }

    // public void selectStudent() {
    // }
