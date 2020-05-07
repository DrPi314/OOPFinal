package finance;

public class DentalInsurance extends Benefits {
	
	public DentalInsurance(String empFam, String plan) {
		super(empFam, plan);
	}
	
	@Override
	public String toString() {
		String dental = "Employee has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " dental insurance plan.";
		return dental;
	}
}
