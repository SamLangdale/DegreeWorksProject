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
                newUser = new Student(UUID.randomUUID(), userName, firstName, lastName, email, uscid, new ArrayList<>(), new ArrayList<>(), UUID.randomUUID(), password);
                userList.addStudent((Student) newUser);
                DataWriter.saveStudents(); // Save to student JSON file
            } else {
                newUser = new Advisor(UUID.randomUUID(), userName, firstName, lastName, email, uscid, new ArrayList<>(), password);
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

     // Method to view the courses taken, grades earned, and pass/fail status
    public void viewCoursesTaken() {
        List<Course> coursesTaken = new ArrayList<>();

        // Iterate through all courses
        for (Course course : courseList.getCourses()) {
            // Check if the course has grades recorded
            if (!course.getGrades().isEmpty()) {
                coursesTaken.add(course);
                System.out.println("Course: " + course.getCourseName());
                System.out.println("Grade: " + calculateAverageGrade(course));
                System.out.println("Status: " + (hasPassed(course) ? "Passed" : "Failed"));
                System.out.println();
            }
        }

        // If no courses are taken
        if (coursesTaken.isEmpty()) {
            System.out.println("You haven't taken any courses yet.");
        }
    }

      // Helper method to calculate the average grade for a course
      private Grades calculateAverageGrade(Course course) {
        double sum = 0.0;
        for (Grades grade : course.getGrades()) {
            sum += grade.ordinal(); // Using ordinal value of enum
        }
        int average = (int) Math.round(sum / course.getGrades().size());
        return Grades.values()[average];
    }

    // Helper method to determine if a student has passed a course
    private boolean hasPassed(Course course) {
        return calculateAverageGrade(course).ordinal() >= Grades.D.ordinal();
    }

    // Method to view the courses yet to be taken
    public void viewCoursesToTake() {
        List<Course> coursesToTake = new ArrayList<>();

        // Iterate through all courses
        for (Course course : courseList.getCourses()) {
            // Check if the course doesn't have any grades recorded
            if (course.getGrades().isEmpty() && areCoRequisitesFulfilled(course)) {
                coursesToTake.add(course);
                System.out.println("Course: " + course.getCourseName());
            }
        }

        // If no courses are left to take
        if (coursesToTake.isEmpty()) {
            System.out.println("You have completed all available courses.");
        }
    }

    // Helper method to check if all co-requisites are fulfilled for a course
    private boolean areCoRequisitesFulfilled(Course course) {
        for (CoReq coReq : course.getCoReqs()) {
            // Check if co-requisite course has been taken
            if (!hasTakenCourse(coReq.getCourseName())) {
                return false;
            }
        }
        return true;
    }

    // Helper method to check if a course has been taken
    private boolean hasTakenCourse(String courseName) {
        for (Course takenCourse : courseList.getCourses()) {
            if (takenCourse.getCourseName().equals(courseName) && !takenCourse.getGrades().isEmpty()) {
                return true;
            }
        }
        return false;
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
