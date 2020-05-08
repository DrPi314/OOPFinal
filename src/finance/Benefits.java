package finance;

import java.io.*;

import employee.*;

public abstract class Benefits {
	private String benefits;
	private int ID;
	private String empFam;
	private String plan;
	
	public Benefits(int i) {
		this.ID = i;
		this.empFam = null;
		this.plan = null;
	}
	
	public Benefits(int i, String empFam, String plan) {
		this.ID = i;
		this.empFam = empFam;
		this.plan = plan;
	}

	public int getID() {
		return ID;
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