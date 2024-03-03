package BackEnd;
import java.util.*;

public class User {
    protected String password;
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String email;
    protected String uscid;
    protected UUID id;
    
    // User that aready has a UUID
    public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID, UUID id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.email = Email;
        this.uscid = USCID;
        this.id = id;
     }
     // Brand new user without a UUID
     public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID) {
      this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userName = userName;
        this.email = Email;
        this.uscid = USCID;
        this.id = UUID.randomUUID();
     }
   public String getFirstName() {
      return this.firstName;

     }
     public String getLastName() {
      return this.lastName;
     }
     public String getPassword() {
      return this.password;
     }
     public String getUsername() {
      return this.userName;
     }
     public String getUSCID() {
      return this.uscid;
     }
     public UUID getUUID() {
      return this.id;
     }
     public void setFirstName(String FirstName) {
      this.firstName = FirstName;
     }
     public void setLastName(String lastName) {
      this.lastName = lastName;
     }
     public void setPassword(String Password) {
      this.password = Password;
     }
     public void setUsername(String userName) {
      this.userName = userName;
     }
     public void setUSCID(String USCID) {
      this.uscid = USCID;
     }
     public void setUUID(UUID UUID) {
      this.id = id;
     }
}
