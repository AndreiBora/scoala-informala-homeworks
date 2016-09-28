package ro.siit.j4;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class Student {
	private String firstName;
	private String lastName;
	private Calendar birthDate;
	private String gender;
	private String ID;

	public Student(String firstName, String lastName, Calendar birthDate, String gender, String iD) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.gender = gender;
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public String getGender() {
		return gender;
	}

	public String getID() {
		return ID;
	}

	/**
	 * Return the age of the student after computing it from the date of birth.
	 * 
	 * @return age of student
	 */
	public int getAge() {
		Calendar currentDate = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();

		currentDate.setTime(new Date());
		long difference = currentDate.getTimeInMillis() - birthDate.getTimeInMillis();
		calendar.setTimeInMillis(difference);
		return (calendar.get(Calendar.YEAR) - 1970);
	}
	
	/**
	 * Use in comparation methods for ordering the student in lexicografical order after last name  
	 */
	public static Comparator<Student> StuLastNameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			return s1.getLastName().compareTo(s2.getLastName());
		}

	};
	
	/**
	 * Use in comparation methods for ordering the student in ascending order after date of birth.
	 */
	public static Comparator<Student> StuBirthDateComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			if (s1.getBirthDate().after(s2.getBirthDate())) {
				return 1;
			} else if (s1.getBirthDate().before(s2.getBirthDate())) {
				return -1;
			} else
				return 0;
		}

	};

	@Override
	public String toString() {
		return ("first name = " + firstName + " last name = " + lastName);
	}

}
