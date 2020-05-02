package employee;

public class EmployeePayroll{
	

private String firstName;
private String lastName;
private String id;
private int hoursWorked;
private double wages_hour;


public EmployeePayroll(String firstName,String lastName,String id )
   {

this.firstName=firstName;
this.lastName=lastName;
this.id=id;
hoursWorked=0;
wages_hour=0;      
   }


public void setHours(int hours)
   {

if(hours>0)
	this.hoursWorked=hours;
else
	System.out.println("Hours must be positive");      
   }

   
public void setWage(double wage)
{
wages_hour=wage;
   }


public String getFirstName()
{
	return firstName;
 }
public String getLastName()
   {
	return lastName;
}

public String getID()
   {
	return id;
}

public int getHours()
   {
	return hoursWorked;
}


public double getWage()
{
	return wages_hour;
}

  
public void incrementHours(int numHours)
  {

hoursWorked=hoursWorked+numHours;
}

public void resetPayCycle(int hours,double wage)
   {

hoursWorked=hours;
wages_hour=wage;
}
   
public String toString()
   {
return "Name "+firstName+" "+lastName+"\n"+ "ID "+id+"\n"+ "Pay :"+hoursWorked*wages_hour;
   }


public boolean equals(Object obj)
 {
      
EmployeePayroll empObject=(EmployeePayroll)obj;
return id.equals(empObject.getID());
   }
}