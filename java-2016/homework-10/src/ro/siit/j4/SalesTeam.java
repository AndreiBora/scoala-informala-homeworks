package ro.siit.j4;

public enum SalesTeam {

	SALES_MANAGER {
		@Override
		public int computeSalary() {
			return 40 * (SALES_MANAGER.workedHours + SALES_MANAGER.daysOff * 8);
		}
	},
	SENIOR_SALES_OFFICER {
		
		@Override
		public int computeSalary() {
			totalNrPrePaidSales += SENIOR_SALES_OFFICER.nrPrePaidSales;
			totalNrPostPaidSales += SENIOR_SALES_OFFICER.nrPostPaidSales;
			return 20 * (SENIOR_SALES_OFFICER.workedHours + SENIOR_SALES_OFFICER.daysOff * 8) + 50 * SENIOR_SALES_OFFICER.nrPostPaidSales + 25 * SENIOR_SALES_OFFICER.nrPrePaidSales;
		}
	},
	SALES_OFFICER {
		
		@Override
		public int computeSalary() {
			totalNrPrePaidSales += SALES_OFFICER.nrPrePaidSales;
			totalNrPostPaidSales += SALES_OFFICER.nrPostPaidSales;
			return 10 * (SALES_OFFICER.workedHours + SALES_OFFICER.daysOff * 8) + 25 * SALES_OFFICER.nrPostPaidSales + 10 * SALES_OFFICER.nrPrePaidSales;
		}
	};

	private String name;
	private String jobPosition;
	private int workedHours;
	private int daysOff;
	private int nrPrePaidSales;
	private int nrPostPaidSales;
	private static int totalNrPrePaidSales;
	private static int totalNrPostPaidSales;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public int getDaysOff() {
		return daysOff;
	}

	public void setDaysOff(int daysOff) {
		this.daysOff = daysOff;
	}

	public int getNrPrePaidSales() {
		return nrPrePaidSales;
	}

	public void setNrPrePaidSales(int nrPrepaidSales) {
		this.nrPrePaidSales = nrPrepaidSales;
	}

	public int getNrPostPaidSales() {
		return nrPostPaidSales;
	}

	public void setNrPostPaidSales(int nrPostPaidSales) {
		this.nrPostPaidSales = nrPostPaidSales;
	}

	public static int getTotalNrPrePaidSales() {
		return totalNrPrePaidSales;
	}

	public static int getTotalNrPostPaidSales() {
		return totalNrPostPaidSales;
	}
	
	public abstract int computeSalary();
}
