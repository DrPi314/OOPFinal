package finance;

public class Tax {
	private char filingStatus;
	private int numDeductions;
	private String[] taxTable = createTaxTable();
	
	public Tax() {
		super();
		this.filingStatus = 0;
		this.numDeductions = 0;
	}
	
	public Tax(char filingStatus, int numDeductions) {
		super();
		this.filingStatus = filingStatus;
		this.numDeductions = numDeductions;
	}

	public char getFilingStatus() {
		return filingStatus;
	}

	public void setFilingStatus(char filingStatus) {
		this.filingStatus = filingStatus;
	}

	public int getNumDeductions() {
		return numDeductions;
	}

	public void setNumDeductions(int numDeductions) {
		this.numDeductions = numDeductions;
	}
	
	public String[] createTaxTable() {
		//code for taxTable here
		return taxTable;
	}

}