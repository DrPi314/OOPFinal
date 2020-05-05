package finance;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SchedulerGUI extends JFrame implements ActionListener {
	private CompanyStatistics stat = new CompanyStatistics();
	private JLabel instruct = new JLabel("Please enter times as \"XXXX\" in 24H format.");
	private JButton submitBtn = new JButton("Update");
	private JTextField[] avail = new JTextField[14];
	private String[] titles = 
		{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private JPanel topRow = new JPanel(new FlowLayout());
	private JPanel entryRow = new JPanel(new GridLayout(2, 7));
	

	

	public SchedulerGUI(String title, int[] sched) {
		super(title);
		setSize(800,160);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		createTopRow();
		createEntryRow(sched);
		add(topRow, BorderLayout.NORTH);
		add(entryRow, BorderLayout.CENTER);
		setListeners();
		setVisible(true);
	}
	
	private void createTopRow() {
		topRow.add(instruct);
		topRow.add(submitBtn);
	}
	
	private void createEntryRow(int[] sched) {
		for(int i = 0; i < 14; i++) {
			entryRow.add(avail[i]);
			avail[i].setText(sched[i] + "");
		}
	}
	
	private void setListeners() {
		submitBtn.addActionListener(this);
		for(int i = 0;i < 14; i++) {
			JTextField a = avail[i];
			a.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e1) {
					a.setText("");
				}
			});
		}		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Update")) {
			stat.setSchedule(createSchedule());
		}
	}
	
	public int[] createSchedule() {
		int[] schedule = new int[14];
		for(int i = 0; i < 14; i++) {
			schedule[i] = Integer.parseInt(avail[i].getText());
			avail[i].setText("");
		}
		return schedule;
	}
	
	public void printSchedule() {
		
	}
}
