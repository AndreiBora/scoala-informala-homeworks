package ro.siit.j4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

public class StudentRepositoryIntegrationTest {
	private static Logger LOGGER = Logger.getLogger("ro.siit.j4");

	@Test
	public void whenPreRequisitsAreMet_ListStudents() {
		
		LOGGER.fine("In whenPreRequisitsAreMet_ListStudents test");
		LOGGER.info("whenPreRequisitsAreMet_ListStudents test");
		try{
			StudentRepository sr = new StudentRepository();
			ArrayList<Student> al = new ArrayList<>();
			ArrayList<Student> expectedStudentList = new ArrayList<>();
			
			Student student1 = new Student("Simona","Halep",  getCalendar(9, 27, 1991), "F", "1");
			Student student2 = new Student("Irina","Begu",  getCalendar(8, 26, 1990), "F", "2");
			Student student3 = new Student("Wiliams","Serena",  getCalendar(8, 26, 1981), "F", "3");
			Student student4 = new Student( "Maria","Sharapova", getCalendar(3, 19, 1987), "F", "4");
			
			sr.add(student1);
			sr.add(student2);
			sr.add(student3);
			sr.add(student4);
			
			LOGGER.fine("Deleting an student with ID");
			sr.delete("2");
			
			expectedStudentList.add(student3);
			expectedStudentList.add(student4);
			expectedStudentList.add(student1);
			
			al = sr.listStudents("birthDate");
			assertTrue(al.equals(expectedStudentList));
			
		} catch (RuntimeException e){
			LOGGER.log(Level.SEVERE, "Eror during running", e);
		}
		LOGGER.info("end of whenPreRequisitsAreMet_ListStudents test");

	}

	private static Calendar getCalendar(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar;
	}
}
