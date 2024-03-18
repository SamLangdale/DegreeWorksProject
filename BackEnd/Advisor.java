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
      public void addNoteToStudent(Student student, String title, String date, String content) {
        student.addNote(new Note(title, date, content));
    }

    // Search for a student by last name, first name, and student ID
    public Student searchStudent(String lastName, String firstName, String studentID) {
        for (Student student : assignedStudents) {
            if (student.getLastName().equalsIgnoreCase(lastName) && student.getFirstName().equalsIgnoreCase(firstName) && student.getUSCID().equalsIgnoreCase(studentID)) {
                return student;
            }
        }
        return null;
    }

    // View warnings for a student
    public void viewWarningsForStudent(Student student) {
        student.displayWarnings();
    }


}
