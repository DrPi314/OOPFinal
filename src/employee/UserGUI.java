package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import finance.FinancesGUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JComboBox;
import finance.*;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private JTextField idTextField;
	private JTextArea userTextArea;
	private JButton logButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI("User");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserGUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JLabel firstNameLabel = new JLabel("FirstName");
		panel.add(firstNameLabel);

		firstTextField = new JTextField();
		panel.add(firstTextField);
		firstTextField.setColumns(10);

		JLabel lastLabel = new JLabel("LastName");
		panel.add(lastLabel);

		lastTextField = new JTextField();
		panel.add(lastTextField);
		lastTextField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID");
		panel.add(lblNewLabel_1);

		idTextField=new JTextField();
		panel.add(idTextField);
		idTextField.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		logButton = new JButton("Log in");
		logButton.addActionListener(new Action());
		panel_1.add(logButton, BorderLayout.NORTH);

		userTextArea = new JTextArea();
		panel_1.add(userTextArea, BorderLayout.CENTER);
	}

	// class for Action
	private class Action implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == logButton) {
				try {
					user();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}

		}
	}

	// this a method that when u click log in is invoke
	private void user() throws IOException {
		// getting info from user
		String FName = firstTextField.getText();
		String lName = lastTextField.getText();
		String idString = idTextField.getText();
		int id= Integer.parseInt(idString);
		// creating arrayList and addding all the info we get from user
		ArrayList<String> individuals = new ArrayList<String>();
		individuals.add(FName);
		individuals.add(lName);
		individuals.add(idString);
		// file path
		String filePath = ("EmployeeDocuments.csv");
		// method that gonna check if the user info matched our record and return true
		// if matches
		readRecord(filePath, FName, lName, idString);

		boolean userValid = readRecord(filePath, FName, lName, idString);
		// if return true we show their benefits and etc
		if (userValid) {
			FinancesGUI f = new FinancesGUI("finance",id);
			f.setVisible(true);

		}

		else
			JOptionPane.showMessageDialog(null, "Employee not found");

	}

	// method will open the file and find if the input match what in the file.

	private boolean readRecord(String filePath, String firstName, String LastName, String id) throws IOException {
		boolean found = false;
		ArrayList<String> string = new ArrayList<String>();
		File file = new File(filePath);
		Scanner scan = new Scanner(file);
		scan.useDelimiter(";");
		while (scan.hasNext()) {
			string.add(scan.next());
		}
		scan.close();
		for (String persons : string) {
			if (persons.contains(firstName) && persons.contains(LastName) && persons.contains(id))
				found = true;
		}

		return found;

	}

}
