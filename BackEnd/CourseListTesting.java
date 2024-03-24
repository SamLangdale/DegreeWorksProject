package BackEnd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

public class CourseListTesting {
    private CourseList courses;
    @BeforeEach 
    public void setUp(){
        courses=CourseList.getInstance();
        //Add test data
        addCourseTestData();
    }
    @AfterEach
    public void tearDown(){
        //clean up
    }
    @Test
    public void testAddCourse(){
        //test adding a new course
        Course course=new Course("testname","testnumber", 1, true, false, "TestACRYNM");
        assertTrue(courses.addCourse(course));
}
    @Test
    public void testAddDuplicateCourses(){
        Course course=new Course("testname","testnumber", 1, true, false, "TestACRYNM");
        courses.addCourse(course);//add once
        assertFalse(courses.addCourse(course)); //try twice

    }
    //See if you can add more test?
    private void addCourseTestData(){
        //add test courses
        courses.addCourse(new Course("Intro to comp sci", "123456", 2, true, false,"Csce 145" ));
        courses.addCourse(new Course("Software Enginerring", "54321", 1, false, true, "Csce 247"));
    }
}

