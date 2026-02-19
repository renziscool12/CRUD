package practice;
import java.time.LocalDate;
class CrudPrac {
	//private fields so only class can change
	private String category;
	private double amount;
	private LocalDate date;
	
	//getter
	public CrudPrac(String category, double amount, LocalDate date) {
		this.category = category;
		this.amount = amount;
		this.date = date;
	}
	//setter
	public void setCategory(String category) { this.category = category;}
	public void setAmount(double amount) { this.amount = amount; }
	public void setDate(LocalDate date) { this.date = date; }
	
	//override
	public String toString() {
		return date  + " - " + category + ": $" + String.format("%.2f", amount);
		
		//menu
	}
		public static void Menu() {
			System.out.println("MENU");
			System.out.println("1. Add Expenses");
			System.out.println("2. List Expenses");
			System.out.println("3. Update Expenses");
			System.out.println("4. Delte Expenses");
			System.out.println("0. Exit");
			System.out.print("Your Input : ");
		}
}
