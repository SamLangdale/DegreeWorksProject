package BackEnd;

import java.util.ArrayList;
import java.util.UUID;

public class CourseList {
    private ArrayList<Course> coures;
    private static CourseList courseList;

    private CourseList() {
        coures = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courseList == null) {
            courseList = new CourseList();
        }
        return courseList;
    }

    public void removeCourse(Course course) {
        coures.remove(course);
    }
    
    public ArrayList<Course> getCoures() {
        return coures;
    }

    public Course getCourseById(UUID courseId) {
        for(Course course : coures) {
            if(course.getId().equals(courseId)) {
                return course;
            }

        }
        return null;
    }
    //public addCoure
    //saveCoureses
    

}
