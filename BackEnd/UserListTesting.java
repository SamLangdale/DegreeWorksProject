package BackEnd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class UserListTesting {
    private UserList users;

    @BeforeEach
    public void setUp() {
        users = UserList.getInstance();
        // Add test data
        addUserTestData();
    }

    @AfterEach
    public void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    public void testGetStudent() {
        // Test getting an existing student
        assertNotNull(users.getStudent("student1"));
    }

    @Test
    public void testGetNonExistingStudent() {
        // Test getting a non-existing student
        assertNull(users.getStudent("nonExistingStudent"));
    }

    @Test
    public void testGetAdvisor() {
        // Test getting an existing advisor
        assertNotNull(users.getAdvisor("advisor1"));
    }

    @Test
    public void testGetNonExistingAdvisor() {
        // Test getting a non-existing advisor
        assertNull(users.getAdvisor("nonExistingAdvisor"));
    }

    @Test
    public void testAddStudentWithNull() {
        // Test adding a student with null values
        assertFalse(users.addStudent(null));
    }

    @Test
    public void testAddAdvisorWithNull() {
        // Test adding an advisor with null values
        assertFalse(users.addAdvisor(null));
    }

    @Test
    public void testHaveStudent() {
        // Test checking if an existing student exists
        assertTrue(users.haveStudent("student1"));
    }

    @Test
    public void testHaveNonExistingStudent() {
        // Test checking if a non-existing student exists
        assertFalse(users.haveStudent("nonExistingStudent"));
    }

    @Test
    public void testHaveAdvisor() {
        // Test checking if an existing advisor exists
        assertTrue(users.haveAdvisor("advisor1"));
    }

    @Test
    public void testHaveNonExistingAdvisor() {
        // Test checking if a non-existing advisor exists
        assertFalse(users.haveAdvisor("nonExistingAdvisor"));
    }

    @Test
    public void testAddStudent() {
        // Test adding a new student
        Student student = new Student(UUID.randomUUID(), "testStudent", "Test", "Student", "teststudent@example.com", "123456789",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Computer Science", 3.8,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2023, "Junior", "password", null);
        assertTrue(users.addStudent(student));
    }

    @Test
    public void testAddDuplicateStudent() {
        // Test adding a duplicate student
        Student student = new Student(UUID.randomUUID(), "testStudent", "Test", "Student", "teststudent@example.com", "123456789",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Computer Science", 3.8,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2023, "Junior", "password", null);
        users.addStudent(student); // Add once
        assertFalse(users.addStudent(student)); // Try adding again
    }

    @Test
    public void testAddAdvisor() {
        // Test adding a new advisor
        Advisor advisor = new Advisor(UUID.randomUUID(), "testAdvisor", "Test", "Advisor", "testadvisor@example.com", "987654321",
                new ArrayList<Student>(), "password");
        assertTrue(users.addAdvisor(advisor));
    }

    @Test
    public void testAddDuplicateAdvisor() {
        // Test adding a duplicate advisor
        Advisor advisor = new Advisor(UUID.randomUUID(), "testAdvisor", "Test", "Advisor", "testadvisor@example.com", "987654321",
                new ArrayList<Student>(), "password");
        users.addAdvisor(advisor); // Add once
        assertFalse(users.addAdvisor(advisor)); // Try adding again
    }

    private void addUserTestData() {
        // Adding test students
        users.addStudent(new Student(UUID.randomUUID(), "student1", "John", "Doe", "john@example.com", "123456789",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Computer Science", 3.5,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2022, "Sophomore", "password", null));
        users.addStudent(new Student(UUID.randomUUID(), "student2", "Alice", "Smith", "alice@example.com", "987654321",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Engineering", 3.2,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2023, "Junior", "password", null));

        // Adding test advisors
        Advisor advisor1 = new Advisor(UUID.randomUUID(), "advisor1", "Michael", "Johnson", "michael@example.com", "111222333",
                new ArrayList<Student>(), "password");
        advisor1.addAssignedStudent(users.getStudent("student1"));
        Advisor advisor2 = new Advisor(UUID.randomUUID(), "advisor2", "Emily", "Brown", "emily@example.com", "444555666",
                new ArrayList<Student>(), "password");
        advisor2.addAssignedStudent(users.getStudent("student2"));
        users.addAdvisor(advisor1);
        users.addAdvisor(advisor2);
    }
}