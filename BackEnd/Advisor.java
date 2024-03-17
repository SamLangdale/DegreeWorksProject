package BackEnd;

import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<Student> assignedStudents;

    public Advisor(UUID id, String userName, String firstName, String lastName, String email, String uscid, ArrayList<Student> assignedStudents, String password) {
        super(id, userName, firstName, lastName, email, uscid, password);
        this.assignedStudents = assignedStudents;
    }

    public void addAssignedStudent(Student student) {
        assignedStudents.add(student);
    }

    public void removeAssignedStudent(Student student) {
        assignedStudents.remove(student);
    }

    public ArrayList<Student> getAssignedStudents() {
        return assignedStudents;
    }

    // Add note to a student
    public void addNote(Student student) {
        //todo: Add note functionality
    }

    // Search for a student by last name, first name, and student ID
    public boolean search(String lastName, String firstName, int studentID) {
        //todo: Search functionality
        return false; // Placeholder return
    }

    // Remove a note for a student
    public void removeNote(Student student) {
        //todo: Remove note functionality
    }

    // Edit a note for a student
    public void editNote(Student student) {
        //todo: Edit note functionality
    }

    // Select a student
    public boolean selectStudent(Student student) {
        //todo: Select student functionality
        return false; // Placeholder return
    }

    // View warnings for a student
    public void viewWarnings(Student student) {
        //todo: View warnings functionality
    }
}
