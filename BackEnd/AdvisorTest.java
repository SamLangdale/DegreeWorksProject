package BackEnd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class AdvisorTest {
    private Advisor advisor;

    @BeforeEach
    public void setUp() {
        // Create a new advisor instance for each test
        advisor = createTestAdvisor();
    }

    @AfterEach
    public void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    public void testAddAssignedStudent() {
        // Test adding an assigned student to the advisor
        Student student = new Student(UUID.randomUUID(), "student1", "John", "Doe", "john@example.com", "123456789",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Computer Science", 3.5,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2022, "Sophomore", "password", null);
        advisor.addAssignedStudent(student);
        assertTrue(advisor.getAssignedStudents().contains(student));
    }

    @Test
    public void testRemoveAssignedStudent() {
        // Test removing an assigned student from the advisor
        Student student = advisor.getAssignedStudents().get(0);
        advisor.removeAssignedStudent(student);
        assertFalse(advisor.getAssignedStudents().contains(student));
    }

    // Add more test methods for other functionalities

    private Advisor createTestAdvisor() {
        return new Advisor(UUID.randomUUID(), "testAdvisor", "Michael", "Johnson", "michael@example.com", "111222333",
                new ArrayList<Student>(), "password");
    }
}