package BackEnd;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

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
        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCoures();
        JSONArray jsonCourses = new JSONArray();

        for (Course course : courses) {
            jsonCourses.add(getCoursesJSON(course));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCoursesJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURESES_COURESID, course.getId().toString());
        courseDetails.put(COURESES_COURSENUMBER, course.getCourseNumber());
        courseDetails.put(COURESES_COURSENAME, course.getCourseName());
        courseDetails.put(COURESES_CREDITHOURS, course.getCreditHours());
        courseDetails.put(COURESES_FALL, course.isFall());
        courseDetails.put(COURESES_SPRING, course.isSpring());
        courseDetails.put(COURESES_COURSEACRONYM, course.getCourseAcronym());

        JSONArray preReqArray = new JSONArray();
        for (PreReq preReq : course.getPreReqs()) {
            JSONObject preReqObj = new JSONObject();
            preReqObj.put(COURESES_COURSENAME, preReq.getCourseName());
            preReqObj.put(COURESES_COURSENUMBER, preReq.getCourseNumber());
            preReqObj.put(COURESES_COURSEACRONYM, preReq.getCourseAcronym());

            JSONArray gradesArray = new JSONArray();
            for (Grades grade : preReq.getGrades()) {
                gradesArray.add(grade.toString());
            }
            preReqObj.put(COURESES_GRADES, gradesArray);

            preReqArray.add(preReqObj);
        }
        courseDetails.put(COURESES_PREREQ, preReqArray);

        JSONArray coReqArray = new JSONArray();
        for (CoReq coReq : course.getCoReqs()) {
            JSONObject coReqObj = new JSONObject();
            coReqObj.put(COURESES_COURSENAME, coReq.getCourseName());
            coReqObj.put(COURESES_COURSENUMBER, coReq.getCourseNumber());
            coReqObj.put(COURESES_COURSEACRONYM, coReq.getCourseAcronym());
            coReqArray.add(coReqObj);
        }
        courseDetails.put(COURESES_COREQ, coReqArray);

        JSONArray gradesArray = new JSONArray();
        for (Grades grade : course.getGrades()) {
            gradesArray.add(grade.toString());
        }
        courseDetails.put(COURESES_GRADES, gradesArray);

        JSONArray reqTypeArray = new JSONArray();
        for (RequirementType reqType : course.getRequirementTypes()) {
            reqTypeArray.add(reqType.toString());
        }
        courseDetails.put(COURESES_REQUIREMENTTYPE, reqTypeArray);

        return courseDetails;
    }
       public static void saveMajors() {
        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> majors = majorList.getMajors();
        JSONArray jsonMajors = new JSONArray();
        
        for (Major major : majors) {
            jsonMajors.add(getMajorJSON(major));
        }
        
        try (FileWriter file = new FileWriter(MAJOR_FILE_NAME)) {
            file.write(jsonMajors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorDetails = new JSONObject();
        majorDetails.put("Name", major.getName());
        majorDetails.put("Majorid", major.getMajorId().toString());
        
        JSONArray coursesArray = new JSONArray();
        for (UUID courseId : major.getCourses()) {
            coursesArray.add(courseId.toString());
        }
        majorDetails.put("Courses", coursesArray);
        
        return majorDetails;
    }


    
    
}

