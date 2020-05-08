package employee;

import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import finance.FinancesGUI;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import finance.*;

public class EmployeeGUI extends JFrame implements ActionListener {
	private NewHire newEmp;

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
	private JSpinner spin;
	private Date todaysDate = new Date();
	private PrintWriter output;

	// this method will return arraylist for the IDs
	private ArrayList<Integer> myIDs() {
		ArrayList<Integer> numbers = new ArrayList<Integer>(5);
		numbers.add(01001);
		numbers.add(02002);
		numbers.add(03003);
		numbers.add(04004);
		numbers.add(05005);

		return (numbers);
	}

	// Assign ArrayId to to myIDS arrayList so we can pass it to idComboBox
	Integer[] arrayID = myIDs().toArray(new Integer[myIDs().size()]);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeGUI frame = new EmployeeGUI("New Employee");
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
	public EmployeeGUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
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
		// Creating spinner that will the date and increment by a day
		spin = new JSpinner(new SpinnerDateModel(todaysDate, null, null, Calendar.DAY_OF_MONTH));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spin, "MM/dd/yyyy");
		spin.setEditor(dateEditor);
		panel.add(spin);

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

	// this method will handle all actions for buttons

	public void actionPerformed(ActionEvent e) {
		String callingBtn = e.getActionCommand();
		if (callingBtn.equalsIgnoreCase("Clear")) {
			console.setText("");

		} else if (callingBtn.equalsIgnoreCase("Display")) {

			for (int i = 0; i < employeesList.size(); i++) {
				console.append("******** Employee " + (i + 1) + " **********\n");
				console.append("" + employeesList.get(i) + "\n");
			}
		} else if (callingBtn.equalsIgnoreCase("Submit"))

		{
			newEmployee();


		} 
		}

		

	

	// method that will match yes and no to true and false respectively
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

	// Define the method that check if id is took or not.
	public int getId(int id) {
		for (int i = 0; i < arrayID.length; i++) {
			if (arrayID[i].equals(id)) {
				return i;
			}
		}
		return -1;
	}

	// Define the method create newEmployee
	public void newEmployee() {
		// getting inputs from swing and assigned into variables
		try {
			String firstName = firstNameTextField.getText();
			String lastName = lastNameTextField.getText();
			String idString = idComboBox.getSelectedItem().toString();
			int id = Integer.parseInt(idString);
			// this variable will hold what getId return
			int checkId = getId(id);
			String gender = genderBox.getSelectedItem().toString();
			String department = departmentTextField.getText();
			Date dateStart = (Date) spin.getValue();
			int age = validAge(Integer.parseInt(ageTextField.getText()));
			String yes_no = (box.getSelectedItem().toString());
			boolean volunter = checkOptions(yes_no);
			double rate = Double.parseDouble(rateTextField.getText());
			double totalHours = Double.parseDouble(hoursTextField.getText());
			// checking and validating the input
			boolean error = false;
			String empty = "";
			if (firstName.equals("") || lastName.equals(empty) || department.equals(empty)) {

				error = true;
				JOptionPane.showMessageDialog(this, "Empty space", "Errors Occured", JOptionPane.ERROR_MESSAGE);
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

			// this checks that the input of TextField is letters.
			String regex = "[a-zA-Z]+";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(firstName);
			boolean result = matcher.matches();
			String regex2 = "[a-zA-Z]+";
			Pattern pattern2 = Pattern.compile(regex2);
			Matcher matcher2 = pattern2.matcher(lastName);
			boolean result2 = matcher2.matches();
			String regex3 = "[a-zA-Z]+";
			Pattern pattern3 = Pattern.compile(regex3);
			Matcher matcher3 = pattern3.matcher(department);
			boolean result3 = matcher3.matches();

			// deciding if ID is took or no, based on what getID method return
			if (checkId == -1) {
				empty += "Sorry ID has been toke!\n";
				error = true;

			}
			// validation of TextField (letters only)
			if (!(result) || !(result2) || !(result3)) {

				error = true;
				JOptionPane.showMessageDialog(this, "Only Letters", "Errors Occured", JOptionPane.ERROR_MESSAGE);
			}

			if (error) {
				JOptionPane.showMessageDialog(this, empty, "Errors Occured", JOptionPane.ERROR_MESSAGE);

			}

			else {
				// adding new Employee to the arrayList

//<<<<<<< HEAD
				//newEmp = new NewHire(id, firstName, lastName, gender, department, dateStart, age);
//=======
				NewHire newEmp = new NewHire(firstName, lastName, id, gender, department, dateStart, age);
//>>>>>>> 555ebd19777906ab788d9b6de2c76858edd54bd5

				Volunter volunterObject = new Volunter(volunter);
				Hourly hourly = new Hourly(totalHours, volunterObject);
				Salary salary = new Salary(rate, totalHours, volunterObject);
				Employee emp = new Employee(newEmp, hourly, salary);
				employeesList.add(emp);
				arrayID[checkId] = -1;
				console.append("Reservation completed for " + firstName + "!\n");
				JOptionPane.showMessageDialog(this, "Employee has been add", "Success",
						JOptionPane.INFORMATION_MESSAGE);
				// creating Excel file to save the data from user
				output = CreateFile("EmployeeDocuments.csv");
				// String Builder will our header in the Excel File
				StringBuilder sb = new StringBuilder();
				sb.append("firstName");
				sb.append(',');
				sb.append("LastName");
				sb.append(',');
				sb.append("ID");
				sb.append(',');
				sb.append("AGE");
				sb.append(',');
				sb.append("Gender");
				sb.append(',');
				sb.append("Department");
				sb.append(',');
				sb.append("Date");
				sb.append(',');
				sb.append("Hours");
				sb.append(',');
				sb.append("Volunter");
				sb.append(',');
				sb.append("Salary");
				sb.append(',');
				sb.append("Rate");
				sb.append(',');
				output.println(sb);
				for (Employee person : employeesList) {
					// calling this method
					createEmployee(person, output);

				}
				output.flush();
				output.close();

			}

		} catch (Exception e) {
			e.getMessage();
			JOptionPane.showMessageDialog(this, "Invalid input", "Errors Occured", JOptionPane.ERROR_MESSAGE);
		}

	}

	// method that write all the detail on the Excel file
	private void createEmployee(Employee person, PrintWriter output) {
		String detail = person.getNewEmp() + "," + person.getTime() + "," + person.getSalary();
		output.println(detail);

	}

	// method that create the Excel File
	private PrintWriter CreateFile(String filePath) {
		try {
			FileWriter employeeList = new FileWriter(filePath);
			BufferedWriter bw = new BufferedWriter(employeeList);
			PrintWriter infoToWrite = new PrintWriter(bw);
			return infoToWrite;
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		return null;

	}

}
