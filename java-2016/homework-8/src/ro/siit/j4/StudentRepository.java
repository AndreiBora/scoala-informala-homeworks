package ro.siit.j4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class StudentRepository {
	private ArrayList<Student> studentRepository = new ArrayList<>();
	
	/**
	 * Add a student into repository if prerequisites are met.
	 * @throws IllegalArgumentException if the last name or first name is empty, the year of birth is 
	 * <p> before 1900 are the student age is under 18, also if the gender is not correct introduced. 
	 * @param student
	 */
	public void add(Student student) {
		if(student.getFirstName().isEmpty() || student.getLastName().isEmpty())
			throw new  IllegalArgumentException("Student must have first name and last name");
		
		validateDate(student);
		
		if(!student.getGender().toLowerCase().equals("m") &&  !student.getGender().toLowerCase().equals("f"))
			throw new IllegalArgumentException("Student must be male(m  or M) or female(f or F)");
		studentRepository.add(student);
	}
	
	/**
	 * Remove a student from repository if the student if the student ID matches the paramater.
	 * @throws IllegalArgumentException if the ID introduced is empty or the student is not in the repository.
	 * @param ID the identification number of the student
	 */
	public void delete(String ID) {
		boolean foundIt = false;
		if(ID.isEmpty())
			throw new IllegalArgumentException("Wrong ID");
		for (Student student : studentRepository) {
			if(student.getID().equals(ID) && !foundIt){
				studentRepository.remove(student);
				foundIt = true;
				break;
			}
		}
		if(!foundIt)
			throw new IllegalArgumentException("The student was not found");
	}
	
	/**
	 * Return a list of students who have the same age.
	 * @param age - age of the students to be return;
	 * @return a list of students with a given age.
	 * @throws IllegalArgumentException if the age is not in the correct format of the age is negative.
	 */
	public ArrayList<Student> retriveStudents(String age) {
		
		ArrayList<Student> studentsAgeCategory = new ArrayList<>();
		int age1;
		try{
			age1 = Integer.parseInt(age);
		} catch(NumberFormatException e){
			throw new NumberFormatException("Wrong format for integer");
		}
		
		if(age1 <= 0)
			throw new IllegalArgumentException("Age must be positive");
		for (Student student : studentRepository) {
			if(student.getAge() == age1){
				studentsAgeCategory.add(student);
			}
		}
		return studentsAgeCategory;
	}
	/**
	 * Return the students introduced in repository ordered by a criteria(alphabetic after last name or afte date of birth).
	 * @param orderCriteria - alphabetic after last name or after date of birth in ascending order.
	 * @return a list of ordered student by a criteria.
	 * @throws IllegalArgumentException if the criteria is not correct introduced.
	 */
	
	public ArrayList<Student> listStudents(String orderCriteria) {
		ArrayList<Student> orderStudents = new ArrayList<>(studentRepository);
		if(studentRepository.isEmpty()){
			throw new IllegalArgumentException("The student list is empty");
		}
		if(orderCriteria.equals("lastName")) {
			Collections.sort(orderStudents, Student.StuLastNameComparator);
			return orderStudents;
		} else if (orderCriteria.equals("birthDate")) {
			Collections.sort(orderStudents,Student.StuBirthDateComparator);
			return orderStudents;
		} else {
			throw new IllegalArgumentException("Wrong ordering criteria");
		}
		
	}
	
	/**
	 * Check if the student birth date is after 1900 or the student is at least 18 year old.
	 * @param student
	 * @throws IllegalArgumentException if the student date of birth is before 1900 or his age is less than 18 years old.
	 */
	private void validateDate(Student student) {
		Calendar year1900 = new GregorianCalendar(1900,0,1);
		
		if(student.getBirthDate().before(year1900)){
			throw new  IllegalArgumentException("The year must be after 1900");
		}
		
		if(student.getAge() < 18) {
			throw new IllegalArgumentException("The student must be at least 18 years old");
		}
	}
}
