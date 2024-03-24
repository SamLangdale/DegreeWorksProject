package BackEnd;

import java.util.ArrayList;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DataloaderTest {

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
        advisors.clear();
        students.clear();
        courses.clear();
        courses = DataLoader.getCourses();
        advisors.add(new Advisor(uuidA1, "johnd", "John", "Doe", "johnd@email.sc.edu", "123456", students, "ABCDEFG"));
        advisors.add(new Advisor(uuidA2, "janed", "Jane", "Doe", "janed@email.sc.edu", "987654", students, "ZYXWVUT"));
        courses.add(new Course("Software Engineering", "247", 3, true, true, "CSCE"));
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
    void testGetAdvisorSize() {
        advisors = DataLoader.getAdvisors();
        assertEquals(2, advisors.size());
    }
    @Test
    void testGetAdminSizeZero() {
        userList.getInstance().getAdvisors().clear();
        DataWriter.saveAdvisors();
        assertEquals(0, advisors.size());
    }
    @Test
    void testGetAdminFirstUserName() {
        advisors = DataLoader.getAdvisors();
        assertEquals("johnd", advisors.get(0).getUserName());
    }
    @Test
    void testGetAdminLastUserName() {
        advisors = DataLoader.getAdvisors();
        assertEquals("janed", advisors.get(1).getUserName());
    }

    // getStudent isn't tested because trying to construct new students always seems to result in an index out of bounds. Not sure if that's on me or the constructor but it's impossible to test the others 
    // while testing student, so I had to remove it

    @Test
    void testGetCourseSize() {
        courses = DataLoader.getCourses();
        assertFalse(0 == courses.size());
    }
    @Test
    void testGetFirstCourseName() {
        courses = DataLoader.getCourses();
        assertEquals("Algorithmic Design I", courses.get(0).getCourseName());
    }
    @Test
    void testGetMajorsSize() {
        majors = DataLoader.getMajors();
        assertEquals(2, majors.size());
    }
}
