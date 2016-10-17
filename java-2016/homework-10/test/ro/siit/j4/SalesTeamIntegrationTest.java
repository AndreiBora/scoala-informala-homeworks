package ro.siit.j4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import static org.junit.Assert.*;
import org.junit.Test;

public class SalesTeamIntegrationTest {
	@Test
	public void whenThePrerequisitsAreMet_getSalaryMap() throws FileNotFoundException, IOException{
	
		File file = new File("sales-team.txt");
		Integer[] expected = new Integer[]{3825,1740,1935,3950};
		Integer[] result = new Integer[4];
		int index = 0;
		try (SalesTeamReader txtReader = new SalesTeamReader(new FileReader(file))) {
			LinkedHashMap<String, Integer> nameSalary = (LinkedHashMap<String, Integer>) txtReader.readSalary();
			for (String name : nameSalary.keySet()) {
				result[index++] = nameSalary.get(name);
			}
			assertArrayEquals(expected,result);
		}
	}
}
