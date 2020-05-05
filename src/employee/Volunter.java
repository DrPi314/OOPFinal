package employee;

public class Volunter {
	private boolean volunteer;
	
	public Volunter(boolean volunteer) {
		this.volunteer=volunteer;
	}

	

	public boolean isVolunteer() {
		return volunteer;
	}

	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}
	
	@Override
	public String toString() {
		return  volunteer + "";
	}

}
