package finance;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import employee.*;

public class FinancesGUI extends JFrame implements ActionListener {
	private Benefits bene;
//	private EmpNameID empNI;
	private CompanyStatistics emp;
	
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
	//private JPanel 
	private JPanel navBar = new JPanel(new FlowLayout());
	 
	
	public FinancesGUI(String title) {
		super(title);
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		createNavBar();
		addPanelsToFrame();
		setFinancesListeners();
		setVisible(true);
//		IDText = new JTextField(empNI.getID());
//		fNameText = new JTextField(empNI.getfName());
//		lNameText = new JTextField(empNI.getlName());
//		empNI = new EmpNameID(empNI.getlName(), empNI.getfName(), empNI.getID());
		this.emp = new CompanyStatistics();
	}
	
	private void createNavBar() {
		navBar.add(schedBtn);
		navBar.add(certBtn);
		navBar.add(beneBtn);
	}
	
	private void addPanelsToFrame() {
		add(navBar, BorderLayout.NORTH);
	}
	
	private void setFinancesListeners() {
		schedBtn.addActionListener(this);
		certBtn.addActionListener(this);
		beneBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Scheduler")) {
			SchedulerGUI scheduler = new SchedulerGUI("Employee Scheduler",this.emp.getSchedule());
		} else if(callingBtn.equalsIgnoreCase("Certifications")) {
			CertGUI certs = new CertGUI("Employee Certificates", this.emp.getCertifications());
		} else if(callingBtn.equalsIgnoreCase("Benefits")) {
			BenefitsGUI benefits = new BenefitsGUI("Employee Benefits");
		}
	}
	
	
	


}
