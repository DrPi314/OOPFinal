package finance;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class BenefitsGUI extends JFrame implements ActionListener {
	
	//Local variables
	private String[] empFamA = {"Employee", "Employee + Spouse", "Family"};
	private String[] planA = {"Plan 1", "Plan 2", "Plan 3"};
	private DentalInsurance dental;
	private HealthInsurance health;
	private int ID;
	
	
	//Components
	private JLabel empFamL = new JLabel("Type of coverage:");
	private JComboBox empFam = new JComboBox(empFamA);
	private JLabel planL = new JLabel("Plan Choice:");
	private JComboBox planC = new JComboBox(planA);
	private JButton addHealth = new JButton("Add Health Plan");
	private JButton addDental = new JButton("Add Dental Plan");
	private JButton submitBtn = new JButton("Submit");
	private JTextArea planInfo = new JTextArea("Plan Information:");
	private JPanel choicePanel = new JPanel(new GridLayout(2,2));
	private JPanel submitPanel = new JPanel(new FlowLayout());
	private JPanel topPanel = new JPanel(new BorderLayout());
	private JPanel displayPanel = new JPanel(new BorderLayout());
	
	
	//Constructor
	public BenefitsGUI(String title, int i) {
		super(title);
		this.ID = i;
		this.dental = new DentalInsurance(i);
		this.health = new HealthInsurance(i);
		setSize(500,200);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		createChoice();
		createSubmit();
		createDisplay();
		createTop();
		addPanelsToFrame();
		setListeners();
		setVisible(true);
	}
	
	
	//Panel makers
	private void createChoice() {
		choicePanel.add(empFamL);
		choicePanel.add(empFam);
		choicePanel.add(planL);
		choicePanel.add(planC);
	}
	
	private void createSubmit() {
		submitPanel.add(addHealth);
		submitPanel.add(addDental);
		submitPanel.add(submitBtn);
	}
	
	private void createTop() {
		topPanel.add(choicePanel, BorderLayout.NORTH);
		topPanel.add(submitPanel, BorderLayout.SOUTH);
	}
	
	private void createDisplay() {
		load();
		planInfo.append("\n" + dental.toString());
		planInfo.append("\n" + health.toString());
		displayPanel.add(planInfo, BorderLayout.CENTER);
	}
	
	private void addPanelsToFrame() {
		add(topPanel, BorderLayout.NORTH);
		add(displayPanel, BorderLayout.CENTER);
	}
	
	
	//Listeners and handlers
	private void setListeners() {
		addHealth.addActionListener(this);
		addDental.addActionListener(this);
		submitBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Add Health Plan")) {
			int i = health.getID();
			String empFam = this.empFam.getSelectedItem().toString();
			String plan = this.planC.getSelectedItem().toString();
			health.setID(i);
			health.setEmpFam(empFam);
			health.setPlan(plan);
			String benefits = health.toString() + "\n" + dental.toString();
			planInfo.setText(benefits);
		} else if(callingBtn.equalsIgnoreCase("Add Dental Plan")) {
			int i = dental.getID();
			String empFam = this.empFam.getSelectedItem().toString();
			String plan = this.planC.getSelectedItem().toString();
			dental.setID(i);
			dental.setEmpFam(empFam);
			dental.setPlan(plan);
			String benefits = health.toString() + "\n" + dental.toString();
			planInfo.setText(benefits);
		} else if(callingBtn.equalsIgnoreCase("Submit")) {
			String benefitsD = health.data() + "," + dental.data();
			save(benefitsD);
			String benefits = health.toString() + "\n" + dental.toString();
			planInfo.setText(benefits);
		}
	}	
	
	
	//file io
	public void save(String benefits) {
		try { 
			BufferedWriter b = new BufferedWriter(new FileWriter("Benefits.csv"));
			b.append(benefits);
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void load() {
		try {
			BufferedReader b = new BufferedReader(new FileReader("Benefits.csv"));
			String benefit = b.readLine();
			String[] benefits = benefit.split(",");
			int ID = Integer.parseInt(benefits[0]);
			String healthEF = benefits[1].toString();
			String dentalEF = benefits[4].toString();
			String healthP = benefits[2].toString();
			String dentalP = benefits[5].toString();
			this.dental.setID(ID);
			this.dental.setEmpFam(dentalEF);
			this.dental.setPlan(dentalP);
			health.setID(ID);
			health.setEmpFam(healthEF);
			health.setPlan(healthP);
			b.close();
		} catch (IOException e) {
			e.printStackTrace();
			dental = new DentalInsurance(ID);
			health = new HealthInsurance(ID);
		}
	}
}
