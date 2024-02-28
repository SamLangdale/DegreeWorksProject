
import java.util.*;
public class Advisor extends User {
    protected ArrayList<Student> AssignedStudents;

public Advisor(User user) {
    super(user.firstName, user.lastName, user.userName,
     user.Email, user.Password, user.USCID, user.USCID);
     AssignedStudents = new ArrayList<Student>();


}
public boolean addNotes(Student student) {
    //todo   
    return //whatever
}
public boolean Search(String LastName, 
String FirstName, int StudentID) {
    //todo
    return //whatever

}
public boolean removenote(Student Student){
    //todo
    return // whatever
}
public boolean editNote(Student Student) {
    //todo
    return //whatever
}
public boolean selectStudent(Student student) {
    //todo
    return // whatever
}
public boolean viewWarnings(Student student) {
    //todo
    return //whatever
}





    
}
