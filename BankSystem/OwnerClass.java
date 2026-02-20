package practice;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Owner {
	private String name;
	private String email;
	private String phoneNumber;
	private String address;
	private LocalDate dateOfBirth;
	
	//Constructor
	public Owner(String name, String email, String phoneNumber, String address, String dateOfBirth) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter); // default format: yyyy-MM-dd
	}
	
	//Getters
	public void getName(String name) { this.name = name; }
	public void getEmail(String email) { this.email = email; }
	public void getPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
	public void getAddress(String address) { this.address = address; }
	public LocalDate getDateOfBirth(LocalDate dateOfBirth) { return dateOfBirth; }
	
	//setters
	public void setDateOfBirth(String dateOfBirth) {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		 this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
	}
	public String setName(String name) { return name; }
	public String setEmail(String email) { return email; }
	public String setPhoneNumber(String phoneNumber) { return phoneNumber; }
	public String setAddress(String address) {return address; }
	
	//override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return name + " | " + email + " | " + phoneNumber + " | " + address + " | DOB: " + dateOfBirth.format(formatter);
	}
}
