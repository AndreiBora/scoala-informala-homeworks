package ro.siit.j4;

import static org.junit.Assert.*;

import org.junit.Test;

public class SalesTeamTest {
	
	@Test
	public void computeSalaryOfSalesOfficer() {
		SalesTeam.SENIOR_SALES_OFFICER .setWorkedHours(160);
		SalesTeam.SENIOR_SALES_OFFICER .setDaysOff(0);
		SalesTeam.SENIOR_SALES_OFFICER .setNrPrePaidSales(5);
		SalesTeam.SENIOR_SALES_OFFICER .setNrPostPaidSales(10);
		int result = 20 * (160) + 50 * 10 + 25* 5;
		assertEquals(result,SalesTeam.SENIOR_SALES_OFFICER .computeSalary());
	}
	
	@Test
	public void computeSalaryOfSiniorSalesOfficer() {
		SalesTeam.SALES_OFFICER.setWorkedHours(84);
		SalesTeam.SALES_OFFICER.setDaysOff(10);
		SalesTeam.SALES_OFFICER.setNrPrePaidSales(10);
		SalesTeam.SALES_OFFICER.setNrPostPaidSales(0);
		int result = 10 * (84 + 8*10) + 10 * 10;
		assertEquals(result,SalesTeam.SALES_OFFICER.computeSalary());
	}
	
}
