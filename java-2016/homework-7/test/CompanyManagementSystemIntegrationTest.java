import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CompanyManagementSystemIntegrationTest {
	@Test
	public void getListWithCorrectArgumentList() {
		//given
		CompanyManagementSystem cms = new CompanyManagementSystem();
		cms.addEmployee(new Employee("Jhon",1,"junior",false));
		cms.addEmployee(new Employee("Maria",2,"junior",true));
		cms.addEmployee(new Employee("Kim",7,"senior",true));
		cms.addEmployee(new Employee("Ryan",5,"senior",false));
		cms.addEmployee(new Employee("Mike",10,"manager",true));
		
		//when
		List<Employee> employeeNoParkingSpace = new ArrayList<>();
		employeeNoParkingSpace = cms.getList();
		
		//then
		List<Employee> expectedList = new ArrayList<Employee>();
		expectedList.add(new Employee("Jhon",1,"junior",false));
		expectedList.add(new Employee("Ryan",5,"senior",false));
		
		assertTrue(employeeNoParkingSpace.equals(expectedList));
		
	}
	
}
