package finance;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class SchedulerGUI extends JFrame implements ActionListener {
	
	//Local variables
	private int ID;
	private int[] schedule = new int[14];
	
	//Components
	private JLabel instruct = new JLabel("Please enter times as \"XXXX\" in 24H format.");
	private JButton submitBtn = new JButton("Update");
	private JTextField[] avail = new JTextField[14];
	private String[] titles = 
		{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	private JPanel topRow = new JPanel(new FlowLayout());
	private JPanel entryRow = new JPanel(new GridLayout(2, 7));
	

	//Constructor
	public SchedulerGUI(String title, int i, int[] sched) {
		super(title);
		this.schedule = sched;
		this.ID = i;
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
	
	
	//Panel makers
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
	
	
	//Listeners and Handlers
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
			updateSchedule(this.schedule);

		}
	}
	
	
	//schedule maker
	public int[] createSchedule() {
		int[] schedule = new int[14];
		for(int i = 0; i < 14; i++) {
			schedule[i] = Integer.parseInt(avail[i].getText());
		}
		return schedule;
	}
	
	
	
	//Schedule updater
	public void updateSchedule(int[] s) {
		for(int i = 0; i < 14; i++) {
			avail[i].setText("" + s[i]);
		}
	}
	
	
	//file io
	public void save(int[] schedule) {
		try { 
			this.schedule = createSchedule();
			BufferedWriter sIn = null;
			String data = "";
			for(int i = 0; i < 14; i++) {
				data = data + schedule[i] + ",";
			}
			File file = new File("Schedule.csv");
			if(!file.exists())
				file.createNewFile();
			FileWriter fw = new FileWriter(file);
			sIn = new BufferedWriter(fw);
			sIn.write(data);
			sIn.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int[] load() {
		try {
			BufferedReader sOut = new BufferedReader(new FileReader("Schedule.csv"));
			String[] sc = sOut.readLine().toString().split(",");
			for(int i = 0; i < 14; i++) {
				String limit = sc[i];
				this.schedule[i] = Integer.parseInt(limit);
			}
			sOut.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.schedule;
	}
	
	
	//local toString
	@Override
	public String toString() {
		String sched = null;
		for(int i : this.schedule) {
			sched = sched + "," + i;
		}
		return sched;
	}
}