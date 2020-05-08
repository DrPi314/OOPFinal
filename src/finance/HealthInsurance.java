package finance;

public class HealthInsurance extends Benefits{
	public HealthInsurance(int i) {
		super(i);
	}
	
	public HealthInsurance(int i, String empFam, String plan) {
		super(i, empFam, plan);
	}
	
	@Override
	public String toString() {
		String health = "Employee # " + this.getID() + " has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " health insurance plan.";
		return health;
	}
	
	public String data() {
		String health = this.getID() + "," + this.getEmpFam() + "," + this.getPlan();
		return health;
	}
}