import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/**
 * The class receives employees , organize them in collections 
 * <p>and return a list of employees that have no parking space in the order of seriosity .
 * @author Bora Andrei
 *
 */
public class CompanyManagementSystem {
	private List<Employee> seniorDeveloper = new ArrayList<Employee>();
	private List<Employee> juniorDeveloper = new ArrayList<Employee>();
	private List<Employee> manager = new ArrayList<Employee>();
	private List<Employee> noParkingList = new ArrayList<Employee>();
	
	/**
	 * Receives an employee and organize them in lists of junior,senior and manager
	 * @param employee employee of the company
	 */
	public void addEmployee(Employee employee){
		switch(employee.getRole().toLowerCase()){
			case "junior" :
				juniorDeveloper.add(employee);
				break;
			case "senior" :
				seniorDeveloper.add(employee);
				break;
			case "manager" :
				manager.add(employee);
				break;
			default:
				System.out.println("The role doesn't exist");
			}
	}
	/**
	 * Return a list of employees sorted in the order of experience that doesn't have a parking place.
	 * @return List of employees that doesn't have parking place.
	 */
	public List<Employee> getList(){
		createList();
		if(noParkingList.isEmpty()){
			throw new IllegalArgumentException("You must add employee before you get the list");
		}
		Collections.sort(noParkingList, new Comparator<Employee>() {
			@Override
			public int compare(Employee employee1, Employee employee2) {
				if(employee1.getSeriosity()  > employee2.getSeriosity()) {
					return 1;
				} else if (employee1.getSeriosity()  < employee2.getSeriosity()) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		return noParkingList;
	}
	/**
	 * Construct an unordered list of employee that doesn't have a parking place from the senior,junior and manager list.
	 */
	private void createList() {
		//create an unsorted list with employees witch doesn't have parking place
		for(int i = 0; i < juniorDeveloper.size();i++)
			if(!juniorDeveloper.get(i).getHasParkingSpace())
				noParkingList.add(juniorDeveloper.get(i));
		for(int i = 0; i < seniorDeveloper.size();i++)
			if(!seniorDeveloper.get(i).getHasParkingSpace())
				noParkingList.add(seniorDeveloper.get(i));
		for(int i = 0; i < manager.size();i++)
			if(!manager.get(i).getHasParkingSpace())
				noParkingList.add(manager.get(i));
	}
	
	public List<Employee> getSeniorDeveloper() {
		return seniorDeveloper;
	}
	
	public List<Employee> getJuniorDeveloper() {
		return juniorDeveloper;
	}
	
	public List<Employee> getManager() {
		return manager;
	}
}
