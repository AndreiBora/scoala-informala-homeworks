package ro.siit.j4;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
	
	public static void main(String[] args) throws IOException {

		File file = new File("sales-team.txt");
		try (SalesTeamReader txtReader = new SalesTeamReader(new FileReader(file))) {
			LinkedHashMap<String, Integer> nameSalary = (LinkedHashMap<String, Integer>) txtReader.readSalary();
			for (String name : nameSalary.keySet()) {
				System.out.println("name = " + name + "Salary = " + nameSalary.get(name));
			}
		}

	}
}
