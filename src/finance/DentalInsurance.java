package finance;

public class DentalInsurance extends Benefits {
	public DentalInsurance(int i) {
		super(i);
	}
	
	public DentalInsurance(int i, String empFam, String plan) {
		super(i, empFam, plan);
	}
	
	@Override
	public String toString() {
		String dental = "Employee # " + this.getID() + " has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " dental insurance plan.";
		return dental;
	}
	
	public String data() {
		String dental = this.getID() + "," + this.getEmpFam() + "," + this.getPlan();
		return dental;
	}
}
