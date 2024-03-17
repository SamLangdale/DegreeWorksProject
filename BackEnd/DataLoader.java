package BackEnd;
import java.io.FileReader;
import java.io.IOException;
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
        
                UUID id = UUID.fromString((String) advisorObj.get(ADVISOR_UUID));
                String userName = (String) advisorObj.get(ADVISOR_USERNAME);
                String firstName = (String) advisorObj.get(ADVISOR_FIRST_NAME);
                String lastName = (String) advisorObj.get(ADVISOR_LAST_NAME);
                String email = (String) advisorObj.get(ADVISOR_EMAIL);
                String uscid = (String) advisorObj.get(ADVISOR_USCID);
                String password = (String) advisorObj.get(ADVISOR_PASSWORD);
        
                JSONArray assignedStudentsArray = (JSONArray) advisorObj.get(ADVISOR_ASSIGNED_STUDENTS);
                ArrayList<Student> assignedStudents = new ArrayList<>();
        
                for (Object studentObj : assignedStudentsArray) {
                    if (studentObj instanceof String) {
                        String studentId = (String) studentObj;
                        Student student = getStudentById(studentId);
                        if (student != null) {
                            assignedStudents.add(student);
                        } else {
                            // Handle case where student is not found
                        }
                    } else {
                        // Handle invalid data format
                    }
                }
        
                Advisor advisor = new Advisor(id, userName, firstName, lastName, email, uscid, assignedStudents, password);
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

            UUID id = null;
            String idString = (String) studentObj.get(STUDENT_ID);
            if (idString != null && !idString.isEmpty()) {
                id = UUID.fromString(idString);
            }

            String userName = (String) studentObj.get(STUDENT_USERNAME);
            String firstName = (String) studentObj.get(STUDENT_FIRST_NAME);
            String lastName = (String) studentObj.get(STUDENT_LAST_NAME);
            String email = (String) studentObj.get(STUDENT_EMAIL);
            String uscid = (String) studentObj.get(STUDENT_USCID);
            String password = (String) studentObj.get(STUDENT_PASSWORD);

            JSONArray notesArray = (JSONArray) studentObj.get(STUDENT_NOTES);
            ArrayList<Note> notes = new ArrayList<>();
            for (Object noteObj : notesArray) {
                JSONObject note = (JSONObject) noteObj;
                String title = (String) note.get(STUDENT_NOTE_TITLE);
                String date = (String) note.get(STUDENT_NOTE_DATE);
                String content = (String) note.get(STUDENT_NOTE_CONTENT);
                notes.add(new Note(title, date, content));
            }

            JSONArray warningsArray = (JSONArray) studentObj.get(STUDENT_WARNINGS);
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

            UUID majorId = null;
            Object majorIdObj = studentObj.get(STUDENT_MAJOR_ID);
            if (majorIdObj instanceof String) {
                String majorIdString = (String) majorIdObj;
                if (!majorIdString.isEmpty()) {
                    majorId = UUID.fromString(majorIdString);
                }
            } else {
                // Handle case where STUDENT_MAJOR_ID is not a string
                System.err.println("Invalid major ID format: " + majorIdObj);
            }

            String minor = (String) studentObj.get(STUDENT__MINOR);
            double GPA = Double.parseDouble(studentObj.get(STUDENT_GPA).toString());

            JSONArray takenCoursesArray = (JSONArray) studentObj.get(STUDENT_TAKEN_COURSES);
            ArrayList<Course> takenCourses = new ArrayList<>();
            if (takenCoursesArray != null) {
                for (Object courseIdObj : takenCoursesArray) {
                    if (courseIdObj instanceof String) {
                        String courseIdString = (String) courseIdObj;
                        UUID courseId = UUID.fromString(courseIdString);
                        Course course = CourseList.getInstance().getCourseById(courseId);
                        if (course != null) {
                            takenCourses.add(course);
                        } else {
                            // Handle case where course is not found
                        }
                    } else {
                        // Handle the case where courseIdObj is not a string
                        System.err.println("Invalid course ID format: " + courseIdObj);
                    }
                }
            } else {
                // Handle case where takenCoursesArray is null
                System.err.println("takenCoursesArray is null");
            }

            JSONArray currentCoursesArray = (JSONArray) studentObj.get(STUDENT_CURRENT_COURSES);
            ArrayList<Course> currentCourses = new ArrayList<>();
            if (currentCoursesArray != null) {
                for (Object courseIdObj : currentCoursesArray) {
                    if (courseIdObj instanceof String) {
                        String courseIdString = (String) courseIdObj;
                        UUID courseId = UUID.fromString(courseIdString);
                        Course course = CourseList.getInstance().getCourseById(courseId);
                        if (course != null) {
                            currentCourses.add(course);
                        } else {
                            // Handle case where course is not found
                        }
                    } else {
                        // Handle the case where courseIdObj is not a string
                        System.err.println("Invalid course ID format: " + courseIdObj);
                    }
                }
            } else {
                // Handle case where currentCoursesArray is null
                System.err.println("currentCoursesArray is null");
            }

            JSONArray requiredCoursesArray = (JSONArray) studentObj.get(STUDENT_REQUIRED_COURSES);
            ArrayList<Course> requiredCourses = new ArrayList<>();
            if (requiredCoursesArray != null) {
                for (Object courseIdObj : requiredCoursesArray) {
                    if (courseIdObj instanceof String) {
                        String courseIdString = (String) courseIdObj;
                        UUID courseId = UUID.fromString(courseIdString);
                        Course course = CourseList.getInstance().getCourseById(courseId);
                        if (course != null) {
                            requiredCourses.add(course);
                        } else {
                            // Handle case where course is not found
                        }
                    } else {
                        // Handle the case where courseIdObj is not a string
                        System.err.println("Invalid course ID format: " + courseIdObj);
                    }
                }
            } else {
                // Handle case where requiredCoursesArray is null
                System.err.println("requiredCoursesArray is null");
            }

            int expectedGradYear = Integer.parseInt(studentObj.get(STUDENT_EXPECTED_GRAD_YEAR).toString());
            String currentStudentYear = (String) studentObj.get(STUDENT_CURRENT_STUDENT_YEAR);

            // Check if id and majorId are not null before creating a Student object
            if (id != null && majorId != null) {
                Student student = new Student(id, userName, firstName, lastName, email, uscid, notes, warnings, majorId, minor, GPA, takenCourses, currentCourses, requiredCourses, expectedGradYear, currentStudentYear, password);
                students.add(student);
            } else {
                // Handle case where id or majorId is null
                System.err.println("Invalid student ID or major ID found in JSON object.");
            }
        }
    } catch (IOException | org.json.simple.parser.ParseException e) {
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

            UUID id = UUID.fromString((String) courseObj.get(COURSE_ID));
            String courseNumber = (String) courseObj.get(COURSE_NUMBER);
            String courseAcronym = (String) courseObj.get(COURSE_ACRONYM);
            String courseName = (String) courseObj.get(COURSE_NAME);

            Object creditHoursObj = courseObj.get(COURSE_CREDIT_HOURS);
            int creditHours = 0; // Default value for credit hours
            if (creditHoursObj != null) {
                creditHours = Integer.parseInt(creditHoursObj.toString());
            } else {
                // Handle case where creditHoursObj is null
                System.err.println("Credit hours is null for course: " + courseObj.get(COURSE_ID));
            }

            boolean fall = (boolean) courseObj.get(COURSE_FALL);
            boolean spring = (boolean) courseObj.get(COURSE_SPRING);

            JSONArray preReqArray = (JSONArray) courseObj.get(COURSE_PREREQUISITES);
            ArrayList<PreReq> preReqs = new ArrayList<>();
            for (Object preReqObj : preReqArray) {
                JSONObject preReqJsonObj = (JSONObject) preReqObj;
                String CourseName = (String) preReqJsonObj.get(COURSE_NAME);
                String CourseNumber = (String) preReqJsonObj.get(COURSE_NUMBER);
                String CourseAcronym = (String) preReqJsonObj.get(COURSE_ACRONYM);
                JSONArray gradesArray = (JSONArray) preReqJsonObj.get(COURSE_GRADES);
                ArrayList<Grades> grades = new ArrayList<>();
                for (Object gradeObj : gradesArray) {
                    String gradeStr = (String) gradeObj;
                    grades.add(Grades.valueOf(gradeStr));
                }
                preReqs.add(new PreReq(CourseName, CourseNumber, CourseAcronym, grades));
            }

            JSONArray coReqArray = (JSONArray) courseObj.get(COURSE_COREQUISITES);
            ArrayList<CoReq> coReqs = new ArrayList<>();
            if (coReqArray != null) {
                for (Object coReqObj : coReqArray) {
                    JSONObject coReqJsonObj = (JSONObject) coReqObj;
                    String CourseName = (String) coReqJsonObj.get(COURSE_NAME);
                    String CourseNumber = (String) coReqJsonObj.get(COURSE_NUMBER);
                    String CourseAcronym = (String) coReqJsonObj.get(COURSE_ACRONYM);
                    coReqs.add(new CoReq(CourseName, CourseNumber, CourseAcronym));
                }
            } else {
                // Handle case where coReqArray is null
                System.err.println("corequisites array is null for course: " + courseObj.get(COURSE_ID));
            }

            JSONArray gradesArray = (JSONArray) courseObj.get(COURSE_GRADES);
            ArrayList<Grades> grades = new ArrayList<>();
            for (Object gradeObj : gradesArray) {
                String gradeStr = (String) gradeObj;
                grades.add(Grades.valueOf(gradeStr));
            }

            JSONArray reqTypeArray = (JSONArray) courseObj.get(COURSE_REQUIREMENT_TYPE);
            ArrayList<RequirementType> reqTypes = new ArrayList<>();
            for (Object reqTypeObj : reqTypeArray) {
                String reqTypeStr = (String) reqTypeObj;
                reqTypes.add(RequirementType.valueOf(reqTypeStr));
            }

            Course course = new Course(id, courseName, courseNumber, creditHours, fall, spring, courseAcronym);
            course.setPreReqs(preReqs);
            course.setCoReqs(coReqs);
            course.setGrades(grades);
            course.setRequirementTypes(reqTypes);

            courses.add(course);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return courses;
}


public static ArrayList<Major> getMajors() {
    ArrayList<Major> majors = new ArrayList<>();

    try {
        FileReader reader = new FileReader(MAJOR_FILE_NAME);
        JSONParser parser = new JSONParser();
        JSONArray majorArray = (JSONArray) parser.parse(reader);

        for (Object obj : majorArray) {
            JSONObject majorObj = (JSONObject) obj;

            String name = (String) majorObj.get(MAJOR_NAME);
            String majorIdStr = (String) majorObj.get(MAJOR_ID);
            UUID majorId = UUID.fromString(majorIdStr);

            JSONArray coursesArray = (JSONArray) majorObj.get(MAJOR_COURSES);
            ArrayList<UUID> courses = new ArrayList<>();
            for (Object courseIdObj : coursesArray) {
                String courseIdStr = (String) courseIdObj;
                UUID courseId = UUID.fromString(courseIdStr);
                courses.add(courseId);
            }

            Major major = new Major(name, majorId, courses);
            majors.add(major);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return majors;
}

}


