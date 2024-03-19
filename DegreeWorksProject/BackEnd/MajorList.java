package BackEnd;
import java.util.*;

public class MajorList {
    private ArrayList<Major> majors;
    private static  MajorList majorList;

    private MajorList() {
        majors = DataLoader.getMajors();
    }
    public static MajorList getInstance() {
        if(majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }
    
    public boolean addMajor(String name, ArrayList<UUID> courses) {
        UUID majorId = UUID.randomUUID();
        Major major = new Major(name, majorId, courses);
        return majors.add(major);
    }

    public Major getMajor(UUID majorId) {
        for (Major major : majors) {
            if (major.getMajorId().equals(majorId)) {
                return major;
            }
        }
        return null;
    }
    public ArrayList<Major> getMajors() {
        return majors;
    }
}
