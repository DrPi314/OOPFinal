package finance;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class CertGUI extends JFrame implements ActionListener {
	private ArrayList<String> certifications = new ArrayList<String>();
	private int ID;
	
	private JLabel certLbl = new JLabel("New Certificate:");
	private JTextField certField = new JTextField();
	private JButton addCert = new JButton("Add Certificate");
	private JTextArea display = new JTextArea("Current Certificates:\n");
	private JScrollPane displayS = new JScrollPane(display);
	private JPanel entry = new JPanel(new GridLayout(1,3));
	private JPanel window = new JPanel(new BorderLayout());
	
	public CertGUI(String title, int i, ArrayList<String> c) {
		super(title);
		setSize(400,160);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLayout(new FlowLayout());
		setLocationRelativeTo(null);
		createEntry();
		createWindow();
		add(window);
		setListeners();
		setVisible(true);
		this.ID = i;
	}
	
	private void createEntry() {
		entry.add(certLbl);
		entry.add(certField);
		entry.add(addCert);
	}
	
	private void createWindow() {
		window.add(entry, BorderLayout.NORTH);
		window.add(displayS, BorderLayout.CENTER);
	}
	
	private void setListeners() {
		addCert.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if(callingBtn.equalsIgnoreCase("Add Certificate")) {
			String newCert = certField.getText();
			certifications.add(newCert);
			display.append(newCert + "\n");
		}
	}
}
