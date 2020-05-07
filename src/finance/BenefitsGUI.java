package finance;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class BenefitsGUI extends JFrame implements ActionListener {
	private String[] benefits;
	private String[] empFamA = {"Employee", "Employee + Spouse", "Family"};
	private String[] planA = {"Plan 1", "Plan 2", "Plan 3"};
	
	private JLabel empFamL = new JLabel("Type of coverage:");
	private JComboBox empFam = new JComboBox(empFamA);
	private JLabel planL = new JLabel("Plan Choice");
	private JComboBox planC = new JComboBox(planA);
	private JButton addHealth = new JButton("Add Health Plan");
	private JButton addDental = new JButton("Add Dental Plan");
	private JTextArea planInfo = new JTextArea("Plan Information:");
	private JPanel choicePanel = new JPanel(new GridLayout(2,2));
	private JPanel submitPanel = new JPanel(new FlowLayout());
	private JPanel displayPanel = new JPanel(new BorderLayout());
	
	public BenefitsGUI(String title) {
		super(title);
		setSize(400,200);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		createChoice();
		createSubmit();
		createDisplay();
		addPanelsToFrame();
		setListeners();
		setVisible(true);
	}
	
	private void createChoice() {
		choicePanel.add(empFamL);
		choicePanel.add(empFam);
		choicePanel.add(planL);
		choicePanel.add(planC);
	}
	
	private void createSubmit() {
		submitPanel.add(addHealth);
		submitPanel.add(addDental);
	}
	
	private void createDisplay() {
		displayPanel.add(planInfo, BorderLayout.CENTER);
	}
	
	private void addPanelsToFrame() {
		add(choicePanel);
		add(submitPanel);
		add(displayPanel);
	}
	
	private void setListeners() {
		addHealth.addActionListener(this);
		addDental.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Add Health Insurance")) {
			String empFam = this.empFam.getSelectedItem().toString();
			String plan = this.planC.getSelectedItem().toString();
			HealthInsurance health = new HealthInsurance(empFam, plan);
		} else if(callingBtn.equalsIgnoreCase("Add Dental Insurance")) {
			String empFam = this.empFam.getSelectedItem().toString();
			String plan = this.planC.getSelectedItem().toString();
			DentalInsurance health = new DentalInsurance(empFam, plan);
		}
	}
}
