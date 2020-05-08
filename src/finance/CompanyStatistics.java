package finance;

public class CompanyStatistics {
	
	//Local Variables
	private int ID;
	private int[] schedule;
	
	
	//Constructors
	public CompanyStatistics(int i) {
		this.ID = i;
		this.schedule = emptySchedule();
	}
	
	public CompanyStatistics(int i, int[] schedule) {
		this.ID = i;
		this.schedule = schedule;
	}
	
	
	//Maker and getter
	public int[] emptySchedule() {
		int[] schedule = new int[14];
		for(int i = 0; i < 14; i++) {
			schedule[i] = 0;
		}
		return schedule;
	}
	
	public int[] getSchedule() {
		return this.schedule;
	}
	
}
