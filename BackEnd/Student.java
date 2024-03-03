package BackEnd;
import java.util.*;

public class Student extends User{
    protected ArrayList<notes> note;
    
    public Student(User user) {
        super(user.firstName, user.lastName, user.userName,
         user.Email, user.Password, user.USCID, user.UUID);
         note = new ArrayList<notes>();
    }

    public Student(java.util.UUID id, String userName, String firstName, String lastName, String email, String uscid) {
        //TODO Auto-generated constructor stub
    }
    
}
