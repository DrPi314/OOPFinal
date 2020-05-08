package finance;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import javax.swing.*;

public class CertGUI extends JFrame implements ActionListener {
	
	//Local Variables
	private ArrayList<String> certifications = load();
	private int ID;
	
	
	//Components
	private JLabel certLbl = new JLabel("New Certificate:");
	private JTextField certField = new JTextField();
	private JButton addCert = new JButton("Add Certificate");
	private JTextArea display = new JTextArea("Current Certificates:\n" + certifications.toString());
	private JScrollPane displayS = new JScrollPane(display);
	private JPanel entry = new JPanel(new GridLayout(1,3));
	private JPanel window = new JPanel(new BorderLayout());
	
	
	//Constructor
	public CertGUI(String title, int i) {
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
	
	
	//Panel makers
	private void createEntry() {
		entry.add(certLbl);
		entry.add(certField);
		entry.add(addCert);
	}
	
	private void createWindow() {
		window.add(entry, BorderLayout.NORTH);
		window.add(displayS, BorderLayout.CENTER);
	}
	
	
	
	//Listeners and Handlers
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
			save(this.certifications);
		}
	}
	
	
	//file io
		public void save(ArrayList<String> certs) {
			try { 
				BufferedWriter cIn = null;
				String data = "";
				for(String s : certs) {
					data = data + s + ",";
				}
				File file = new File("Certifications.csv");
				if(!file.exists())
					file.createNewFile();
				FileWriter fw = new FileWriter(file);
				cIn = new BufferedWriter(fw);
				cIn.write(data);
				cIn.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public ArrayList<String> load() {
			ArrayList<String> certifications = new ArrayList<String>();
			try {
				BufferedReader cOut = new BufferedReader(new FileReader("Certifications.csv"));
				String[] cert = cOut.readLine().toString().split(",");
				for(String s : cert) {
					certifications.add(new String(s));
				}
				cOut.close();
			} catch (Exception e) {
				e.printStackTrace();
				certifications.add("");
			}
			return certifications;
		}
		
		
		
		//Local toString
		@Override
		public String toString() {
			String c = "";
			for(String s : this.certifications) {
				c = c + s + "\n";
			}
			return c;
		}
}
