package employee;

public class Hourly  {
	private double totalHoursOfWork;
	public boolean Volunteer;

	public Hourly(double totalHourOfWorks, boolean volunteer) {
		this.totalHoursOfWork = totalHourOfWorks;
		this.Volunteer = volunteer;
	}

	public boolean isFullTime() {
		if (totalHoursOfWork >= 40 && !(Volunteer)) {
			return true;
		}
		return false;
	}

	public boolean isPartTime() {
		if (totalHoursOfWork < 40 && !(Volunteer)) {
			return true;
		}
		return false;
	}

	public boolean IsVolunter() {
		if (!(isFullTime()) && !(isPartTime())) {
			return true;
		}
		return false;
	}

}