package finance;
import java.util.Date;

public class CompanyStatistics {
	private Date startDate;
	private String scheduleName;
	private String[] certifications;
	private String[] position;
	
	public CompanyStatistics() {
		super();
		this.startDate = null;
		this.scheduleName = null;
		this.certifications = null;
		this.position = null;
	}
	
	public CompanyStatistics(Date startDate, String scheduleName, String[] certifications, String[] position) {
		super();
		this.startDate = startDate;
		this.scheduleName = scheduleName;
		this.certifications = certifications;
		this.position = position;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public String getScheduleName() {
		return scheduleName;
	}
	
	public void setScheduleName(String scheduleName, boolean isStudent) {
		this.scheduleName = scheduleName;
		new Scheduling(scheduleName, isStudent);
	}
	
	//create method for creating and returning certifications
	public String[] getCertifications() {
		return certifications;
	}
	
	public void setCertifications(String[] certifications) {
		this.certifications = certifications;
	}
	
	//create method for creating and returning Position
	public String[] getPosition() {
		return position;
	}
	
	public void setPosition(String[] position) {
		this.position = position;
	}
	
	
	
}
