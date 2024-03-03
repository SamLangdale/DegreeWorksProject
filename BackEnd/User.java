package BackEnd;
import java.util.*;

public abstract class User {
    protected String Password;
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String Email;
    protected String USCID;
    protected UUID UUID;
    
    // User that aready has a UUID
    public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID, UUID UUID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.userName = userName;
        this.Email = Email;
        this.USCID = USCID;
        this.UUID = UUID;
     }
     // Brand new user without a UUID
     public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID) {
      this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.userName = userName;
        this.Email = Email;
        this.USCID = USCID;
        this.UUID = UUID.randomUUID();
     }
     public String getFirstName() {
      return this.firstName;

     }
     public String getLastName() {
      return this.lastName;
     }
     public String getPassword() {
      return this.Password;
     }
     public String getUsername() {
      return this.userName;
     }
     public String getUSCID() {
      return this.USCID;
     }
     public UUID getUUID() {
      return this.UUID;
     }
     public void setFirstName(String FirstName) {
      this.firstName = FirstName;
     }
     public void setLastName(String lastName) {
      this.lastName = lastName;
     }
     public void setPassword(String Password) {
      this.Password = Password;
     }
     public void setUsername(String userName) {
      this.userName = userName;
     }
     public void setUSCID(String USCID) {
      this.USCID = USCID;
     }
     public void setUUID(UUID UUID) {
      this.UUID = UUID;
     }
}
