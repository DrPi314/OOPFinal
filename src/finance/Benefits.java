package finance;

import employee.*;

public class Benefits {

	private String fName;
	private String lName;
	private int ID;
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
	
	public Benefits(String fn, String ln, int id, double ira, double dis, boolean ft, boolean hea, boolean den, int l, int td, int th) {
		fName = fn;
		lName = ln;
		ID = id;
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
		benefits = "Employee number " + this.ID + " currently has " + this.getIraRate() 
				+ " percent deducted from their checks to their IRA, receives a " + this.getCompanyDiscount()
				+ " percent discount on products purchased from our company, " + full + planD.toString() + planH.toString();
		return benefits;
	}
	
	
}
