package employee;


public class Hourly {
	protected double totalHoursOfWork;
	private Volunter volunter;

	public Hourly(double totalHourOfWorks, Volunter volter) {
		this.totalHoursOfWork = totalHourOfWorks;
		this.volunter=volter;
		
	}
	
	
	

	public boolean isFullTime() {
		if (totalHoursOfWork >= 40 && !(volunter.isVolunteer())) {
			return true;
		}
		return false;
	}

	public boolean isPartTime() {
		if (totalHoursOfWork < 40 && !(volunter.isVolunteer())) {
			return true;
		}
		return false;
	}

	public boolean IsVolunter() {
		if (!(isFullTime()) && !(isPartTime())) {
			return true;
		}
		return false;
	}public double getTotalHoursOfWork() {
		return totalHoursOfWork;
	}

	public void setTotalHoursOfWork(double totalHoursOfWork) {
		this.totalHoursOfWork = totalHoursOfWork;
	}

	public Volunter getVolunter() {
		return volunter;
	}

	public void setVolunter(Volunter volunter) {
		this.volunter = volunter;
	}

	@Override
	public String toString() {
		return "Hourly [totalHoursOfWork=" + totalHoursOfWork + ", volunter=" + volunter + "]";
	}

	

	
	


}

