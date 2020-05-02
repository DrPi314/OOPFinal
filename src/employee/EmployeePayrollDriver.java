package employee;

public class EmployeePayrollDriver {
	public static void main(String[] args)
	   {
EmployeePayroll employee1=new EmployeePayroll("Hussein", "Marty","EMPLOYEEID536973");
	      


employee1.setHours(40);
employee1.setWage(5);
	      
System.out.println("Employee2 :");
	      

System.out.println(employee1.toString());
	      

EmployeePayroll employee2=new EmployeePayroll("Ranada", "Lengiso","EMPLOYEEID536973");


employee2.setHours(50);
employee2.setWage(6);
	      
System.out.println("Employee2 :");

System.out.println(employee2.toString());
	      
	      

employee2.setHours(-4);
	      
	      
if(employee1.equals(employee2))
	System.out.println("Employees are equal");
else
	System.out.println("Employees are different");
	              
	   }
	}
