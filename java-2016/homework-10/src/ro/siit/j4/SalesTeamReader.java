package ro.siit.j4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class SalesTeamReader extends BufferedReader{
	
	public SalesTeamReader(Reader reader) {
		super(reader);
	}
	
	/**
	 * Computes the salary of sales office employee from a txt file and return the result as a LinkedHashMap
	 * @return nameSalary - a linked hash map that contains the name of the employee and the computed salary
	 * @throws IOException - if there are no mangers or there are more than one managers it throws an IllegalArgumentExeption
	 */
	public HashMap<String,Integer> readSalary() throws IOException {
		int nrOfManagers = 0;
		LinkedHashMap <String,Integer> nameSalary = new LinkedHashMap<>();
		String txtLine = readLine();
		while(txtLine != null) {
			String[] tokens  = txtLine.split("\\|");
			switch(tokens[1]) {
				case "Sales Manager":
					nrOfManagers++;
					if(nrOfManagers  > 1)
						throw new IllegalArgumentException("There must be just one manager");
					SalesTeam.SALES_MANAGER.setName(tokens[0]);
					SalesTeam.SALES_MANAGER.setWorkedHours(Integer.parseInt(tokens[2]));
					SalesTeam.SALES_MANAGER.setDaysOff(Integer.parseInt(tokens[3]));
					break;
					
				case "Senior Sales Officer":
					SalesTeam.SENIOR_SALES_OFFICER.setName(tokens[0]);
					SalesTeam.SENIOR_SALES_OFFICER.setWorkedHours(Integer.parseInt(tokens[2]));
					SalesTeam.SENIOR_SALES_OFFICER.setDaysOff(Integer.parseInt(tokens[3]));
					SalesTeam.SENIOR_SALES_OFFICER.setNrPrePaidSales(Integer.parseInt(tokens[4]));
					SalesTeam.SENIOR_SALES_OFFICER.setNrPostPaidSales(Integer.parseInt(tokens[5]));
					nameSalary.put(SalesTeam.SENIOR_SALES_OFFICER.getName(),SalesTeam.SENIOR_SALES_OFFICER.computeSalary());
					break;
					
				case "Sales Officer":
					SalesTeam.SALES_OFFICER.setName(tokens[0]);
					SalesTeam.SALES_OFFICER.setWorkedHours(Integer.parseInt(tokens[2]));
					SalesTeam.SALES_OFFICER.setDaysOff(Integer.parseInt(tokens[3]));
					SalesTeam.SALES_OFFICER.setNrPrePaidSales(Integer.parseInt(tokens[4]));
					SalesTeam.SALES_OFFICER.setNrPostPaidSales(Integer.parseInt(tokens[5]));
					nameSalary.put(SalesTeam.SALES_OFFICER.getName(),SalesTeam.SALES_OFFICER.computeSalary());
					break;
					
				default:
					throw new IllegalArgumentException("The job name doesn't exists");
			}
			txtLine = readLine();
		}
		int bonus = computeManagerBonus();
		nameSalary.put(SalesTeam.SALES_MANAGER.getName(),SalesTeam.SALES_MANAGER.computeSalary() + bonus);
		if(nrOfManagers == 0)
			throw new IllegalArgumentException("There must be one manager");
		return nameSalary;
	}

	private int computeManagerBonus() {
		return 15 * SalesTeam.getTotalNrPrePaidSales() + 30 * SalesTeam.getTotalNrPostPaidSales();
	}

}
