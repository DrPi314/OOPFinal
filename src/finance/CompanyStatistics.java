package finance;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CompanyStatistics {
	private int ID;
	private ArrayList<String> certifications;
	private String[] benefits;
	private int[] schedule;
	
	public CompanyStatistics(int i) {
		this.ID = i;
		this.certifications = null;
		this.benefits = null;
		this.schedule = emptySchedule();
	}
	
	public CompanyStatistics(int i, ArrayList<String> certifications, String[] position, String[] benefits, int[] schedule) {
		this.ID = i;
		this.certifications = certifications;
		this.benefits = benefits;
		this.schedule = schedule;
	}
	
	//create method for creating and returning certifications
	public ArrayList<String> getCertifications() {
		return certifications;
	}
	
	public void addCertifications(String certification) {
		this.certifications.add(certification);
	}
	
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
