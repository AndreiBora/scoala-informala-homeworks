package ro.siit.j4;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger LOGGER = Logger.getLogger("ro.siit.j4");

	public static void main(String[] args) {
		LOGGER.fine("In main");
		LOGGER.info("Start main");
		try{
			StudentRepository sr = new StudentRepository();
			ArrayList<Student> al = new ArrayList<>();
			Student student1 = new Student("Bora", "Andrei", getCalendar(11, 13, 1991), "M", "13");
			Student student2 = new Student("Go", "Google", getCalendar(1, 1, 1992), "M", "1");
			Student student3 = new Student("Bora", "Bora", getCalendar(11, 13, 2007), "M", "12");
	
			sr.add(student1);
			sr.add(student2);
			sr.add(student3);
			al = sr.retriveStudents("23");
			System.out.println(al);
			al = sr.listStudents("lastName");
			System.out.println(al);
			al = sr.listStudents("birthDate");
			System.out.println(al);
		} catch (RuntimeException e){
			LOGGER.log(Level.SEVERE, "Eror during running", e);
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
