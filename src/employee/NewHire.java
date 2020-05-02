package employee;

public class NewHire extends Employee {
	private String name;

	public NewHire(String name) {
		super(name);

	}

	@Override
	public String toString() {
		return "NewEmployee [name=id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
