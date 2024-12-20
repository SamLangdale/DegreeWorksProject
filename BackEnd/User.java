package BackEnd;
import java.util.UUID;

public abstract class User {
   protected UUID id;
   protected String userName;
   protected String firstName;
   protected String lastName;
   protected String email;
   protected String uscid;
   protected String password; 

   public User(String userName, String firstName, String lastName, String email, String uscid, String password) {
      this.id = UUID.randomUUID();
      this.userName = userName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.uscid = uscid;
      this.password = password; 
   }  
   public User(UUID id, String userName, String firstName, String lastName, String email, String uscid, String password) {
      this.id = id;
      this.userName = userName;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.uscid = uscid;
      this.password = password; 
   } 
   public UUID getId() {
      return id;
   }
   public String getUserName() {
      return userName;
  }

  public String getFirstName() {
      return firstName;
  }

  public void setFirstName(String firstName) {
      this.firstName = firstName;
  }

  public String getLastName() {
      return lastName;
  }

  public void setLastName(String lastName) {
      this.lastName = lastName;
  }

  public String getEmail() {
      return email;
  }

  public void setEmail(String email) {
      this.email = email;
  }

  public String getUscid() {
      return uscid;
  }

  public void setUscid(String uscid) {
      this.uscid = uscid;
  }
  public String getPassword() {
      return password;
  }

  public void setPassword(String password) {
      this.password = password;
  }
}


