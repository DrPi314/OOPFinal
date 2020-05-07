package employee;

import java.text.SimpleDateFormat;
import java.util.Date;
import finance.*;

public class NewHire extends EmpNameID {
	// Global variables (moved name and id to its own class)
	private int age;
<<<<<<< HEAD
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
=======
	private String gender;
	private String department;
	private Date dateOfJoining;

	public NewHire(String firstName, String lastName, int id, String gender, String department, Date dateOfJoining,
			int age) {
		super(firstName, lastName, id);
		this.gender = gender;
		this.department = department;
		this.age = age;
		this.dateOfJoining = dateOfJoining;

	}
>>>>>>> 555ebd19777906ab788d9b6de2c76858edd54bd5

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
<<<<<<< HEAD
		String dateOfJoin =simpleDateFormat.format(dateOfJoining);
		return "NewHire [firstName=" + super.getfName() + ", lastName=" + super.getlName() + ", id=" + super.getID() + ", age=" + age
				+ ", gender=" + gender + ", department=" + department + ", dateOfJoining=" + dateOfJoin + "]";
=======
		String dateOfJoin = simpleDateFormat.format(dateOfJoining);
		//<<<<<<< HEAD
		return "NewHire [firstName=" + super.getfName() + ", lastName=" + super.getlName() + ", id=" + super.getID()
		+ ", age=" + age + ", gender=" + gender + ", department=" + department + ", dateOfJoining=" + dateOfJoin
		+ "]";
		//=======

		// return firstName + "," + lastName + "," + id + "," + age
		// + "," + gender + "," + department + "," + dateOfJoin + "]";
		//>>>>>>> 862ed20fa7b468960f9c646ec7ff27b5c0c925a4
>>>>>>> 555ebd19777906ab788d9b6de2c76858edd54bd5
	}

}
