import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    // public static void saveUsers() {
    //     UserList userList = UserList.getInstance();
    //     ArrayList<User> users = userList.getUsers();
    //     JSONArray jsonUsers = new JSONArray();
        
    //     // Creating JSON objects for users
    //     for (User user : users) {
    //         jsonUsers.add(getUserJSON(user));
    //     }
        
    //     // Write JSON file
    //     try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
    //         file.write(jsonUsers.toJSONString());
    //         file.flush();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    public static void saveStudents() {
        UserList studentList = UserList.getInstance();
        ArrayList<Student> students = studentList.getStudents();
        JSONArray jsonStudents = new JSONArray();
        
        // Creating JSON objects for students
        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }
        
        // Write JSON file
        try (FileWriter file = new FileWriter(STUDENT_FILE_NAME)) {
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void saveAdvisors() {
        UserList advisorList = UserList.getInstance();
        ArrayList<Advisor> advisors = advisorList.getAdvisors();
        JSONArray jsonAdvisors = new JSONArray();
        
        // Creating JSON objects for advisors
        for (Advisor advisor : advisors) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }
        
        // Write JSON file
        try (FileWriter file = new FileWriter(ADVISOR_FILE_NAME)) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // public static JSONObject getUserJSON(User user) {
    //     JSONObject userDetails = new JSONObject();
    //     userDetails.put(USER_ID, user.getId().toString());
    //     userDetails.put(USER_USER_NAME, user.getUserName());
    //     userDetails.put(USER_FIRST_NAME, user.getFirstName());
    //     userDetails.put(USER_LAST_NAME, user.getLastName());
    //     userDetails.put(USER_AGE, user.getAge());
    //     userDetails.put(USER_PHONE_NUMBER, user.getPhoneNumber());
        
    //     return userDetails;
    // }

    public static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(STUDENT_ID, student.getId().toString());
        studentDetails.put(STUDENT_USERNAME, student.getUserName());
        studentDetails.put(STUDENT_FIRST_NAME, student.getFirstName());
        studentDetails.put(STUDENT_LAST_NAME, student.getLastName());
        studentDetails.put(STUDENT_EMAIL, student.getEmail());
        studentDetails.put(STUDENT_USCID, student.getUscId());
        // Add other student details as needed
        
        return studentDetails;
    }

    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorDetails = new JSONObject();
        advisorDetails.put(ADVISOR_UUID, advisor.getId().toString());
        advisorDetails.put(ADVISOR_USERNAME, advisor.getUserName());
        advisorDetails.put(ADVISOR_FIRST_NAME, advisor.getFirstName());
        advisorDetails.put(ADVISOR_LAST_NAME, advisor.getLastName());
        advisorDetails.put(ADVISOR_EMAIL, advisor.getEmail());
        advisorDetails.put(ADVISOR_USCID, advisor.getUscId());
        // Add other advisor details as needed
        
        JSONArray assignedStudents = new JSONArray();
        for (String studentId : advisor.getAssignedStudentIds()) {
            JSONObject student = new JSONObject();
            student.put(ADVISOR_STUDENT_ID, studentId);
            assignedStudents.add(student);
        }
        advisorDetails.put(ADVISOR_ASSIGNED_STUDENTS, assignedStudents);
        
        return advisorDetails;
    }
}
