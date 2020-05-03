package employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewHire {
	//Global variables
	private String firstName;
	private String lastName;
	private int  id;
	private int age;
    private String gender;
    private String department;
    private  Date dateOfJoining;
    
    public NewHire(String firstName, String lastName,String gender,String department, Date dateOfJoining,int id,int age) {
    	this.firstName = firstName;
		this.lastName= lastName;
		this.gender=gender;
		this.id=id;
		this.department=department;
		this.age= age;
		this.dateOfJoining=dateOfJoining;
    	
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String dateOfJoin =simpleDateFormat.format(dateOfJoining);
		return "NewHire [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", age=" + age
				+ ", gender=" + gender + ", department=" + department + ", dateOfJoining=" + dateOfJoin + "]";
	}
     
     
     
    
}
