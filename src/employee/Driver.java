package employee;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.println("Please put your full name");
		String name = scan.nextLine();

		NewHire newEmployee = new NewHire(name);

		System.out.println(newEmployee.toString());
		System.out.println("volunteer? true/false");
		boolean volunteer = scan.nextBoolean();
		System.out.println("How many hours are you willing to work per week");
		double totalHours = scan.nextDouble();

		Hourly hours = new Hourly(totalHours, volunteer);
		hours.isFullTime();
		System.out.println(hours.isPartTime());
		System.out.println(hours.isFullTime());
		System.out.println(hours.IsVolunter());

	}

}
