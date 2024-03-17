package BackEnd;

import java.util.Scanner;

public class schedulingUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Scheduling System";
    private static final String[] mainMenuOptions = {"Login", "Create Account", "Exit"};
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

            // For now, we only implement login and create account functionality
            switch (userCommand) {
                case 0:
                    login();
                    break;
                case 1:
                    createAccount();
                    break;
            }
        }
    }

    private void displayMainMenu() {
        System.out.println("\n************ Main Menu *************");
        for (int i = 0; i < mainMenuOptions.length; i++) {
            System.out.println((i + 1) + ". " + mainMenuOptions[i]);
        }
        System.out.println("\n");
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
    private void login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
    
        if (schedulerFacade.login(username, password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
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
    
    public static void main(String[] args) {
        schedulingUI schedulerUI = new schedulingUI();
        schedulerUI.run();
    }
}
