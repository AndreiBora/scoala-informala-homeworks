import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		CompanyManagementSystem cms = new CompanyManagementSystem();
		cms.addEmployee(new Employee("Jhon",1,"junior",false));
		cms.addEmployee(new Employee("Maria",2,"junior",true));
		cms.addEmployee(new Employee("Kim",7,"senior",true));
		cms.addEmployee(new Employee("Ryan",5,"senior",false));
		cms.addEmployee(new Employee("Mike",10,"manager",true));
		
		List<Employee> employeeNoParkingSpace = new ArrayList<>();
		employeeNoParkingSpace = cms.getList();
		System.out.println("Employees without parking space ");
		System.out.println(employeeNoParkingSpace);
			
	}
}	
