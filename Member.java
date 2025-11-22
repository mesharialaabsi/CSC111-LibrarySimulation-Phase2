/*
 Group members:
 1-Meshari Mohammed  Alqahtani(446104729)
 2-Khalid Ali  Alrumayh(446104352)
 3-Abdulaziz Fahad  AlSukayt(446100935)
 */
package project;

public class Member {  

    //   local Attributes
  

    private int id;                  // Unique member ID
    private String name;             // Member name
    private int borrowedCount;       // Number of books currently borrowed

    // Session-specific counters (reset every login)
    private int numViewBorrowed;     // How many times "view borrowed books" was used
    private int numBorrows;          // Number of borrow operations in this session
    private int numReturns;          // Number of return operations in this session
    private double sessionFees;      // Total fees accumulated in this session

    //   Global attributes

    public static double TotalRevenue = 0.0;      // Total revenue from all borrow operations
    public static int TotalViewBorrowed = 0;      // Total count of all "view borrowed" operations
    public static int TotalBorrows = 0;           // Total borrow operations performed by all users
    public static int TotalReturns = 0;           // Total return operations performed by all users

    //   Constructor

    public Member(int id, String name, int borrowedCount) {  
        this.id = id;  
        this.name = name;  
        this.borrowedCount = borrowedCount;  
        // Session statistics start at zero by default
    }  



    // Checks if this member is allowed to borrow a new book
    private boolean canBorrow() {  
        return borrowedCount < 5;    
    }  

    // Checks if this member has at least one book to return
    private boolean canReturn() {  
        return borrowedCount > 0;  
    }  


    // Displays how many books the member currently has
    public void viewBorrowedCount() {  
        numViewBorrowed++;          // Session counter
        TotalViewBorrowed++;        // Global counter

        System.out.println("Books currently borrowed by " + name + ": " + borrowedCount);
    }  

    // Attempts to borrow one book (adds a fee of 0.50)
    public boolean borrowOne() {  
        if (!canBorrow()) {  
            System.out.println("ERROR: Borrow limit reached (max 5 books).");  
            return false;  
        }  

        borrowedCount++;  
        numBorrows++;  
        TotalBorrows++;  

        sessionFees += 0.50;  
        TotalRevenue += 0.50;  

        System.out.println("Borrow successful. " + name +
                " now has " + borrowedCount + " book(s) borrowed.");
        System.out.printf("Fee charged: %.2f credits%n", 0.50);

        return true;  
    }  

    // Attempts to return a book (no fee applied)
    public boolean returnOne() {  
        if (!canReturn()) {  
            System.out.println("ERROR: No books to return.");  
            return false;  
        }  

        borrowedCount--;  
        numReturns++;  
        TotalReturns++;  

        System.out.println("Return successful. " + name +
                " now has " + borrowedCount + " book(s) borrowed.");

        return true;  
    }  

    // Prints the session statistics for this member
    public void displayStatistics() {  
        System.out.println("~~~~ Session Summary for " + name + " (ID: " + id + ") ~~~~");  
        System.out.println("Books Borrowed (this session): " + numBorrows);  
        System.out.println("Books Returned (this session): " + numReturns);  
        System.out.println("Times View Borrowed Count used (this session): " + numViewBorrowed);  
        System.out.printf("Fees Incurred (this session): %.2f\n", sessionFees);  
    }  

    // Resets session counters (called at login)
    public void reset() {  
        this.numViewBorrowed = 0;  
        this.numBorrows = 0;  
        this.numReturns = 0;  
        this.sessionFees = 0.0;  
    }  

    //   Getters and Setters
  

    public int getId() {  
        return id;  
    }  

    public String getName() {  
        return name;  
    }  

    public int getBorrowedCount() {  
        return borrowedCount;  
    }  

    public double getSessionFees() {  
        return sessionFees;  
    }  

    public void setBorrowedCount(int borrowedCount) {  
        this.borrowedCount = borrowedCount;  
    }  
}
