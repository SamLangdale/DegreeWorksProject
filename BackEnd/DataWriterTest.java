package BackEnd;

import java.util.ArrayList;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataWriterTest {
    private UserList userList = UserList.getInstance();
    private CourseList courseList = CourseList.getInstance();
    private MajorList majorList = MajorList.getInstance();
    private ArrayList<Advisor> advisors = userList.getAdvisors();
    private ArrayList<Student> students = userList.getStudents();
    private ArrayList<Course> courses = courseList.getCourses();
    private ArrayList<Major> majors = majorList.getMajors();

    UUID uuidA1 = UUID.randomUUID();
    UUID uuidA2 = UUID.randomUUID();
    UUID uuidMajor = UUID.randomUUID();

    @BeforeEach
    public void setup() {
        userList.getInstance().getAdvisors().clear();
        userList.getInstance().getStudents().clear();
        courseList.getInstance().getCourses().clear();
        majorList.getInstance().getMajors().clear();
        DataWriter.saveAdvisors();
        DataWriter.saveStudents();
        DataWriter.saveCourses();
        DataWriter.saveMajors();
    }

    @AfterEach
    public void tearDown() {
        userList.getInstance().getAdvisors().clear();
        userList.getInstance().getStudents().clear();
        courseList.getInstance().getCourses().clear();
        majorList.getInstance().getMajors().clear();
        DataWriter.saveAdvisors();
        DataWriter.saveStudents();
        DataWriter.saveCourses();
        DataWriter.saveMajors();
    }

    @Test
    void testWritingZeroAdvisors() {
        advisors = DataLoader.getAdvisors();
        assertEquals(0, advisors.size());
    }
    @Test
    void testWritingOneAdvisor() {
        advisors.add(new Advisor(uuidA1, "johnd", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        DataWriter.saveAdvisors();
        assertEquals("johnd", advisors.get(0).getUserName());
    }
    @Test
    void testWritingFiveAdvisors() {
        advisors.add(new Advisor(uuidA1, "johna", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA1, "johnb", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA1, "johnc", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA1, "johnd", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA1, "johne", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        DataWriter.saveAdvisors();
        assertEquals("johne", advisors.get(4).getUserName());
    }
    @Test
    void testAddDuplicateAdvisor() {
        advisors.add(new Advisor(uuidA1, "johnd", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA1, "johnd", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        DataWriter.saveAdvisors();
        advisors = DataLoader.getAdvisors();
        assertEquals(1, advisors.size());
    }

    @Test
    void testWritingZeroCourses() {
        courses = DataLoader.getCourses();
        assertEquals(0, courses.size());
    }
    @Test
    void testWritingOneCourse() {
        courses.add(new Course("Software Engineering", "247", 3, true, true, "CSCE"));
        DataWriter.saveCourses();
        courses = DataLoader.getCourses();
        assertEquals("Software Engineering", courses.get(0).getCourseName());
    }
    @Test
    void testWritingFiveCourses() {
        courses.add(new Course("Calculus II", "247", 3, true, true, "MATH"));
        courses.add(new Course("Introduction to Computer Architecture", "212", 3, true, true, "CSCE"));
        courses.add(new Course("Introduction to the Earth", "101", 3, true, true, "GEOL"));
        courses.add(new Course("Bowling", "247", 1, true, true, "PEDU"));
        courses.add(new Course("Software Engineering", "247", 3, true, true, "CSCE"));
        DataWriter.saveCourses();
        courses = DataLoader.getCourses();
        assertEquals("Software Engineering", courses.get(4).getCourseName());
    }
    @Test
    void testAddDuplicateCourse() {
        courses.add(new Course("Software Engineering", "247", 3, true, true, "CSCE"));
        courses.add(new Course("Software Engineering", "247", 3, true, true, "CSCE"));
        DataWriter.saveCourses();
        courses = DataLoader.getCourses();
        assertEquals(1, courses.size());
    }
}
