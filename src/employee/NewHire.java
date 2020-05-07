package employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import finance.*;

public class NewHire extends EmpNameID {
	//Global variables  (moved name and id to its own class)
	private int age;
    private String gender;
    private String department;
    private  Date dateOfJoining;
    
    public NewHire(int id, String firstName, String lastName,String gender, String department,Date dateOfJoining,int age) {
    	super(id, firstName, lastName);
		this.gender=gender;
		this.department=department;
		this.age= age;
		this.dateOfJoining=dateOfJoining;
    	
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
		return "NewHire [firstName=" + super.getfName() + ", lastName=" + super.getlName() + ", id=" + super.getID() + ", age=" + age
				+ ", gender=" + gender + ", department=" + department + ", dateOfJoining=" + dateOfJoin + "]";
	}
     
     
     
    
}
