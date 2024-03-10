package BackEnd;


import java.util.Scanner;

public class schedulingUI {
    private static final String WELCOME_MESSAGE = "Welcome to our Scheduling System";
    private static final String[] mainMenuOptions = {"Login", "Exit"};
    private Scanner scanner;

    private facade schedulerFacade; // Change facade to facade

public schedulingUI() {
    scanner = new Scanner(System.in);
    schedulerFacade = new facade(); // Change facade to facade
}


    public void run() {
        System.out.println(WELCOME_MESSAGE);

        // Loop as long as we want to keep interacting with the scheduling system
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

            // For now, we only implement login functionality
            switch (userCommand) {
                case 0:
                    login();
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

    // Get the user's command number; if it's not valid, return -1
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
    
        if (schedulerFacade.login(username)) { // Change facade to schedulerFacade
            System.out.println("Login successful!");
            // Here you can proceed with the user's interaction after login
        } else {
            System.out.println("Login failed. Invalid username.");
        }
    }
    

    public static void main(String[] args) {
        schedulingUI schedulerUI = new schedulingUI();
        schedulerUI.run();
    }
}

