package BackEnd;
public abstract class DataConstants {
    protected static final String ADVISOR_FILE_NAME = "Data/advsior.json";
    protected static final String ADVISOR_USERNAME = "UserName";
    protected static final String ADVISOR_USERTYPE = "Advisor";
    protected static final String ADVISOR_PASSWORD = "Password";
    protected static final String ADVISOR_FIRST_NAME = "firstName";
    protected static final String ADVISOR_LAST_NAME = "lastName";
    protected static final String ADVISOR_EMAIL = "Email";
    protected static final String ADVISOR_USCID = "USCID";
    protected static final String ADVISOR_UUID = "Advsioruuid";
    protected static final String ADVISOR_ASSIGNED_STUDENTS = "AssignedStudents";
    protected static final String ADVISOR_STUDENT_ID = "Studentid";

    //Student 
    protected static final String STUDENT_FILE_NAME = "Data/Student.json";
    protected static final String STUDENT_USERTYPE = "Student";
    protected static final String STUDENT_USERNAME = "Username";
    protected static final String STUDENT_PASSWORD = "Password";
    protected static final String STUDENT_FIRST_NAME = "firstName";
    protected static final String STUDENT_LAST_NAME = "lastName";
    protected static final String STUDENT_EMAIL = "Email";
    protected static final String STUDENT_USCID = "USCID";
    protected static final String STUDENT_ID = "Studentid"; 
    protected static final String STUDENT_NOTES = "notes";
    protected static final String STUDENT_NOTE_TITLE = "title";
    protected static final String STUDENT_NOTE_DATE = "date";
    protected static final String STUDENT_NOTE_CONTENT = "content";
    protected static final String STUDENT_PROFILE_ID = "studentProfileid";
    protected static final String STUDENT_WARNINGS = "warnings";

    //Courses
    protected static final String COURSE_FILE_NAME = "Data/courses.json";
    protected static final String COURESES_COURESID = "Couresid";
    protected static final String COURESES_COURSENUMBER = "CourseNumber";
    protected static final String COURESES_COURSEACRONYM = "CourseAcronym";
    protected static final String COURESES_COURSENAME = "CourseName";
    protected static final String COURESES_COURSEMAJORS = "CourseMajors";
    protected static final String COURESES_CREDITHOURS = "CreditHours";
    protected static final String COURESES_GRADES = "Grades";
    protected static final String COURESES_FALL = "fall";
    protected static final String COURESES_SPRING = "spring";
    protected static final String COURESES_PREREQ = "PreReq";
    protected static final String COURESES_COREQ = "CoReq";
    protected static final String COURESES_REQUIREMENTTYPE = "RequirementType";

    //Majors
    protected static final String MAJOR_FILE_NAME = "Data/Majors.json";
    protected static final String MAJORS_NAME = "Name";
    protected static final String MAJORS_MAJORID = "Majorid";
    protected static final String MAJORS_COURSES = "courses";
    
    //StudentProfile
    protected static final String STUDENTPROFILE_FILE_NAME = "Data/StudentProfile.json";
    protected static final String STUDENTPROFILE_ID = "studentprofileid";
    protected static final String STUDENTPROFILE_MAJOR_ID = "Majorid";
    protected static final String STUDENTPROFILE_MINOR = "minor";
    protected static final String STUDENTPROFILE_GPA = "GPA";
    protected static final String STUDENTPROFILE_TAKENCOURES = "takenCoures";
    protected static final String STUDENTPROFILE_CURRENTCOURES = "CurrentCoures";
    protected static final String STUDENTPROFILE_REQUIREDCOURES = "RequiredCoures";
    protected static final String STUDENTPROFILE_EXPECTEDGRADYEAR = "ExpectedGradYear";
    protected static final String STUDENTPROFILE_CURRENTSTUDENTYEAR = "currentStudentYear";
 

}
