package finance;

import employee.*;

public class EmpNameID {
	private String fName;
	private String lName;
	private int ID;
	
	public EmpNameID( String fn, String ln,int id) {
		this.fName = fn;
		this.lName = ln;
		this.ID = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	
}
