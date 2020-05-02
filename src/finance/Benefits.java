package finance;

import employee.Employee;

public class Benefits extends Employee {

	private double iraRate;
	private double companyDiscount;
	private boolean fullTime;
	private boolean hasHealth;
	private boolean hasDental;
	private DentalInsurance planD;
	private HealthInsurance planH;
	
	private String full;
	private String health;
	private String dental;
	
	public Benefits() {
		super();
		iraRate = 0.00;
		companyDiscount = 0.00;
		fullTime = false;
		hasHealth = false;
		hasDental = false;
		planD = new DentalInsurance();
		planH = new HealthInsurance();
	}
	
	public Benefits(int id, String name, double ira, double dis, boolean ft, boolean hea, boolean den, int l, int td, int th) {
		super(id, name);			//make sure we get a constructor for Employee that handles these variables
		iraRate = ira;
		companyDiscount = dis;
		fullTime = ft;
		hasHealth = hea;
		hasDental = den;
		planD = new DentalInsurance(td);
		planH = new HealthInsurance(l, th);
		}
	

	public double getIraRate() {
		return iraRate;
	}

	public double getCompanyDiscount() {
		return companyDiscount;
	}

	public boolean isFullTime() {
		return fullTime;
	}

	public boolean isHasHealth() {
		return hasHealth;
	}

	public boolean isHasDental() {
		return hasDental;
	}

	public void setIraRate(double iraRate) {
		this.iraRate = iraRate;
	}

	public void setCompanyDiscount(double companyDiscount) {
		this.companyDiscount = companyDiscount;
	}

	public void setFullTime(boolean fullTime) {
		this.fullTime = fullTime;
	}

	public void setHasHealth(boolean hasHealth) {
		this.hasHealth = hasHealth;
	}

	public void setHasDental(boolean hasDental) {
		this.hasDental = hasDental;
	}
	
	public String toString() {
		String benefits;
		if(this.isFullTime()) {
			full = "is a Full-Time employee, ";
		} else {
			full = "is a Part-Time employee, ";
		}
		benefits = "Employee number " + super.getId() + " currently has " + this.getIraRate() 
				+ " percent deducted from their checks to their IRA, receives a " + this.getCompanyDiscount()
				+ " percent discount on products purchased from our company, " + full + planD.toString() + planH.toString();
		return benefits;
	}
	
	
}
