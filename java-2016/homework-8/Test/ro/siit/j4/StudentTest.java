package ro.siit.j4;

import static org.junit.Assert.*;
import java.util.Calendar;
import org.junit.Test;

public class StudentTest {
	@Test
	public void whenPrerequisitsAreMet_getAgeOfTheStudent() {
		Student student = new Student("Tyson", "Mike", getCalendar(05, 13, 1966), "M", "1");
		assertEquals(50, student.getAge());
	}

	private static Calendar getCalendar(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.YEAR, year);
		return calendar;
	}
}
