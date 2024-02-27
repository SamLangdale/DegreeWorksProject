import java.util.*;

public class Student extends User{
    protected ArrayList<notes> note;
    
    public Student(User user) {
        super(user.firstName, user.lastName, user.userName,
         user.Email, user.Password, user.USCID, user.USCID);
         note = new ArrayList<notes>();
    }
    
}
