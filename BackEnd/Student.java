package BackEnd;
import java.util.ArrayList;
import java.util.UUID;

public class Student extends User {
    private ArrayList<Note> notes;
    private ArrayList<Warning> warnings;
    private UUID studentProfileId;

    public Student(UUID id, String userName, String firstName,String lastName, String email, String uscid,
    ArrayList<Note> notes, ArrayList<Warning> warnings, UUID studentProfileId) {
        super(id, userName, firstName, lastName, email, uscid);
        this.notes = notes;
        this.warnings = warnings;
        this.studentProfileId = studentProfileId;
    }
    public ArrayList<Note> getNotes() {
        return notes;
    }

    public ArrayList<Warning> getWarnings() {
        return warnings;
    }

    public UUID getStudentProfileId() {
        return studentProfileId;
    }
    
}


