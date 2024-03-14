package BackEnd;
import java.util.*;

import javax.sound.sampled.UnsupportedAudioFileException;

public class Major {
    private String name;
    private ArrayList<Course> requirements;
    private UUID UUID;
    private String JsonFile;

    public Major(String name, ArrayList<Course> requirements, UUID UUID, String JsonFile) {
        this.name = name;
        this.requirements = requirements;
        this.UUID = UUID;
        this.JsonFile = JsonFile;
    }
    
}
