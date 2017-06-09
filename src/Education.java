
public class Education { 
	 
	private int personid;
	private String degree, year, school;
	
	
	public String getSchool() {
		return school;
	}


	public void setSchool(String school) {
		this.school = school;
	}


	public Education(int personid, String degree, String year, String school){
		this.personid = personid; 
		this.degree = degree; 
		this.year = year;	
		this.school = school;
	}
	
	
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	} 
	
	
	
	

	

}
