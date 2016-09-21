import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompanyManagementSystemTest {
	@Test(expected=IllegalArgumentException.class)
	public void CompanyManagementSystemPassingNoEmployeeTest() {
		// given
		CompanyManagementSystem cms = new CompanyManagementSystem();

		// when
		List<Employee> employeeNoParkingSpace = new ArrayList<>();
		employeeNoParkingSpace = cms.getList();

		// then
		List<Employee> expectedList = new ArrayList<Employee>();
		assertTrue(employeeNoParkingSpace.equals(expectedList));

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void CompanyManagementSystemAllEmployeesHaveParkingSpaces() {
		// given
		CompanyManagementSystem cms = new CompanyManagementSystem();
		cms.addEmployee(new Employee("Jhon",1,"junior",true));
		cms.addEmployee(new Employee("Maria",2,"junior",true));

		// when
		List<Employee> employeeNoParkingSpace = new ArrayList<>();
		employeeNoParkingSpace = cms.getList();

		// then
		List<Employee> expectedList = new ArrayList<Employee>();
		assertTrue(employeeNoParkingSpace.equals(expectedList));

	}
	@Test
	public void EmployeesAreStoredInCorrectCollection() {
		// given
		CompanyManagementSystem cms = new CompanyManagementSystem();
		cms.addEmployee(new Employee("Jhon",1,"junior",true));
		cms.addEmployee(new Employee("Ryan",5,"senior",false));
		cms.addEmployee(new Employee("Mike",10,"manager",true));

		// when
		List<Employee> seniorDeveloper= new ArrayList<>();
		seniorDeveloper = cms.getSeniorDeveloper();
		
		List<Employee> juniorDeveloper= new ArrayList<>();
		juniorDeveloper = cms.getJuniorDeveloper();
		
		List<Employee> manager= new ArrayList<>();
		manager = cms.getManager();
		
		
		//then
		assertTrue(seniorDeveloper.get(0).equals(new Employee("Ryan",5,"senior",false)));
		assertTrue(juniorDeveloper.get(0).equals(new  Employee("Jhon",1,"junior",true)));
		assertTrue(manager.get(0).equals(new Employee("Mike",10,"manager",true)));

	}
}
