package BackEnd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void setUp() {
        // Create a new student instance for each test
        student = createTestStudent();
    }

    @AfterEach
    public void tearDown() {
        // Clean up any resources if needed
    }

    @Test
    public void testAddNote() {
        // Test adding a note to the student
        int initialNotesSize = student.getNotes().size();
        student.addNote(new Note("Test Note", "2024-03-22", "This is a test note."));
        assertEquals(initialNotesSize + 1, student.getNotes().size());
    }

    @Test
    public void testRemoveNote() {
        // Test removing a note from the student
        Note noteToRemove = student.getNotes().get(0);
        student.removeNote(noteToRemove);
        assertFalse(student.getNotes().contains(noteToRemove));
    }

    // Add more test methods for other functionalities

    private Student createTestStudent() {
        return new Student(UUID.randomUUID(), "testStudent", "John", "Doe", "john@example.com", "123456789",
                new ArrayList<Note>(), new ArrayList<Warning>(), UUID.randomUUID(), "Computer Science", 3.5,
                new ArrayList<Course>(), new ArrayList<Course>(), new ArrayList<Course>(), 2022, "Sophomore", "password", null);
    }
}
