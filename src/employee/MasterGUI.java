package employee;
import finance.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import demographic.*;

public class MasterGUI extends JFrame{
	private JPanel topPanel;
	private JButton newEmployee,user;
	//,MiddlePanel,bottomPanel;
	public static void main(String[] args) {
		try {
		MasterGUI mg=new MasterGUI();
		mg.setVisible(true);
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	} // end of Main Function
	public MasterGUI() {
	this.setLocationRelativeTo(null);
	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setTitle("Main");
	newEmployee= new JButton("New");
	newEmployee.addActionListener(new ActionL());
	topPanel=new JPanel();
	user =new JButton("Employee");
	user.addActionListener(new ActionL());
	topPanel.add(newEmployee);
	topPanel.add(user);
	this.add(topPanel);
	
	this.setVisible(true);
	
	
	}// main Constructor
	
	
	private class ActionL implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==newEmployee) {
				EmployeeGUI employee= new EmployeeGUI();
				employee.setVisible(true);
				
			}
			
			else if (e.getSource()==user) {
				System.out.println("wow");
				
			}
			
		}
		
	}
	
	
	
	
	
	
	
} // end of masterGUI
