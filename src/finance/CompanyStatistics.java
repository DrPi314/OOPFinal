package finance;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class CompanyStatistics extends EmpNameID {

	private Date startDate;
	private int[] schedule = {0000,0000,0000,0000,0000,0000,
			0000,0000,0000,0000,0000,0000,0000,0000};
	private ArrayList<String> certifications;
	private String[] position;
	EmpNameID emp;
	
	public CompanyStatistics() {
		super();
		this.startDate = null;
		this.certifications = null;
		this.position = null;
	}
	
	public CompanyStatistics(Date startDate, int[] schedule, ArrayList<String> certifications, String[] position) {
		super();
		this.startDate = startDate;
		this.schedule = schedule;
		this.certifications = certifications;
		this.position = position;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public int[] getSchedule() {
		return schedule;
	}
	
	public void setSchedule(int[] schedule) {
		this.schedule = schedule;
	}
	
	//create method for creating and returning certifications
	public ArrayList<String> getCertifications() {
		return certifications;
	}
	
	public void addCertifications(String certification) {
		this.certifications.add(certification);
	}
	
	//create method for creating and returning Position
	public String[] getPosition() {
		return position;
	}
	
	public void setPosition(String[] position) {
		this.position = position;
	}
	
	
	
}
