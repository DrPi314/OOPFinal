package finance;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import employee.*;

public class FinancesGUI extends JFrame implements ActionListener {
	private Benefits bene;
	private EmpNameID empNI;
	
	//finances components
	private JButton schedBtn = new JButton("Scheduler");
	private JTextField IDText = new JTextField(empNI.getID());
	private JTextField fNameText = new JTextField(empNI.getfName());
	private JTextField lNameText = new JTextField(empNI.getlName());
	//private JPanel 
	private JPanel navBar = new JPanel(new FlowLayout());
	 
	
	public FinancesGUI(String title, EmpNameID empNI) {
		super(title);
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		createNavBar();
		addPanelsToFrame();
		setFinancesListeners();
		setVisible(true);
		empNI = new EmpNameID(empNI.getfName(), empNI.getlName(), empNI.getID());
	}
	
	private void createNavBar() {
		navBar.add(schedBtn);
	}
	
	private void addPanelsToFrame() {
		add(navBar, BorderLayout.NORTH);
	}
	
	private void setFinancesListeners() {
		schedBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Scheduler")) {
			CompanyStatistics emp = new CompanyStatistics();
			SchedulerGUI scheduler = new SchedulerGUI("Employee # " + " Scheduler",emp.getSchedule());
		}
	}
	
	
	


}
