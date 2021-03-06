package employee;

public class Salary extends Hourly {

	private double rate;

	public Salary(double ratePerHour, double hours, Volunter vol) {
		super(hours, vol);
		this.rate = ratePerHour;

	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getSalary() {
		double salary = super.getTotalHoursOfWork() * rate;
		return salary;
	}

	@Override
	public String toString() {
		return getSalary() + "," + " " + rate;
	}

}
