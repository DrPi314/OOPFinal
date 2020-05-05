package employee;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {

   private NewHire newEmp;
   private  Salary salary;
    private Hourly time;
     

   


// constructor for new employee
	public Employee(NewHire newEmp,Hourly time,Salary salary) {
		this.newEmp=newEmp;
		this.time=time;
		this.salary=salary;
	
		
	}
	
	public Employee() {
		this.newEmp = null;
		this.salary = null;
		this.time = null;
	}





	public NewHire getNewEmp() {
		return newEmp;
	}





	public void setNewEmp(NewHire newEmp) {
		this.newEmp = newEmp;
	}





	public Salary getSalary() {
		return salary;
	}





	public void setSalary(Salary salary) {
		this.salary = salary;
	}





	public Hourly getTime() {
		return time;
	}





	public void setTime(Hourly time) {
		this.time = time;
	}





	@Override
	public String toString() {
		return "Employee [newEmp=" + newEmp + ", salary=" + salary + ", time=" + time + "]";
	}
	
	
	
	
	
}










