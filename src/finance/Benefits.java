package finance;

public abstract class Benefits {
	private int ID;
	private String empFam;
	private String plan;
	
	
	//Constructors
	public Benefits(int i) {
		this.ID = i;
		this.empFam = "nothing";
		this.plan = "nothing";
	}
	
	public Benefits(int i, String empFam, String plan) {
		this.ID = i;
		this.empFam = empFam;
		this.plan = plan;
	}

	
	//Getters and Setters
	public int getID() {
		return ID;
	}
	
	public void setID(int i) {
		this.ID = i;
	}
	
	public String getEmpFam() {
		return empFam;
	}

	public void setEmpFam(String empFam) {
		this.empFam = empFam;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}
}