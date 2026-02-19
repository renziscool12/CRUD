package practice;
import java.util.*;
// BankSystem class represents a single bank account with basic CRUD operations
// represents a single bank account with basic functionality
public class BankSystem {
	
	// enum to define account types
	// fixed set of option
	// can't change
	enum AccountType {
		Savings, // saving account
		Checking // checking account
	}
	 // Fields for the account
	private 	String accountName;  // account holder's name can be changed
	private double balance;  // current balance updated via deposit/withdraw
	// Universally Unique Identifier
	private final UUID accountID; // unique account ID cannot be changed
	private final AccountType accountType; // type of account and cannot be changed since its final
    
	
	// Constructor for creating a account
	public BankSystem(String accountName, double balance, AccountType accountType) {
		this.accountName = accountName; // Set Account Name
		this.balance = balance;
		this.accountID = UUID.randomUUID(); // guaranteed random new IDs
		this.accountType = accountType;
	}
	
	// depositing money if you put something it adds if negative it prints a warning
	public void depositMoney(double amount) {
		if(amount > 0) {
			balance += amount;
		}else {
			System.out.println("Deposit must be positive!");
		}
	}
	
	// withdrawing money if you put negative and if the amount is greater than balance it gives you warning
	// after that you withdraw money
	public void withDrawMoney(double amount) {
		if(amount <= 0) {
			System.out.println("Amount must be positive!");
		}else if(amount > balance) {
			System.out.println("Insufficient Balance!");
		} else {
			balance -= amount;
		}
	}
	
	// optional to change if i want to
	public void setAccountName(String name) {
		if(name != null && !name.isEmpty()) {
			this.accountName = name;	
		}
	}
	
	// getter
	public double getBalance() { return balance; }
	public String getAccountName() { return accountName; }
	public UUID getAccountID() { return accountID; }
	public AccountType getAccountType() {return accountType; }
	
	// override
	// added ToString to accountID so it can override
	public String toString() {
		return "ID: " + accountID.toString() + " | " + accountName + " | " + accountType + " | Balance: $" + String.format("%.2f", balance);
	}
	
	// menu
	public static void Menu() {
			System.out.println("\n====================");
		    System.out.println("      LAND BANK    ");
		    System.out.println("====================");
		    System.out.println("[1] Add Account");
		    System.out.println("[2] List Accounts");
		    System.out.println("[3] Deposit");
		    System.out.println("[4] Withdraw");
		    System.out.println("[5] Delete Account");
		    System.out.println("[0] Exit");
		    System.out.println();
		    System.out.print("Choose your number: ");
	}
	
}
