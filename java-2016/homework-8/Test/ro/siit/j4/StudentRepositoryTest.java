package ro.siit.j4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class StudentRepositoryTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void whenTheStudentIsMinor_addStudents() {
		StudentRepository sr = new StudentRepository();
		MockStudent.hardcodedAge = 16;

		MockStudent mockStudent = new MockStudent("Tyson", "Mike", getCalendar(05, 13, 1966), "M", "1");
		sr.add(mockStudent);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenTheStudentIsBornBefore1900_addStudents() {
		StudentRepository sr = new StudentRepository();

		Student student = new Student("Eminescu", "Mihai", getCalendar(0, 15, 1850), "M", "2");
		sr.add(student);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenTheStudentHasNoFirstName_addStudents() {
		StudentRepository sr = new StudentRepository();

		Student student = new Student("", "Mihai", getCalendar(0, 15, 1850), "M", "2");
		sr.add(student);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenTheStudentHasNoLastName_addStudents() {
		StudentRepository sr = new StudentRepository();

		Student student = new Student("Eminescu", "", getCalendar(0, 15, 1950), "M", "2");
		sr.add(student);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenTheStudentHasWrongGender_addStudents() {
		StudentRepository sr = new StudentRepository();

		Student student = new Student("Eminescu", "Mihai", getCalendar(0, 15, 1950), "FM", "2");
		sr.add(student);
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void whenIdIsEmpty_deleteStudent(){
		StudentRepository sr = new StudentRepository();

		Student student1 = new Student("Halep", "Simona", getCalendar(9, 27, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 26, 1990), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		sr.delete("");
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void whenTheStudentDoesntExist_deleteStudent(){
		StudentRepository sr = new StudentRepository();

		Student student1 = new Student("Halep", "Simona", getCalendar(9, 27, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 26, 1990), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		sr.delete("4");
	}
	
	@Test(expected = NumberFormatException.class) 
	public void whenAgeIsNotANumeber_retriveStudentList(){
		StudentRepository sr = new StudentRepository();
		ArrayList<Student> arrStudents = new ArrayList<>();

		Student student1 = new Student("Halep", "Simona", getCalendar(9, 27, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 26, 1990), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		arrStudents = sr.retriveStudents("a");
	}
	
	@Test 
	public void whenPreRequisitesAreMet_retriveStudentList(){
		StudentRepository sr = new StudentRepository();
		ArrayList<Student> arrStudents = new ArrayList<>();
		ArrayList<Student> expectedStudentList = new ArrayList<Student>();

		Student student1 = new Student("Halep", "Simona", getCalendar(8, 20, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 20, 1991), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		expectedStudentList.add(student1);
		expectedStudentList.add(student2);
		
		arrStudents = sr.retriveStudents("25");
		assertTrue(arrStudents.equals(expectedStudentList));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void whenAgeIsANegativeNumber_retriveStudentList(){
		StudentRepository sr = new StudentRepository();
		ArrayList<Student> arrStudents = new ArrayList<>();

		Student student1 = new Student("Halep", "Simona", getCalendar(9, 27, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 26, 1990), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		arrStudents = sr.retriveStudents("-20");
	}
	
	@Test
	public void whenPreRequisitsAreMet_listStudentsOrderedAfterLastName(){
		StudentRepository sr = new StudentRepository();
		ArrayList<Student> arrStudents = new ArrayList<>();
		ArrayList<Student> expectedStudentList = new ArrayList<Student>();

		Student student1 = new Student("Halep", "Simona", getCalendar(8, 20, 1991), "F", "1");
		Student student2 = new Student("Begu", "Irina", getCalendar(8, 20, 1991), "F", "2");
		Student student3 = new Student("Serena", "Wiliams", getCalendar(8, 26, 1981), "F", "3");
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		expectedStudentList.add(student2);
		expectedStudentList.add(student1);
		expectedStudentList.add(student3);
		
		arrStudents = sr.listStudents("lastName");
		assertTrue(arrStudents.equals(expectedStudentList));
	}
	
	@Test
	public void whenPreRequisitsAreMet_listStudentsOrderedAfterBirthDate(){
		StudentRepository sr = new StudentRepository();
		ArrayList<Student> arrStudents = new ArrayList<>();
		ArrayList<Student> expectedStudentList = new ArrayList<Student>();

		Student student1 = new Student("Halep", "Simona", getCalendar(9, 27, 1991), "F", "1");
		Student student2 = new Student("Wiliams", "Serena", getCalendar(8, 26, 1981), "F", "3");
		Student student3 = new Student("Begu", "Irina", getCalendar(8, 26, 1990), "F", "2");
		
		sr.add(student1);
		sr.add(student2);
		sr.add(student3);
		
		expectedStudentList.add(student3);
		expectedStudentList.add(student2);
		expectedStudentList.add(student1);
		
		arrStudents = sr.listStudents("lastName");
		assertTrue(arrStudents.equals(expectedStudentList));
	}
	
	
	private static class MockStudent extends Student {
		private static int hardcodedAge;

		public MockStudent(String firstName, String lastName, Calendar birthDate, String gender, String iD) {
			super(firstName, lastName, birthDate, gender, iD);
		}

		@Override
		public int getAge() {
			return hardcodedAge;
		}
	}

	private static Calendar getCalendar(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar;
	}

}
