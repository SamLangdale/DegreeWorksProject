package BackEnd;
import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;

    private UserList() {
        students = new ArrayList<>();
        advisors = new ArrayList<>();
        loadData();
    }

    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    private void loadData() {
        students.addAll(DataLoader.getStudents());
        advisors.addAll(DataLoader.getAdvisors());
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

    public boolean addStudent(Student student) {
        if (haveStudent(student.getUserName())) return false;

        students.add(student);
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

    public boolean addAdvisor(Advisor advisor) {
        if (haveAdvisor(advisor.getUserName())) return false;

        advisors.add(advisor);
        return true;
    }

    public void saveUsers() {
        DataWriter.saveStudents();
        DataWriter.saveAdvisors();
    }
    public User getUserByUsernameAndPassword(String userName, String password) {
        // Check among students
        for (Student student : students) {
            if (student.getUserName().equals(userName) && student.getPassword().equals(password)) {
                return student;
            }
        }
    
        // Check among advisors
        for (Advisor advisor : advisors) {
            if (advisor.getUserName().equals(userName) && advisor.getPassword().equals(password)) {
                return advisor;
            }
        }
    
        // No user found with the provided credentials
        return null;
    }
    
}


