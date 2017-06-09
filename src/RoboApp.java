import java.sql.*; 
import java.util.Scanner;
public class RoboApp {

	public static void main(String[] args) throws SQLException {
		 
		int personid; 
		String fname, lname; 
		
		Scanner keyboard = new Scanner (System.in); 
		
		System.out.println("What is your first name?"); 
		fname = keyboard.next(); 
		
		System.out.println("What is your last name?"); 
		lname = keyboard.next();  
		System.out.println("Test1 ");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		//System.out.println("Test");

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?","root","password");  
		PreparedStatement preparedStmt;
		
		System.out.println("Test con ");
		String query = (" INSERT INTO PERSON VALUES F_NAME, L_NAME) VALUES (?,?)"); 
		preparedStmt = con.prepareStatement(query); 
		
		preparedStmt.setString(1, fname);
		preparedStmt.setString(2, lname);

		System.out.println("Test2 ");
		preparedStmt.executeUpdate();
		
		System.out.println("Person was added!");
		
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}  

	}

}
