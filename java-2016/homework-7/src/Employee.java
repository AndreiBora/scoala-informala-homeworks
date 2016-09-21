
public class Employee {

	private String name;
	private int seriosity;
	private String role;
	private boolean hasParkingSpace;

	public Employee(String name, int seriosity, String role, boolean hasParkingSpace) {
		super();
		this.name = name;
		this.seriosity = seriosity;
		this.role = role;
		this.hasParkingSpace = hasParkingSpace;
	}
	
	public int getSeriosity() {
		return seriosity;
	}

	public boolean getHasParkingSpace() {
		return hasParkingSpace;
	}
	
	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return  name + " role = " + role + " seriosity = " + seriosity ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seriosity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (seriosity != other.seriosity)
			return false;
		return true;
	}
	
}
