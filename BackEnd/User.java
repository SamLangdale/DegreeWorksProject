import java.util.UUID;
public abstract class User {
    protected String Password;
    protected String firstName;
    protected String lastName;
    protected String userName;
    protected String Email;
    protected String USCID;
    protected UUID id;
    protected UUID UUID;
    
    // User that aready has a UUID
    public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID) {
     String Email, String password, String USCID, UUID UUID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.userName = userName;
        this.Email = Email;
        this.USCID = USCID;
        this.id = UUID.randomUUID();

     }
     public User(String firstName, String lastName, String userName,
     String Email, String password, String USCID, UUID id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Password = password;
        this.userName = userName;
        this.Email = Email;
        this.USCID = USCID;
        this.id = id;

     }
     public UUID getId() {
      return id;
     }
   
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

}
