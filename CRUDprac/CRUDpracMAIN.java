package practice;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class crudPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Array list and we call our object here and named it expenses
		List<CrudPrac> expenses = new ArrayList<>();
		String choice; //choice here for replayability
		do {
			CrudPrac.Menu(); //call our menu here
			choice = sc.nextLine();
			
			//choices
			switch(choice) {
			//if 1 you add your expenses
			case "1":
				System.out.println("Category: ");
				String cat = sc.nextLine();
				
				System.out.println("Amount: ");
				double amt = Double.parseDouble(sc.nextLine());
				
				System.out.println("yyyy-M-d");
				LocalDate dt = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-M-d"));
				expenses.add(new CrudPrac(cat, amt, dt));
				System.out.println("Added! ");
				break;
				
				//if 2 it shows current expenses and if its empty
			case "2":
				System.out.println("Current Expesnes: ");
				for(CrudPrac e : expenses) {
						System.out.println(e);
				}
				if(expenses.isEmpty())
				{
					System.out.println("Your expenses is empty!");
				}
				
				break;
				//if 3 and you didn't add anything it shows no expenses to update
				//if so it show you the current expenses
				//and you can update it anytime
			case "3":
				if(expenses.isEmpty()) {
					System.out.println("No expesnes to update");
					break;
				}
				
				System.out.println("Current Expenses");
				for(int i = 0; i < expenses.size(); i++) {
					System.out.println(i + ": " + expenses.get(i));
				}
				System.out.println("Enter index to Update: ");
				int idx = Integer.parseInt(sc.nextLine());
				if(idx >= 0 && idx < expenses.size()) {
					CrudPrac e = expenses.get(idx);
					System.out.println("New Category: ");
					e.setCategory(sc.nextLine());
					System.out.println("New Amount: ");
					e.setAmount(Double.parseDouble(sc.nextLine()));
					System.out.println("New Date: ");
					e.setDate(LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-M-d")));
					System.out.println("Updated!");
				} else {
					System.out.println("Invalid Wrong!");
				}
				break;
				//delete index
			case "4":
				System.out.println("Index to Delete");
				int idxDel = Integer.parseInt(sc.nextLine());
				if(idxDel >= 0 && idxDel < expenses.size()) {
					expenses.remove(idxDel);
					System.out.println("Succesfully Deleted!");
				} else {
					System.out.println("Invalid index!");
				}
				break;
				//exit
			case "0":
				System.out.println("Exiting. . .");
				break;
				default:
					System.out.println("Invalid!");
			}
		}while(!choice.equals("0")); //if you type 0 it ends
		System.out.println("See ya!");
		sc.close();
	}

}
