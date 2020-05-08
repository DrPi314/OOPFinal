package finance;

public class DentalInsurance extends Benefits {
	
	//Constructors
	public DentalInsurance(int i) {
		super(i);
	}
	
	
	//local toString
	@Override
	public String toString() {
		String dental = "Employee # " + this.getID() + " has chosen to insure " + this.getEmpFam() + " on the " + this.getPlan() + " dental insurance plan.";
		return dental;
	}
	
	
	//string maker for data storage
	public String data() {
		String dental = this.getID() + "," + this.getEmpFam() + "," + this.getPlan();
		return dental;
	}
}
