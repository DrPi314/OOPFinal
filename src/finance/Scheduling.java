package finance;

import java.util.Date;

public class Scheduling extends CompanyStatistics {
	private boolean student;
	private String[] Schedule;
	
	public Scheduling() {
		super();
		this.student = false;
		this.Schedule = null;
	}
	
	public Scheduling(String scheduleName, boolean student) {
		super();
		this.student = student;
		this.Schedule = createSchedule(scheduleName);
	}
	
	public Scheduling(String scheduleName, boolean student, Date startDate, String[] certifications, String[] position) {
		super(startDate, scheduleName, certifications, position);
		this.student = student;
		this.Schedule = createSchedule(scheduleName);
	}

	private String[] createSchedule(String scheduleName) {
		// TODO Create gui for schedule entry, may just be an excel window
		return null;
	}
	
	public String[] getSchedule() {
		return Schedule;
	}
	
	public void setSchedule(String scheduleName) {
		createSchedule(scheduleName);
	}

	public boolean isStudent() {
		return student;
	}

	public void setStudent(boolean student) {
		this.student = student;
	}
	
	
}
