import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;



public class ResumeBuild {

	private Person person; 
	private Education education; 
	private Experience experience; 
	private Skills skill; 
	private Duty duty;
	private Connection con;


	public String getPerson() {
		person.getFname();
		person.getLname();
		person.getEmail();
		return "";

	} 

	public String getEducation(){
		education.getDegree(); 
		education.getSchool(); 
		education.getDegree();
		return "";
	} 

	public String getExperience(){
		experience.getExp(); 
		return experience.getExp();
	} 
	
	public String getSkills(){
		skill.getSname(); 
		return skill.getSname();
	}

	public String getDuties(){
		duty.getDuty(); 
		return duty.getDuty();
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

			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?USSL","root","password");  
			PreparedStatement preparedStmt;


			// this inserts only the first name and last name not id because we have auto increment 
			String query = ("INSERT INTO PERSON (FNAME, LNAME, EMAIL) VALUES (?,?,?)");  
			query = ("SELECT FNAME, LNAME, EMAIL FROM PERSON"); 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table 
			
			//executeQuery: to execute the select query
			while(rs.next()){  // from the current pointer till the end of the table
				System.out.println(rs.getString(1)+"  "+rs.getString(2)
				+"  "+rs.getString(3)); } 
			  
			
			preparedStmt = con.prepareStatement(query);

			//tells it to insert fname into the first ? and lname to the second ?
			preparedStmt.setString(1, fName);
			preparedStmt.setString(2,lName); 
			preparedStmt.setString(3, email);

			//executes the query
			preparedStmt.executeUpdate();

			//prints the person was added
			System.out.println(fName + " was added!");

		} catch(Exception e){ System.out.println(e);} 


	} 

	public void setEducation(){ 	
		Scanner keyboard = new Scanner(System.in);
		String response ="Y"; 
		int id=1;
		while(response.equals("Y")){
			System.out.println("Whats the name of your school ");
			String school = keyboard.nextLine(); 

			System.out.println("What was your degree in?");
			String degree = keyboard.nextLine(); 

			System.out.println("What year did you graduate?"); 
			String year = keyboard.next();  
			this.education = new Education (id, school, degree, year);

			try {

				Class.forName("com.mysql.jdbc.Driver");

				//Establish connection to database 

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?","root","password");  
				PreparedStatement preparedStmt;


				// this inserts only the first name and last name not id because we have auto increment 
				String query = ("INSERT INTO EDUCATION (SCHOOL, PERSON_ID, DEGREE_NAME, D_YEAR) VALUES (?,?,?,?)"); 
				
				query= ("SELECT SCHOOL, DEGREE_NAME, D_YEAR FROM EDUCATION;"); 
				Statement stmt=con.createStatement();  // to provide methods to execute different SQL queries
				
				ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table
				//executeQuery: to execute the select query
				while(rs.next()){  // from the current pointer till the end of the table
					System.out.println(rs.getString(1)+"  "+rs.getString(2)
					+"  "+rs.getString(3)); } 
				con.close();   
				preparedStmt = con.prepareStatement(query);

				//tells it to insert fname into the first ? and lname to the second ?
				preparedStmt.setString(1, school);
				preparedStmt.setInt(2,1); 
				preparedStmt.setString(3, degree); 
				preparedStmt.setString(4, year); 


				//executes the query
				preparedStmt.executeUpdate();

				//prints the person was added
				System.out.println("education was added!"); 

				System.out.println("Would you like to add another education? (Y/N)"); 
				response = keyboard.nextLine();	

			} catch(Exception e){ System.out.println(e);} 

		}

		System.out.println("");
	}  

	public void setExperience(){ 
		Scanner keyboard = new Scanner(System.in);
		String response = "Y"; 
		int id = 1;
		
		while(response.equals("Y")){
			System.out.println("Add your job experience."); 
			String experience =keyboard.next();  
			
			this.experience = new Experience(experience, id);

			try {

				Class.forName("com.mysql.jdbc.Driver");

				//Establish connection to database 

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?","root","password");  
				PreparedStatement preparedStmt;


				// this inserts only the first name and last name not id because we have auto increment 
				String query = ("INSERT INTO EXPERIENCE (EXP, PERSON_ID) VALUES (?,?)"); 
				
				query= ("SELECT EXP FROM EXPERIENCE;"); 
				Statement stmt=con.createStatement();  // to provide methods to execute different SQL queries
				
				ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table
				//executeQuery: to execute the select query
				while(rs.next()){  // from the current pointer till the end of the table
					System.out.println(rs.getString(1)); } 
				
				
				preparedStmt = con.prepareStatement(query);

				//tells it to insert fname into the first ? and lname to the second ?
				preparedStmt.setString(1, experience);
				preparedStmt.setInt(2,1); 


				//executes the query
				preparedStmt.executeUpdate();

				//prints the person was added 
				String yes = "Y"; 
				
				while(yes.equals("Y")){
					System.out.println("What were your duties?"); 
					String duty = keyboard.next(); 
					this.duty = new Duty(duty, id);

					query = ("INSERT INTO DUTY (DUTYNAME, EXP_ID) VALUES (?,?)");  
					query= ("SELECT DUTYNAME FROM DUTY;"); 
					Statement stmt1=con.createStatement();  // to provide methods to execute different SQL queries
					
					ResultSet rs1=stmt1.executeQuery(query);  //cursor pointer to the row of the table
					//executeQuery: to execute the select query
					while(rs1.next()){  // from the current pointer till the end of the table
						System.out.println(rs1.getString(1));}
					
					
					
					preparedStmt = con.prepareStatement(query); 

					preparedStmt.setString(1, duty);
					preparedStmt.setInt(2,1); 

					//executes the query
					preparedStmt.executeUpdate(); 
					
					System.out.println("Would you like to add another duty? (Y/N)"); 
					yes = keyboard.nextLine();
				
				}

				System.out.println("experience was added!"); 
				 

				

			} catch(Exception e){ System.out.println(e);} 

			System.out.println("Would you like to add another experience? (Y/N)"); 
			response = keyboard.nextLine();	
		} 
 
		
		
		
		
	} 
		public void setSkills(){ 
			Scanner keyboard = new Scanner(System.in);
			String name; 
			String response;
			int id =1;
			System.out.println("Would you like to add a skill? (Y/N)");
			response = keyboard.next(); 
			
			
			while(response.equals("Y")){
				System.out.println("Please add the skill.");
				name = keyboard.nextLine(); 
				this.skill = new Skills(name, id);
			
			
			try {

				Class.forName("com.mysql.jdbc.Driver");

				//Establish connection to database 

				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ROBO?","root","password");  
				PreparedStatement preparedStmt;


				// this inserts only the first name and last name not id because we have auto increment 
				String query = ("INSERT INTO SKILLS (SKILL_NAME, PERSON_ID,) VALUES (?,?)"); 
				preparedStmt = con.prepareStatement(query); 
				
				query= ("SELECT SKILL_NAME FROM SKILLS;"); 
				Statement stmt=con.createStatement();  // to provide methods to execute different SQL queries
				
				ResultSet rs=stmt.executeQuery(query);  //cursor pointer to the row of the table
				//executeQuery: to execute the select query
				while(rs.next()){  // from the current pointer till the end of the table
					System.out.println(rs.getString(1)); } 
				
				
				

				//tells it to insert fname into the first ? and lname to the second ?
				preparedStmt.setString(1, name);
				preparedStmt.setInt(2, id); 

				//executes the query
				preparedStmt.executeUpdate(); 
				
				
				System.out.println("Would you like to add another skill? (Y/N)"); 
				response = keyboard.nextLine();
	

			} catch(Exception e){ System.out.println(e);} 

			}
			
			
		}

}




