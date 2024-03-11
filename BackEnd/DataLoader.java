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
                    
                    // Retrieves the Student object based on the studentId
                    Student student = getStudentById(studentId); // Implement this method
                    if (student != null) {
                        assignedStudents.add(student);
                    } else {
                        //Here we can handle the case where the student is not found
                    }
                }
    
                // Creates the Advisor object and adds it to the advisors list
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
                        // Check's if the Warning enum contains the given warning string
                        try {
                            Warning warning = Warning.valueOf(warningStr);
                            warnings.add(warning);
                        } catch (IllegalArgumentException e) {
                            // Handle's the case where the warning string is not a valid enum value
                            System.err.println("Invalid warning: " + warningStr);
                        }
                    } else {
                        // Handle's the case where the warning is not a string
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
        // Retrieve's the list of loaded students
        ArrayList<Student> students = getStudents();
        
        // Iterate's through the list of loaded students
        for (Student student : students) {
            if (student.getId().toString().equals(studentId)) {
                return student;
            }
        }
        return null; // Return's null if no student with the given ID is found
    }
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONParser parser = new JSONParser();
            JSONArray courseArray = (JSONArray) parser.parse(reader);

            for (Object obj : courseArray) {
                JSONObject courseObj = (JSONObject) obj;

                UUID id = UUID.fromString((String) courseObj.get("Couresid"));
                String courseNumber = (String) courseObj.get("CourseNumber");
                String courseAcronym = (String) courseObj.get("CourseAcronym");
                String courseName = (String) courseObj.get("CourseName");
                int creditHours = Integer.parseInt(courseObj.get("CreditHours").toString());
                boolean isFall = (boolean) courseObj.get("fall");
                boolean isSpring = (boolean) courseObj.get("spring");

                JSONArray majorsArray = (JSONArray) courseObj.get("CourseMajors");
                ArrayList<String> courseMajors = new ArrayList<>();
                for (Object majorObj : majorsArray) {
                    courseMajors.add((String) majorObj);
                }

                JSONArray gradesArray = (JSONArray) courseObj.get("Grades");
                ArrayList<String> grades = new ArrayList<>();
                for (Object gradeObj : gradesArray) {
                    grades.add((String) gradeObj);
                }

                JSONArray preReqArray = (JSONArray) courseObj.get("PreReq");
                ArrayList<PreReq> preReqs = new ArrayList<>();
                for (Object preReqObj : preReqArray) {
                    JSONObject preReqJsonObj = (JSONObject) preReqObj;
                    String CourseName = (String) preReqJsonObj.get("CourseName");
                    String CourseNumber = (String) preReqJsonObj.get("CourseNumber");
                    String CourseAcronym = (String) preReqJsonObj.get("CourseAcronym");

                    JSONArray preReqGradesArray = (JSONArray) preReqJsonObj.get("Grades");
                    ArrayList<String> preReqGrades = new ArrayList<>();
                    for (Object gradeObj : preReqGradesArray) {
                        preReqGrades.add((String) gradeObj);
                    }

                    preReqs.add(new PreReq(CourseName, CourseNumber, CourseAcronym, preReqGrades));
                }

                JSONArray coReqArray = (JSONArray) courseObj.get("CoReq");
                ArrayList<CoReq> coReqs = new ArrayList<>();
                for (Object coReqObj : coReqArray) {
                    JSONObject coReqJsonObj = (JSONObject) coReqObj;
                    String CourseName = (String) coReqJsonObj.get("CourseName");
                    String CourseNumber = (String) coReqJsonObj.get("CourseNumber");
                    String CourseAcronym = (String) coReqJsonObj.get("CourseAcronym");

                    coReqs.add(new CoReq(CourseName, CourseNumber, CourseAcronym));
                }

                Course course = new Course(id, courseNumber, courseAcronym, courseName, courseMajors, creditHours, grades, isFall, isSpring, preReqs, coReqs);
                courses.add(course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return courses;
    }
    

}