package finance;

public class DentalInsurance extends Benefits {

	private int type;
	
	public DentalInsurance() {
		type = 0;
	}
	
	public DentalInsurance(int t) {
		type =  t;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	public String toString() {
		String dental;
		if(this.getType() > 0) {
			dental = "has dental coverage of " + this.getType() + " type, ";
		} else {
			dental = "has no dental coverage, ";
		}
		return dental;
	}
}
