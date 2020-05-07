package finance;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class CertGUI extends JFrame implements ActionListener {
	private ArrayList<String> certifications;
	
	private JLabel certLbl = new JLabel("New Certificate:");
	private JTextField certField = new JTextField();
	private JButton addCert = new JButton("Add Certificate");
	private JTextArea display = new JTextArea("Current Certificates:\n");
	private JPanel entry = new JPanel(new GridLayout(1,3));
	private JPanel window = new JPanel(new BorderLayout());
	
	public CertGUI(String title, ArrayList<String> certifications) {
		super(title);
		setSize(100,80);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		createEntry();
		createWindow();
		add(window);
		setListeners();
		setVisible(true);
		this.certifications = certifications;
		for(String s : certifications)
			display.append(s + "\n");
	}
	
	private void createEntry() {
		entry.add(certLbl);
		entry.add(certField);
		entry.add(addCert);
	}
	
	private void createWindow() {
		window.add(entry, BorderLayout.NORTH);
		window.add(display);
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
