package finance;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

public class SchedulerGUI extends JFrame implements ActionListener {
	private int ID;
	private int[] schedule = new int[14];
	private JLabel instruct = new JLabel("Please enter times as \"XXXX\" in 24H format.");
	private JButton submitBtn = new JButton("Update");
	private JTextField[] avail = new JTextField[14];
	private String[] titles = 
		{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private JPanel topRow = new JPanel(new FlowLayout());
	private JPanel entryRow = new JPanel(new GridLayout(2, 7));
	

	

	public SchedulerGUI(String title, int i, int[] sched) {
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
		this.schedule = sched;
		this.ID = i;
	}
	
	private void createTopRow() {
		topRow.add(instruct);
		topRow.add(submitBtn);
	}
	
	private void createEntryRow(int[] sched) {
		load();
		for(int i = 0; i < 14; i++) {
			avail[i] = new JTextField("" + sched[i]);
			entryRow.add(avail[i]);
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
			createSchedule();
			save(schedule);
			createEntryRow(schedule);
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
	
	public void save(int[] schedule) {
		try { 
			BufferedWriter s = new BufferedWriter(new FileWriter("Schedule.csv"));
			s.write(schedule.toString());
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] load() {
		try {
			Scanner s = new Scanner(new FileReader("Schedule.csv"));
			String[] sc = s.toString().split(",");
			for(int i = 0; i < 14; i++) {
				this.schedule[i] = Integer.parseInt(sc[i]);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.schedule;
	}
	
	@Override
	public String toString() {
		String sched = null;
		for(int i : this.schedule) {
			sched = sched + "," + i;
		}
		return sched;
	}
}