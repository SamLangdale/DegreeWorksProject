package BackEnd;

import java.util.Scanner;

public class schedulingUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Scheduling System";
    private static final String[] mainMenuOptions = {"Login", "Create Account", "Logout", "Exit"};
    private static final String[] StudentMenu = {"view Classes","generate schedule","choose applicaiton area"};
    private Scanner scanner;
    private facade schedulerFacade; 

    public schedulingUI() {
        scanner = new Scanner(System.in);
        schedulerFacade = new facade(); 
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        // Loop's as long as we want to keep interacting with the scheduling system
        while (true) {
            if(schedulerFacade.getCurrentUser() == null) {
                System.out.println("no user logged in");
            }
            else {
                System.out.println("Currently you are: "+schedulerFacade.getCurrentUser().firstName);
            }
            displayMainMenu();
            int userCommand = getUserCommand(mainMenuOptions.length);

            if (userCommand == -1) {
                System.out.println("Not a valid command");
                continue;
            }
        
            // If the user chooses the exit option, break out of the loop and end the program
            if (userCommand == mainMenuOptions.length - 1) {
                System.out.println("Goodbye!");
                break;
            }
        
            // For now, we only implement login, create account, and logout functionality
            switch (userCommand) {
                case 0:
                    login();
                    break;
                case 1:
                    createAccount();
                    break;
                case 2:
                    logout();
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        if(schedulerFacade.getCurrentUser() == null) {
            for (int i = 0; i < mainMenuOptions.length; i++) {
                System.out.println((i + 1) + ". " + mainMenuOptions[i]);
            }
            System.out.println("\n");
        }
        else if(schedulerFacade.getCurrentUser() instanceof Student) {// something to differ student from advisor
            for (int i = 0; i < StudentMenu.length; i++) {
                System.out.println((i + 1) + ". " + StudentMenu[i]);
            }
            System.out.println("\n");
        }
    }

    // Get's the user's command number; if it's not valid, return -1
    private int getUserCommand(int numCommands) {
        System.out.print("What would you like to do?: ");

        String input = scanner.nextLine();
        int command;
        try {
            command = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            return -1;
        }

        if (command >= 0 && command <= numCommands - 1) return command;

        return -1;
    }
    private User login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        if(schedulerFacade.login(username, password) == null){
            System.out.print("Login Failed");
            return null;
        }
        else {
            System.out.println("login Success");
            return schedulerFacade.login(username, password);

        }
        
        
    }
    private void createAccount() {
        System.out.print("Enter your username: ");
        String userName = scanner.nextLine();
        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your USC ID: ");
        String uscid = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
    
        // Prompt the user to choose the account type
        System.out.println("Choose the type of account to create:");
        System.out.println("1. Student");
        System.out.println("2. Advisor");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
    
        UserType userType;
        switch (choice) {
            case 1:
                userType = UserType.STUDENT;
                System.out.println();
                break;
            case 2:
                userType = UserType.ADVISOR;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }
    
        // Call the createAccount method of facade
        boolean accountCreated = schedulerFacade.createAccount(userName, firstName, lastName, email, uscid, userType, password);
    
        if (accountCreated) {
            System.out.println("Account created successfully!");

        } else {
            System.out.println("Failed to create account. Please try again.");
        }
    }
    private void logout() {
        schedulerFacade.logout();
        System.out.println("Logout successful!");
    }

    
    public static void main(String[] args) {
        schedulingUI schedulerUI = new schedulingUI();
        schedulerUI.run();
    }
     public void DisplayCourses(Student Student) {
         System.out.println("Taken Course :");
         schedulerFacade.viewCoursesTaken();
         System.out.println("courses to be taken: ");
         schedulerFacade.viewCoursesToTake();
         System.out.println("search for REQ type: Major Req");
         schedulerFacade.courseSearchReq(RequirementType.MR);

     }
    // public void StudentDisplayCoursesTests(Student Student) {
    //     System.out.println("Taken Course :");
    //     schedulerFacade.viewCoursesTaken();
    //     System.out.println("courses to be taken: ");
    //     schedulerFacade.viewCoursesToTake();
    //     System.out.println("Courses that fulfill Major Requiment:");
    //     schedulerFacade.courseSearchReq(RequirementType.MR);

    // }
    // public void AdvisorTest(Advisor advisor) {
    //     System.out.println("looking up advisee to assign to self . . ");
    //     schedulerFacade.addadvise("1234");
    //     System.out.println("advisor assigned to :"+schedulerFacade.getCurrentAdvisor().getAssignedStudents().get(0).firstName);// test


    // }
}
