package BackEnd;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants {

    public static ArrayList<Advisor> getAdvisors() {
        ArrayList<Advisor> advisors = new ArrayList<>();
    
        try {
            FileReader reader = new FileReader(ADVISOR_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray advisorArray = (JSONArray) parser.parse(reader);
    
            for (Object obj : advisorArray) {
                JSONObject advisorObj = (JSONObject) obj;
    
                UUID id = UUID.fromString((String) advisorObj.get("Advsioruuid"));
                String userName = (String) advisorObj.get("UserName");
                String firstName = (String) advisorObj.get("firstName");
                String lastName = (String) advisorObj.get("lastName");
                String email = (String) advisorObj.get("Email");
                String uscid = (String) advisorObj.get("USCID");
    
                JSONArray assignedStudentsArray = (JSONArray) advisorObj.get("AssignedStudents");
                ArrayList<Student> assignedStudents = new ArrayList<>();
    
                for (Object studentObj : assignedStudentsArray) {
                    JSONObject studentJsonObj = (JSONObject) studentObj;
                    String studentId = (String) studentJsonObj.get("Studentid");
                    
                    // Retrieve the Student object based on the studentId
                    Student student = getStudentById(studentId); // Implement this method
                    if (student != null) {
                        assignedStudents.add(student);
                    } else {
                        // Handle the case where the student is not found
                    }
                }
    
                // Create the Advisor object and add it to the advisors list
                Advisor advisor = new Advisor(id, userName, firstName, lastName, email, uscid, assignedStudents);
                advisors.add(advisor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return advisors;
    }
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
    
        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray studentArray = (JSONArray) parser.parse(reader);
    
            for (Object obj : studentArray) {
                JSONObject studentObj = (JSONObject) obj;
    
                UUID id = UUID.fromString((String) studentObj.get("Studentid"));
                String userName = (String) studentObj.get("Username");
                String firstName = (String) studentObj.get("firstName");
                String lastName = (String) studentObj.get("lastName");
                String email = (String) studentObj.get("Email");
                String uscid = (String) studentObj.get("USCID");
    
                JSONArray notesArray = (JSONArray) studentObj.get("notes");
                ArrayList<Note> notes = new ArrayList<>();
                for (Object noteObj : notesArray) {
                    JSONObject note = (JSONObject) noteObj;
                    String title = (String) note.get("title");
                    String date = (String) note.get("date");
                    String content = (String) note.get("content");
                    notes.add(new Note(title, date, content));
                }
    
                JSONArray warningsArray = (JSONArray) studentObj.get("warnings");
                ArrayList<Warning> warnings = new ArrayList<>();
                for (Object warningObj : warningsArray) {
                    if (warningObj instanceof String) {
                        String warningStr = (String) warningObj;
                        // Check if the Warning enum contains the given warning string
                        try {
                            Warning warning = Warning.valueOf(warningStr);
                            warnings.add(warning);
                        } catch (IllegalArgumentException e) {
                            // Handle the case where the warning string is not a valid enum value
                            System.err.println("Invalid warning: " + warningStr);
                        }
                    } else {
                        // Handle the case where the warning is not a string
                        System.err.println("Invalid warning format: " + warningObj);
                    }
                }
    
                String studentProfileIdStr = (String) studentObj.get("studentProfileid");
                UUID studentProfileId = UUID.fromString(studentProfileIdStr);
    
                Student student = new Student(id, userName, firstName, lastName, email, uscid, notes, warnings, studentProfileId);
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return students;
    }
    
    public static Student getStudentById(String studentId) {
        // Retrieve the list of loaded students
        ArrayList<Student> students = getStudents();
        
        // Iterate through the list of loaded students
        for (Student student : students) {
            if (student.getId().toString().equals(studentId)) {
                return student;
            }
        }
        return null; // Return null if no student with the given ID is found
    }
}