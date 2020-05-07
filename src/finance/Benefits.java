package finance;

import employee.*;

public abstract class Benefits {
	private String empFam;
	private String plan;
	
	public Benefits(String empFam, String plan) {
		this.empFam = empFam;
		this.plan = plan;
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