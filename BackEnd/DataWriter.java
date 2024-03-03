import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
    
    public static void saveStudents() {
        UserList studentList = UserList.getInstance();
        ArrayList<Student> students = studentList.getStudents();
        JSONArray jsonStudents = new JSONArray();
        
        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }
        
       
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
        
        
        for (Advisor advisor : advisors) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }
        
    
        try (FileWriter file = new FileWriter(ADVISOR_FILE_NAME)) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
 
    public static JSONObject getStudentJSON(Student student) {
        JSONObject studentDetails = new JSONObject();
        studentDetails.put(STUDENT_ID, student.getId().toString());
        studentDetails.put(STUDENT_USERNAME, student.getUserName());
        studentDetails.put(STUDENT_FIRST_NAME, student.getFirstName());
        studentDetails.put(STUDENT_LAST_NAME, student.getLastName());
        studentDetails.put(STUDENT_EMAIL, student.getEmail());
        studentDetails.put(STUDENT_USCID, student.getUscId());
        
        
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
