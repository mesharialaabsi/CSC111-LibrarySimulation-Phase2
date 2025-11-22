/*
 Group members:
 1-Meshari Mohammed  Alqahtani(446104729)
 2-Khalid Ali  Alrumayh(446104352)
 3-Abdulaziz Fahad  AlSukayt(446100935)
 
 
 
 // GitHub Repository Link:
 
 
 */
package project;

import java.util.Scanner;  

public class LibrarySimulator {  
    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);  

        // Creating three predefined members for the system
        Member M1 = new Member(1, "Member-1", 0);  
        Member M2 = new Member(2, "Member-2", 0);  
        Member M3 = new Member(3, "Member-3", 0);  

        boolean flag = true;  // Controls the main program loop

        while (flag) {  

            // Main Menu Display
            System.out.println("\n~~~~~~~ Main Menu ~~~~~~~");
            System.out.println("1. Login as USER");
            System.out.println("2. Login as Administrator");
            System.out.println("3. Exit ");
            System.out.print("Enter your choice: ");
            int Mchoice = input.nextInt();
            input.nextLine();  // Clear scanner buffer

            // User Login Path
            if (Mchoice == 1) {

                System.out.println("\n~~~~~~~ Select User Account ~~~~~~~");
                System.out.println("1. Login as " + M1.getName() + " (ID: " + M1.getId() + ")");
                System.out.println("2. Login as " + M2.getName() + " (ID: " + M2.getId() + ")");
                System.out.println("3. Login as " + M3.getName() + " (ID: " + M3.getId() + ")");
                System.out.println("4. Back to Main Menu");
                System.out.print("Enter your choice: ");

                int choice = input.nextInt();
                input.nextLine();  // Clear scanner buffer

                // If user selects "Back", return to main menu
                if (choice == 4) continue;

                // Determine which user is logging in
                Member current = null;  // Used to store the selected member

                if (choice == 1) current = M1;
                else if (choice == 2) current = M2;
                else if (choice == 3) current = M3;
                else {
                    System.out.println("Invalid choice! please try again.");
                    continue;  // Restart user selection
                }

                // User Menu Loop
                boolean inUserMenu  = true;  
                while (inUserMenu ) {  
                    
                    // Display user menu with options
                    System.out.println("\nWelcome, " + current.getName() + "!");  
                    System.out.println("\n~~~~~~~ User Menu (" + current.getName() + ") ~~~~~~~");
                    System.out.println("1. View Borrowed Books Count");  
                    System.out.println("2. Borrow Book");  
                    System.out.println("3. Return Book");  
                    System.out.println("4. View Session Summary");  
                    System.out.println("5. Exit to Main Menu");  
                    System.out.print("Choose an option: ");  

                    int Uchoice = input.nextInt();  
                    input.nextLine();  // Clear scanner buffer

                    // Handle the selected user option
                    switch (Uchoice) {  
                        case 1:  
                            current.viewBorrowedCount();  // Show current borrowed count
                            break;  

                        case 2:  
                            current.borrowOne();  // Attempt to borrow a book
                            break;  

                        case 3:  
                            current.returnOne();  // Attempt to return a book
                            break;  

                        case 4:  
                            current.displayStatistics();  // Show session statistics
                            break;  

                        case 5:  
                            System.out.println("Session ended and returning to Main Menu..  Total books currently borrowed: " + current.getBorrowedCount());  
                            inUserMenu  = false;  // Exit user menu
                            break;  

                        default:  
                            System.out.println("Invalid choice, please try again.");  
                            break;  
                    }  
                }  

            }

            // Administrator Login Path
            else if (Mchoice == 2) {

                System.out.print("Enter admin password: -HINT: check the code-");  
                String password = input.nextLine();  // Read password input

                // Validate administrator password
                if (!password.equals("Admin1234")) {  
                    System.out.println("Wrong password, Can't let you in!");  
                } else {  

                    // Admin menu begins
                    boolean inAdminMenu  = true;  
                    while (inAdminMenu ) {  
                        System.out.println("\n~~~~~~~ Administrator Menu ~~~~~~");  
                        System.out.println("1. View Total Revenue");  
                        System.out.println("2. Most Frequent Operation (Borrow/Return)");  
                        System.out.println("3. Exit to Main Menu");  
                        System.out.print("Choose an option: ");  

                        int Achoice = input.nextInt();  
                        input.nextLine();  

                        switch (Achoice) {  
                            case 1:  
                                // Show total revenue across all borrow operations
                                System.out.printf("Total Revenue from all borrow operations: %.2f\n", Member.TotalRevenue);  
                                break;  

                            case 2:  
                                // Determine which operation happened more often
                                System.out.println("Most Frequent Operation:");  
                                if (Member.TotalBorrows == 0 && Member.TotalReturns == 0) {  
                                    System.out.println("- No borrow/return operations have been performed yet.");  
                                } else if (Member.TotalBorrows > Member.TotalReturns) {  
                                    System.out.println("- Borrow");  
                                } else if (Member.TotalReturns > Member.TotalBorrows) {  
                                    System.out.println("- Return");  
                                } else {  
                                    System.out.println("- Borrow and Return operations are equally frequent. (Tie)");  
                                }  
                                break;  

                            case 3:  
                                System.out.println("Returning to Main Menu...");
                                inAdminMenu  = false;  // Exit admin menu
                                break;  

                            default:  
                                System.out.println("Invalid choice, please try again.");  
                                break;  
                        }  
                    }  
                }  

            }

            // Program Exit Option
            else if (Mchoice == 3) {  
                System.out.println("Goodbye!");  
                flag = false;  // End main loop
            } else {  
                System.out.println("Invalid choice, please try again.");  
            }  
        }  

        input.close();  
    }  
}

