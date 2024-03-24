package BackEnd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class MajorListTesting {
    private MajorList majors;

    @BeforeEach
    public void setUp(){
        majors=MajorList.getInstance();
        //Add Test data
        addMajorTestData();
    }
    @AfterEach
    public void tearDown(){
        //Clean up
    }

    @Test
    public void testAddMajor(){
        //Test Add Major
        Major major=new Major("testmajor", UUID.randomUUID(), new ArrayList<UUID>());
        assertTrue(majors.addMajor("major", null));
    }
    @Test 
    public void testAddDuplicateMajor(){
        Major major=new Major("testmajor", UUID.randomUUID(), new ArrayList<UUID>());
        majors.addMajor(null, null);
        assertFalse(majors.addMajor(null, null));
    }

    private void addMajorTestData(){
        majors.addMajor("Computer Science", new ArrayList<UUID>());
        majors.addMajor("Computer Info Systems", new ArrayList<UUID>());
    }


    
}
