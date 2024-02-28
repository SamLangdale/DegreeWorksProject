package BackEnd;
import java.util.*;
public class UserList {
    private ArrayList<User> users;
    private String JSONFile;
    private UserList userlist;
    
    private UserList() {
        //todo
    }
    public UserList getInstance() {
        if(this.userlist == null) {
            userlist = new UserList();
            return this.userlist;
        }
        else 
            return this.userlist;

    }
    public void addUser(String firstName, String lastName,
     String USCID) {
        //todo
     }
     public void removeUser(User user) {
        //todo
     }
     public User getUser(User user) {
        //todo
     }
     


    
}
