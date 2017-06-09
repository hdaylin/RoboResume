import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ResumeBuild {

	private Person person;

	public String getPerson() {
		person.getFname();
		person.getLname();
		person.getEmail();
		return "";
		
	}
	
	public String getlname(){
		person.getLname(); 
		return person.getLname();
	}
	

	public void setPerson() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter first name.");
		String fName = keyboard.nextLine();
		System.out.println("Please enter last name");
		String lName = keyboard.nextLine();
		System.out.println("Please enter email");
		String email = keyboard.nextLine();
		this.person = new Person(fName, lName, email); 
		
	   
	
	try {
		
		Class.forName("com.mysql.jdbc.Driver");
		
	//Establish connection to database 

	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?","root","password");  
	PreparedStatement preparedStmt;
	

	// this inserts only the first name and last name not id because we have auto increment 
	String query = ("INSERT INTO PERSON (FNAME, LNAME, EMAIL) VALUES (?,?,?)"); 
	preparedStmt = con.prepareStatement(query);
	
	//tells it to insert fname into the first ? and lname to the second ?
	preparedStmt.setString(1, fName);
	preparedStmt.setString(2,lName); 
	preparedStmt.setString(3, email);

	//executes the query
	preparedStmt.executeUpdate();
	
	//prints the person was added
	System.out.println(person.getFname() + " was added!");
	
	} catch(Exception e){ System.out.println(e);
		
		} 
	}
}
	
	
	

