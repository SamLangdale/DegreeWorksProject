package BackEnd;

import java.util.ArrayList;

public class CourseList {
    private ArrayList<Course> coures;
    private static CourseList courseList;

    private CourseList() {
        coures = new ArrayList<>();
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

}
