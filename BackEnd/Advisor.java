package BackEnd; 

import java.util.*;
public class Advisor extends User {
    protected ArrayList<Student> AssignedStudents;

public Advisor(String firstName, String lastName, String userName, String email, String password, String uscid, UUID id ) {
    super(firstName,lastName,userName, email,password, uscid, id);
     AssignedStudents = new ArrayList<Student>();

}
// public Advisor(UUID id, String userName, String firstName, String lastName, String email, String uscid, ArrayList<String> assignedStudentIds) {
//     super(firstName, lastName, userName, email, null, uscid, id);
//     this.AssignedStudents = new ArrayList<>();
//     // You might need to populate AssignedStudents based on assignedStudentIds here
// }

public Advisor(UUID id, String userName, String firstName, String lastName, String email, String uscid, ArrayList<String> assignedStudentIds) {
    this.assignedStudentIds = assignedStudents;
    super(userName, password, email, uscid, uuid);
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





    
}
