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
}

    // public boolean addNotes(Student student) {
//     //todo   
//     return //whatever
// }
// public boolean Search(String LastName, 
// String FirstName, int StudentID) {
//     //todo
//     return //whatever

// }
// public boolean removenote(Student Student){
//     //todo
//     return // whatever
// }
// public boolean editNote(Student Student) {
//     //todo
//     return //whatever
// }
// public boolean selectStudent(Student student) {
//     //todo
//     return // whatever
// }
// public boolean viewWarnings(Student student) {
//     //todo
//     return //whatever
// } 

