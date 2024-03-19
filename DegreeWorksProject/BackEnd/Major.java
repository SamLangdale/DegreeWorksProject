package BackEnd;
import java.util.*;



public class Major {
    private String name;
    private ArrayList<UUID> courses;
    private UUID MajorId;
    

    public Major(String name, UUID MajorId, ArrayList<UUID> courses) {
        this.name = name;
        this.courses = courses;
        this.MajorId = MajorId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<UUID> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<UUID> courses) {
        this.courses = courses;
    }

    public UUID getMajorId() {
        return MajorId;
    }

    public void setMajorId(UUID majorId) {
        this.MajorId = majorId;
    }
    
}
