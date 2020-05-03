package employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField hoursTextField;
	private JTextField departmentTextField;
	private JTextField yearTextField;
	private JTextField ageTextField;
	private JTextField rateTextField;
	private String[] options = { "YES", "NO" };
	private String[] genderOptions = { "Other", "Male", "Female" };
	private JComboBox idComboBox;

	// method for the ArrayId. we will use this method inside idCombox
	private ArrayList<Integer> myIDs() {
		ArrayList<Integer> numbers = new ArrayList<Integer>(5);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		return (numbers);
	}

	Integer[] arrayID = myIDs().toArray(new Integer[myIDs().size()]);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI frame = new EmployeeGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the employeelist.
	ArrayList<Employee> employeesList;
	private JTextArea console;
	private JComboBox box;
	private JComboBox genderBox;

	/**
	 * Create the frame.
	 */
	public EmployeeGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		// define employee list
		employeesList = new ArrayList<Employee>();
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 2, 0, 0));

		JLabel firstNameLabel = new JLabel("First Name");
		panel.add(firstNameLabel);

		firstNameTextField = new JTextField();
		panel.add(firstNameTextField);
		firstNameTextField.setColumns(10);

		JLabel lastNameLabel = new JLabel("Last Name");
		panel.add(lastNameLabel);

		lastNameTextField = new JTextField();
		panel.add(lastNameTextField);
		lastNameTextField.setColumns(10);

		JLabel idLabel = new JLabel("ID");
		panel.add(idLabel);

		idComboBox = new JComboBox(arrayID);
		panel.add(idComboBox);

		JLabel genderLabel = new JLabel("Gender");
		panel.add(genderLabel);

		genderBox = new JComboBox(genderOptions);
		panel.add(genderBox);

		JLabel DepartmentLabel = new JLabel("Department");
		panel.add(DepartmentLabel);

		departmentTextField = new JTextField();
		panel.add(departmentTextField);
		departmentTextField.setColumns(10);

		JLabel startDateLabel = new JLabel("Start Date");
		panel.add(startDateLabel);

		yearTextField = new JTextField();
		panel.add(yearTextField);
		yearTextField.setColumns(10);
		// Set the content place holder for depature Date.
		yearTextField.setText("MM/DD/YYYY");

		JLabel ageLabel = new JLabel("Age");
		panel.add(ageLabel);

		ageTextField = new JTextField();
		panel.add(ageTextField);
		ageTextField.setColumns(10);

		JLabel volunterLabel = new JLabel("Volunter");
		panel.add(volunterLabel);

		box = new JComboBox(options);
		panel.add(box);

		JLabel hoursLabel = new JLabel("Hours");
		panel.add(hoursLabel);

		hoursTextField = new JTextField();
		panel.add(hoursTextField);
		hoursTextField.setColumns(10);

		JLabel rateLabel = new JLabel("Rate");
		panel.add(rateLabel);

		rateTextField = new JTextField();
		panel.add(rateTextField);
		rateTextField.setColumns(10);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JPanel actionPane = new JPanel();
		panel_3.add(actionPane, BorderLayout.NORTH);
		actionPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton displayButton = new JButton("Display");
		displayButton.addActionListener(this);

		JButton addButton = new JButton("Submit");
		addButton.addActionListener(this);

		actionPane.add(addButton);
		actionPane.add(displayButton);

		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(this);
		actionPane.add(clearButton);

		console = new JTextArea();
		JScrollPane pane = new JScrollPane(console);

		panel_3.add(pane, BorderLayout.CENTER);
	}

	// handle all actions for buttons

	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if (callingBtn.equalsIgnoreCase("Clear")) {
			console.setText("");

		} else if (callingBtn.equalsIgnoreCase("Display")) {

			for (int i = 0; i < employeesList.size(); i++) {
				console.append("******** Employee " + (i + 1) + " **********\n");
				console.append("" + employeesList.get(i));
			}
		} else if (callingBtn.equalsIgnoreCase("Submit"))

		{
			newEmployee();

		}
	}

	// method that will match  yes and no to  true and false respectively 
	public boolean checkOptions(String yes) {
		if (yes.equalsIgnoreCase("Yes"))
			return true;
		else
			return false;
	}

	// method to check the age of the employee
	public int validAge(int age) {
		if (age < 18) {
			return 0;
		} else
			return age;

	}

	// Define the method create newEmployee
	public void newEmployee() {
		// getting inputs from swing and assigned into variables
		try {
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String idString = idComboBox.getSelectedItem().toString();
			int id = Integer.parseInt(idString);
			String gender = genderBox.getSelectedItem().toString();
			String department = departmentTextField.getText();
			String dateStart = yearTextField.getText();
			int age = validAge(Integer.parseInt(ageTextField.getText()));
			String yes_no = (box.getSelectedItem().toString());
			boolean volunter = checkOptions(yes_no);
			double rate = Double.parseDouble(rateTextField.getText());
			double totalHours = Double.parseDouble(hoursTextField.getText());
			// checking and validating the input
			boolean error = false;
			String empty = "";
			if (firstName.equals("") || lastName.equals(empty) || department.equals(empty)) {
				empty += " a text field is Empty";
				error = true;
			}
			if (age == 0) {
				error = true;
				JOptionPane.showMessageDialog(this, "must be 18 or Older", "Errors Occured", JOptionPane.ERROR_MESSAGE);
			}
			if (totalHours < 0) {
				error = true;
				JOptionPane.showMessageDialog(this, "Hours can not be negative", "Errors Occured",
						JOptionPane.ERROR_MESSAGE);
			}

			// this checks that the input of textfield is letters.
			String regex = "[a-zA-Z]+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(firstName);
			boolean result = matcher.matches();
			System.out.println(result);
			String regex2 = "[a-zA-Z]+";
			Pattern pattern2 = Pattern.compile(regex2);
			Matcher matcher2 = pattern2.matcher(lastName);
			boolean result2 = matcher2.matches();
			System.out.println(result2);
			String regex3 = "[a-zA-Z]+";
			Pattern pattern3 = Pattern.compile(regex3);
			Matcher matcher3 = pattern3.matcher(department);
			boolean result3 = matcher3.matches();
			System.out.println(result3);

			if (!(result) || !(result2) || !(result3)) {

				error = true;
				JOptionPane.showMessageDialog(this, "Only Letters", "Errors Occured", JOptionPane.ERROR_MESSAGE);
			}
			// Date setting and formating
			String date[] = dateStart.split("/");
			SimpleDateFormat forM = new SimpleDateFormat("MM/dd/yyyy");
			String stringDate = date[0] + "/" + date[1] + "/" + date[2];
			Date dateHolder = null;
			dateHolder = forM.parse(stringDate);

			if (error) {
				JOptionPane.showMessageDialog(this, empty, "Errors Occured", JOptionPane.ERROR_MESSAGE);

			} else {
				// adding new passenger to the array
				NewHire newEmp = new NewHire(firstName, lastName, gender, department, dateHolder, id, age);
				Volunter volunterObject = new Volunter(volunter);
				Hourly hourly = new Hourly(totalHours, volunterObject);
				Salary salary = new Salary(rate, totalHours, volunterObject);
				Employee emp = new Employee(newEmp, hourly, salary);
				employeesList.add(emp);
				console.append("Reservation completed for " + firstName + "!\n");

			}
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e);
			JOptionPane.showMessageDialog(this, "Invalid input", "Errors Occured", JOptionPane.ERROR_MESSAGE);
		}

	}

}
