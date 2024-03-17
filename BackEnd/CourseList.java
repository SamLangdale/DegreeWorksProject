package BackEnd;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private ArrayList<Course> courses;
    private static CourseList courseList;

    private CourseList() {
        courses = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }
    
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Course getCourseById(UUID courseId) {
        for(Course course : courses) {
            if(course.getId().equals(courseId)) {
                return course;
            }

        }
        return null;
    }
  
    public boolean addCourse(Course course) {
        // Check if the course already exists
        if (courseExists(course.getId())) {
            return false; // Course already exists
        }
        // Add the course and return true
        courses.add(course);
        return true;
    }
        
    public void saveCourses() {
        DataWriter.saveCourses();
    }

    public boolean courseExists(UUID courseId) {
        for (Course course : courses) {
            if (course.getId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }


}
