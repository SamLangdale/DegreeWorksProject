package BackEnd;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {
   
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
        
        UUID majorId = student.getMajorId();
        studentDetails.put(STUDENT_MAJOR_ID, (majorId != null) ? majorId.toString() : "");
        
        studentDetails.put(STUDENT__MINOR, student.getMinor());
        studentDetails.put(STUDENT_GPA, student.getGPA());
        
        JSONArray takenCoursesArray = new JSONArray();
        for (Course course : student.getTakenCourses()) {
            takenCoursesArray.add(course.getId().toString());
        }
        studentDetails.put(STUDENT_TAKEN_COURSES, takenCoursesArray);
        
        JSONArray currentCoursesArray = new JSONArray();
        for (Course course : student.getCurrentCourses()) {
            currentCoursesArray.add(course.getId().toString());
        }
        studentDetails.put(STUDENT_CURRENT_COURSES, currentCoursesArray);
        
        JSONArray requiredCoursesArray = new JSONArray();
        for (Course course : student.getRequiredCourses()) {
            requiredCoursesArray.add(course.getId().toString());
        }
        studentDetails.put(STUDENT_REQUIRED_COURSES, requiredCoursesArray);
        
        studentDetails.put(STUDENT_EXPECTED_GRAD_YEAR, student.getExpectedGradYear());
        studentDetails.put(STUDENT_CURRENT_STUDENT_YEAR, student.getCurrentStudentYear());
        
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
        advisorDetails.put(ADVISOR_PASSWORD, advisor.getPassword());
        
        JSONArray assignedStudentsArray = new JSONArray();
        for (Student student : advisor.getAssignedStudents()) {
            assignedStudentsArray.add(student.getId().toString());
        }
        advisorDetails.put(ADVISOR_ASSIGNED_STUDENTS, assignedStudentsArray);
        
        return advisorDetails;
    }



    public static void saveCourses() {
        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCourses();
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
        courseDetails.put(COURSE_ID, course.getId().toString());
        courseDetails.put(COURSE_NUMBER, course.getCourseNumber());
        courseDetails.put(COURSE_NAME, course.getCourseName());
        courseDetails.put(COURSE_CREDIT_HOURS, course.getCreditHours());
        courseDetails.put(COURSE_FALL, course.isFall());
        courseDetails.put(COURSE_SPRING, course.isSpring());
        courseDetails.put(COURSE_ACRONYM, course.getCourseAcronym());

        JSONArray preReqArray = new JSONArray();
        for (PreReq preReq : course.getPreReqs()) {
            JSONObject preReqObj = new JSONObject();
            preReqObj.put(COURSE_NAME, preReq.getCourseName());
            preReqObj.put(COURSE_NUMBER, preReq.getCourseNumber());
            preReqObj.put(COURSE_ACRONYM, preReq.getCourseAcronym());

            JSONArray gradesArray = new JSONArray();
            for (Grades grade : preReq.getGrades()) {
                gradesArray.add(grade.toString());
            }
            preReqObj.put(COURSE_GRADES, gradesArray);

            preReqArray.add(preReqObj);
        }
        courseDetails.put(COURSE_PREREQUISITES, preReqArray);

        JSONArray coReqArray = new JSONArray();
        for (CoReq coReq : course.getCoReqs()) {
            JSONObject coReqObj = new JSONObject();
            coReqObj.put(COURSE_NAME, coReq.getCourseName());
            coReqObj.put(COURSE_NUMBER, coReq.getCourseNumber());
            coReqObj.put(COURSE_ACRONYM, coReq.getCourseAcronym());
            coReqArray.add(coReqObj);
        }
        courseDetails.put(COURSE_COREQUISITES, coReqArray);

        JSONArray gradesArray = new JSONArray();
        for (Grades grade : course.getGrades()) {
            gradesArray.add(grade.toString());
        }
        courseDetails.put(COURSE_GRADES, gradesArray);

        JSONArray reqTypeArray = new JSONArray();
        for (RequirementType reqType : course.getRequirementTypes()) {
            reqTypeArray.add(reqType.toString());
        }
        courseDetails.put(COURSE_REQUIREMENT_TYPE, reqTypeArray);

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
        majorDetails.put(MAJOR_NAME, major.getName());
        majorDetails.put(MAJOR_ID, major.getMajorId().toString());
        
        JSONArray coursesArray = new JSONArray();
        for (UUID courseId : major.getCourses()) {
            coursesArray.add(courseId.toString());
        }
        majorDetails.put(MAJOR_COURSES, coursesArray);
        
        return majorDetails;
    }
}

