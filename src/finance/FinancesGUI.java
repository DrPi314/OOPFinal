package finance;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import employee.*;

public class FinancesGUI extends JFrame implements ActionListener {
	
	//Local variables
	private int ID;
	private CompanyStatistics emp;
	private DentalInsurance dent;
	private HealthInsurance heal;
	
	//finances components
	private JButton schedBtn = new JButton("Scheduler");
	private JButton certBtn = new JButton("Certifications");
	private JButton beneBtn = new JButton("Benefits");
	private JTextField IDText;
	private JTextField fNameText;
	private JTextField lNameText;
	private JTextField dateField = new JTextField();
	private JTextField deptField = new JTextField();
	private JTextField posField = new JTextField();
	private JButton submitBtn = new JButton("Submit");
	private JPanel navBar = new JPanel(new FlowLayout());
	 
	
	//Constructor
	public FinancesGUI(String title, int i) {
		super(title);
		setSize(400,100);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		createNavBar();
		addPanelsToFrame();
		setFinancesListeners();
		setVisible(true);
		this.ID = i;
		emp = new CompanyStatistics(i);
		dent = new DentalInsurance(i);
		heal = new HealthInsurance(i);
	}
	
	
	//Panel makers
	private void createNavBar() {
		navBar.add(schedBtn);
		navBar.add(certBtn);
		navBar.add(beneBtn);
	}
	
	private void addPanelsToFrame() {
		add(navBar, BorderLayout.NORTH);
	}
	
	
	//Listeners and handlers
	private void setFinancesListeners() {
		schedBtn.addActionListener(this);
		certBtn.addActionListener(this);
		beneBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Scheduler")) {
			SchedulerGUI scheduler = new SchedulerGUI("Employee # " + this.ID + " Scheduler", ID, emp.getSchedule());
		} else if(callingBtn.equalsIgnoreCase("Certifications")) {
			CertGUI certs = new CertGUI("Employee Certificates", ID);
		} else if(callingBtn.equalsIgnoreCase("Benefits")) {
			BenefitsGUI benefits = new BenefitsGUI("Employee Benefits", ID);
		}
	}

}
