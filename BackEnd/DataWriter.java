package BackEnd;
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
        studentDetails.put(STUDENT_USCID, student.getUscid());
        
        JSONArray notesArray = new JSONArray();
        for (Note note : student.getNotes()) {
            JSONObject noteObj = new JSONObject();
            noteObj.put(STUDENT_NOTE_TITLE, note.getTitle());
            noteObj.put(STUDENT_NOTE_DATE, note.getDate());
            noteObj.put(STUDENT_NOTE_CONTENT, note.getContent());
            notesArray.add(noteObj);
        }
        studentDetails.put(STUDENT_NOTES, notesArray);
        
        JSONArray warningsArray = new JSONArray();
        for (Warning warning : student.getWarnings()) {
            warningsArray.add(warning.toString());
        }
        studentDetails.put(STUDENT_WARNINGS, warningsArray);
        
        studentDetails.put(STUDENT_PROFILE_ID, student.getStudentProfileId().toString());
        
        return studentDetails;
    }
    
    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject advisorDetails = new JSONObject();
        advisorDetails.put(ADVISOR_UUID, advisor.getId().toString());
        advisorDetails.put(ADVISOR_USERNAME, advisor.getUserName());
        advisorDetails.put(ADVISOR_FIRST_NAME, advisor.getFirstName());
        advisorDetails.put(ADVISOR_LAST_NAME, advisor.getLastName());
        advisorDetails.put(ADVISOR_EMAIL, advisor.getEmail());
        advisorDetails.put(ADVISOR_USCID, advisor.getUscid());
        
        JSONArray assignedStudentsArray = new JSONArray();
        for (Student student : advisor.getAssignedStudents()) {
            assignedStudentsArray.add(student.getId().toString());
        }
        advisorDetails.put(ADVISOR_ASSIGNED_STUDENTS, assignedStudentsArray);
        
        return advisorDetails;
    }

    public static void saveCourses() {
        
    }
    
    public static JSONObject getCoursesJSON(Course coures) {
        
    }
    
}

