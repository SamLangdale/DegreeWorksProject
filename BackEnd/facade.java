package BackEnd;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class facade {
    private UserList userList;
    private User currentUser;
    private CourseList courseList;

    public facade() {
        userList = UserList.getInstance();
    }

    public boolean login(String userName, String password) {
        // Check if the provided userName and password match with any user in the system
        User user = userList.getUserByUsernameAndPassword(userName, password);

        if (user != null) {
            currentUser = user;
            return true;
        } else {
            return false; // No user found with the provided credentials
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }
    
    public boolean createAccount(String userName, String firstName, String lastName, String email, String uscid, UserType userType, String password) {
        // Check if the provided user type is valid
        if (userType == UserType.STUDENT || userType == UserType.ADVISOR) {
            // Create a new user object based on the userType
            User newUser;
            if (userType == UserType.STUDENT) {
                // Generate unique IDs for the student
                UUID studentId = UUID.randomUUID();
                UUID majorId = UUID.randomUUID();
                newUser = new Student(studentId, userName, firstName, lastName, email, uscid, new ArrayList<>(), new ArrayList<>(), majorId, "", 0.0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0, "", password);
                userList.addStudent((Student) newUser);
                DataWriter.saveStudents(); // Save to student JSON file
            } else {
                // Generate unique ID for the advisor
                UUID advisorId = UUID.randomUUID();
                newUser = new Advisor(advisorId, userName, firstName, lastName, email, uscid, new ArrayList<>(), password);
                userList.addAdvisor((Advisor) newUser);
                DataWriter.saveAdvisors(); // Save to advisor JSON file
            }
            currentUser = newUser;
            return true;
        } else {
            // Invalid user type provided
            return false;
        }
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
