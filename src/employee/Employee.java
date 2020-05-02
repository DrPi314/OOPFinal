package employee;

public class Employee {
	private long id;
	private String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Employee() {

	}
// constructor for new employee
	public Employee(String name) {
		this.name = name;
		id = (int) ((Math.random() * 1000000000));
	}

	public long getId() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [ name=" + name + "]";
	}

}
