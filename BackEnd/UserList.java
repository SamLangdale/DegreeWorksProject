package BackEnd;
import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;

    private UserList() {
        students = DataLoader.getStudents();
        advisors = DataLoader.getAdvisors();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    public boolean haveStudent(String userName) {
        for (Student student : students) {
            if (student.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public Student getStudent(String userName) {
        for (Student student : students) {
            if (student.getUserName().equals(userName)) {
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public boolean addStudent(String userName, String firstName, String lastName, String email, String uscid) {
        if (haveStudent(userName)) return false;

        students.add(new Student(userName, firstName, lastName, email, uscid));
        return true;
    }

    public boolean haveAdvisor(String userName) {
        for (Advisor advisor : advisors) {
            if (advisor.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    public Advisor getAdvisor(String userName) {
        for (Advisor advisor : advisors) {
            if (advisor.getUserName().equals(userName)) {
                return advisor;
            }
        }
        return null;
    }

    public ArrayList<Advisor> getAdvisors() {
        return advisors;
    }

    public boolean addAdvisor(String userName, String firstName, String lastName, String email, String uscid) {
        if (haveAdvisor(userName)) return false;

        advisors.add(new Advisor(userName, firstName, lastName, email, uscid));
        return true;
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }
}
