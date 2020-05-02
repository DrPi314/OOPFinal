package finance;

public class HealthInsurance extends Benefits{
	
	private int level;
	private int type;		//type will be the index value for a list of types
	
	public HealthInsurance() {
		level = 0;
		type = 0;
	}
	
	public HealthInsurance(int l, int t) {
		if(super.isHasHealth()) {
			level = l;
			type = t;
		}
	}

	public int getLevel() {
		return level;
	}

	public int getType() {
		return type;		//this will eventually be a switch statement referencing an array
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String toString() {
		String healthInsurance;
		String lev;
		String typ;
		if(level > 0) {
			lev = "has health insurance of " + this.getLevel() + " level, ";
			typ = "and has health insurance of " + this.getType() + " type.";
			healthInsurance = lev + typ;
		} else {
			healthInsurance = "has no health insurance.";
		}
		return healthInsurance;
	}
	
	

}
