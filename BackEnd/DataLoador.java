
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;;

public class DataLoador extends DataConstants {

    public static ArrayList<Advisor> getAdvisors() {

        ArrayList<Advisor> advisors = new ArrayList<>();

        try {
            FileReader reader = new FileReader(ADVISOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray adviosrJSON = (JSONArray) parser.parse(reader);

            for(int i = 0; i < adviosrJSON.size(); i++ ) {
                JSONObject advisorJSON = (JSONObject) advisorJSON.get(i);
                UUID id = UUID.fromString((String) advisorJSON.get(ADVISOR_UUID));
                String userName = (String) advisorJSON.get(ADVISOR_USERNAME);
                String firstName = (String) advisorJSON.get(ADVISOR_FIRST_NAME);
                String lastName = (String) advisorJSON.get(ADVISOR_LAST_NAME);
                String email = (String) advisorJSON.get(ADVISOR_EMAIL);
                String uscid = (String) advisorJSON.get(ADVISOR_USCID);
                JSONArray assignedStudents = (JSONArray) advisorJSON.get(ADVISOR_ASSIGNED_STUDENTS);
                ArrayList<String> assignedStudentIds = new ArrayList<>();
                for (Object obj : assignedStudents) {
                    JSONObject student = (JSONObject) obj;
                    assignedStudentIds.add((String) student.get(ADVISOR_STUDENT_ID));
                }

                advisors.add(new Advisor(id, userName, firstName, lastName, email, uscid, assignedStudentIds));
            }
            return advisors;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentsJSON = (JSONArray) parser.parse(reader);

            for (int i = 0; i < studentsJSON.size(); i++) {
                JSONObject studentJSON = (JSONObject) studentsJSON.get(i);
                UUID id = UUID.fromString((String) studentJSON.get(STUDENT_ID));
                String userName = (String) studentJSON.get(STUDENT_USERNAME);
                String firstName = (String) studentJSON.get(STUDENT_FIRST_NAME);
                String lastName = (String) studentJSON.get(STUDENT_LAST_NAME);
                String email = (String) studentJSON.get(STUDENT_EMAIL);
                String uscid = (String) studentJSON.get(STUDENT_USCID);
                JSONArray notes = (JSONArray) studentJSON.get(STUDENT_NOTES);
                JSONArray warnings = (JSONArray) studentJSON.get(STUDENT_WARNINGS);
                students.add(new Student(id, userName, firstName, lastName, email, uscid));
            }

            return students;

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
