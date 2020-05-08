package finance;

public class HealthInsurance extends Benefits{
	
	//Constructor
	public HealthInsurance(int i) {
		super(i);
	}
	
	
	//Local toString
	@Override
	public String toString() {
		String health = "Employee # " + this.getID() + " has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " health insurance plan.";
		return health;
	}
	
	
	//string maker for data storage
	public String data() {
		String health = this.getID() + "," + this.getEmpFam() + "," + this.getPlan();
		return health;
	}
}