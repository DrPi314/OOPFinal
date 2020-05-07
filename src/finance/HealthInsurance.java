package finance;

public class HealthInsurance extends Benefits{
	
	private int level;
	private int type;		//type will be the index value for a list of types
	
	public HealthInsurance(String empFam, String plan) {
		super(empFam, plan);
	}
	
	@Override
	public String toString() {
		String health = "Employee has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " health insurance plan.";
		return health;
	}
}