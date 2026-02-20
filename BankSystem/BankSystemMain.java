package practice;
import java.util.*; // *; so we can access all library on java util
import java.lang.IllegalArgumentException; //added illegal argument exception so we can throw errors professionally
import java.time.LocalDate; //date time
import java.time.format.DateTimeFormatter; //can format time
public class BankSystemSimulation {

	public static void main(String[] args) {
		//scanner named sc for user input
		Scanner sc = new Scanner(System.in);
		//Array list and we call our object here and named it bank
		List<BankSystem> bank = new ArrayList<>();
		//choice so you can replay it and initializing as null ensures the variable exists safely and the loop works properly before any user input.
		//And handles do-while very well
		String key = null;
		
		do { // do executes once
			try { // try block of code that will be tested for errors while executing
				BankSystem.Menu(); //call our menu
				key = sc.nextLine(); //variable key for our switch
				
				//switch so we can choose then put key so we can actually pick
				switch(key) {
				//case 1 we create our account
				case "1":
					System.out.print("Owner Name: ");
					String name = sc.nextLine().trim(); //added trim so if you put space it will cut it
					
					System.out.print("Email: ");
					String email = sc.nextLine().trim();
					
					System.out.print("Phone Number: ");
					String phoneNumber = sc.nextLine().trim();
					
					System.out.print("Address: ");
					String address = sc.nextLine().trim();
					
					String dob;
					while(true) {
						try {
							System.out.print("Date of Birth (dd/mm/yyyy): ");
							dob = sc.nextLine().trim();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							LocalDate.parse(dob, formatter);
							break;
						}catch(Exception e) {
							System.out.println("Invalid Date Format! Use DD/MM/YYYY only!");
						}
					}
					
					double balance = 0; // balance will always start at 0
					while(true) { //while so it can repeat if you put wrong input
						System.out.print("Enter initial Balance: ");
						try {// try block of code that will be tested for errors while executing
							//since we put integer in initial balance we use double parse so it can have a digit
							balance = Double.parseDouble(sc.nextLine().trim());
							//throws illegal argument exception if we put negative numbers
							if(balance < 0) 
							throw new IllegalArgumentException("Balance cannot be negative!");
							break;
						
							//catch allows you to define a block code to be executed and will catch the error
							//NumberFormatException throws a error when
							//Non-numeric characters like parsing 123a to an integer
							//Empty or Null strings trying to parse a null or ""
							//lastly Incorrect Format parsing float as a int and white spacing
						}catch(NumberFormatException e) {
							System.out.println("Numbers only please");
						}catch(IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
					
					//Initialize the enum to null so we can handle "Enter" (no input) safely
					BankSystem.AccountType type = null;
					//while so it can repeat if you put wrong input
					while(true) {
						//choose what bank account type
						System.out.print("Choose account type [1] Savings [2] Checking: ");
						try {
							// Parse input as integer; throws exception if invalid
							int typeChoice = Integer.parseInt(sc.nextLine().trim());
							//if 1 then its savings account
							if(typeChoice == 1) {
								type = BankSystem.AccountType.Savings;
							//if 2 then its checking account
							}else if(typeChoice == 2) {
								type = BankSystem.AccountType.Checking;
							//if you type 3 or something it throws an error
							} else {
								throw new IllegalArgumentException("Invalid Number!");
							}
							break;
							//then break stops then proceed to other block code
							
						}catch(NumberFormatException e) {
							System.out.println("Numbers only please");
						}
					}
					
					//owner class
					Owner owner = new Owner(name, email, phoneNumber, address, dob);
					//Created new bank account 
					//added the name, balance and type we choose
					BankSystem addAcc = new BankSystem(owner, balance, type);
					bank.add(addAcc);
					//unique id when creating new account
					System.out.println("Account Created! Your unique ID is: " + addAcc.getAccountID());
					break;
				case "2": 
					//if you didn't have bank account it prints this
					if(bank.isEmpty()) {
						System.out.println("Your Account is empty!");
					//if so it let you check your bank account
					}else {
						for(BankSystem e : bank) {
							System.out.println(e); 
						}
					}
					break;
					
				case "3":
					//if you didn't have bank account it prints this
					if(bank.isEmpty()) {
						System.out.println("Your Account is empty!");
						break;
					}
					while(true) {
						try {
					//put a number what your account is
					System.out.print("Select an account to deposit into: ");
					//parse it into integer
					//-1 so it'll be 1 instead of 0 since we used array list
					int accIdx = Integer.parseInt(sc.nextLine().trim()) - 1;
					//if 0 or accidx is greater than equal then it prints this
					if(accIdx < 0 || accIdx >= bank.size()) {
						System.out.println("Invalid!");
						continue;
						//continue until the input is correct
					}
					//we call the class and also use array list to get the bank account information
					//and how money to deposit
					BankSystem accSelect = bank.get(accIdx);
						System.out.print("Enter amount of money to deposit: ");
							double deposit = Double.parseDouble(sc.nextLine());
							//cannot be less than zero
							//if so it throws an exception
							if(deposit < 0) 
							throw new IllegalArgumentException("Balance cannot be negative!");
							//we call accSelect then pass the deposit to parameter
							//then it'll do its logic in class
							accSelect.depositMoney(deposit);
							 System.out.println("Transaction successful!");
							break;
						}catch(NumberFormatException e) {
							System.out.println("Numbers only please");
						}catch(IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
					break;
				case "4":
					//if you didn't have bank account it prints this
					if(bank.isEmpty()) {
						System.out.println("Your Account is empty!");
						break;
					}
					while(true) {
						try {
					//put a number where your account is 
					System.out.print("Select an account to withdraw into: ");
					//-1 so it can be 1 instead of 0
					int accIdx = Integer.parseInt(sc.nextLine()) - 1;
					//if 0 or accidx is greater than equal bank.size then it prints this
					if(accIdx < 0 || accIdx >= bank.size()) {
						System.out.println("Invalid!");
						continue;
						//continue until the input is correct
					}
					//call our class here and get the accIdx using bank
					//so it knows that it has an account
					BankSystem accSelect = bank.get(accIdx);
						//we withdraw here put our input here
						System.out.print("Enter amount of money to withdraw: ");
							//then double withdraw then double parse it so it can pass through the logic of the withdraw class
							double withdraw = Double.parseDouble(sc.nextLine());
							//if its negative it throws an exception
							if(withdraw < 0) 
							throw new IllegalArgumentException("Balance cannot be negative!");
							//then accselect withdraw money then the parameter where you put the money
							//then it'll do its logic on class
							accSelect.withDrawMoney(withdraw);
							 System.out.println("Transaction successful!");
							break;
						}catch(NumberFormatException e) {
							System.out.println("Numbers only please");
						}catch(IllegalArgumentException e) {
							System.out.println("Error: " + e.getMessage());
						}
					}
					break;
				case "5":
					//without account then empty
					if(bank.isEmpty()) {
						System.out.println("No accounts to delete!");
						break;
					}
					while(true) {
						try {
					//select a number where you account is
					System.out.println("Select an account to delete ");
					//then accidxdel and parse it into integer then -1 so it'll be 1 instead of 0
					int accIdxDel = Integer.parseInt(sc.nextLine()) - 1;
					//accidxdel is greater than equal to 0 then it'll delete the first account
					//then if accidxdel is less than bank.size it'll delete it
					if(accIdxDel >= 0 && accIdxDel < bank.size()) {
						//deletes accounts
						bank.remove(accIdxDel);
						System.out.println("Succesfully Deleted!");
						break;
					} else {
						System.out.println("Invalid!");
						continue;
					}
					
						
					}catch(NumberFormatException e) {
						System.out.println("Numbers only please");
					}catch(IllegalArgumentException e) {
						System.out.println("Error: " + e.getMessage());
					}
				}
					break;
					//exit
				case "0":
					System.out.println("Exiting. . .");
					break;
					default:
						System.out.println("Invalid!");
				}
			}catch(NumberFormatException e) {
				System.out.println("Numbers only please");
			}catch(IllegalArgumentException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}while(!key.equals("0"));// if 0 then it exit if without ! then it'll never print all of this since if we put 0 zero it stops
		System.out.println("See ya");
		sc.close();
	}
}
