package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JComboBox;

public class UserGUI extends JFrame {

	private JPanel contentPane;
	private JTextField firstTextField;
	private JTextField lastTextField;
	private String[] id = { "1", "2", "3", "4", "5" };
	private JComboBox comboBox;
	private JTextArea userTextArea;
	private JButton logButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
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
	public UserGUI() {
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

		comboBox = new JComboBox(id);
		panel.add(comboBox);

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
				user();
				

			}

		}
	}

	private void user() {
		String FName = firstTextField.getName();
		String lName = lastTextField.getName();
		String idString = (String) comboBox.getSelectedItem();

		String filePath = ("C:\\Users\\abshi\\Desktop\\Project\\OOPFinal\\src\\EmployeeDocuments.csv");
		readRecord(FName, lName, idString, filePath);

	}

	// method will open the file and find if the input match what in the file.

	private void readRecord(String searchTerm, String lastname, String idSearch, String filePath) {
		boolean found = false;
		String f, l, id, age, dep, date, hr, vl, salary, rate;

		try {
			File file = new File(filePath);
			Scanner scan = new Scanner(file);
			scan.useDelimiter(",\n");
			while (scan.hasNext() && !found) {
				f = scan.next();
				l = scan.next();
				id = scan.next();
				age = scan.next();
				dep = scan.next();
				date = scan.next();
				hr = scan.next();
				vl = scan.next();
				salary = scan.next();
				rate = scan.next();

				if (f.equalsIgnoreCase(searchTerm) && l.equalsIgnoreCase(lastname) && id.equalsIgnoreCase(idSearch)) {
					found = true;

				}

			}

			if (found) {
				userTextArea.append("found");
				JOptionPane.showMessageDialog(null,
						"FirstName: " + searchTerm + "LastName: " + lastname + "ID: " + idSearch);

			} else
				JOptionPane.showMessageDialog(null, "The user not found");

		}

		catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		}

	}

}
