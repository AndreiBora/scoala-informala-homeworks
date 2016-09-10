/**
 * The distance class defines a measured distance.
 */

public class Distance {
	
	public static final String KILO_METERS = "km";
	public static final String METERS = "m";
	public static final String DECI_METERS = "dm";
	public static final String CENTI_METERS = "cm";
	public static final String MILI_METERS = "mm";
	public static final String MILES = "miles";
	public static final String FEETS = "ft";
	public static final String INCHES = "inch";
	
	private String formatName;
	private double value;
	
	public Distance(String formatName, double value) {
		this.formatName = formatName;
		this.value = value;
	}
	/**
	 * Returns the unit of measurement.  
	 * @return formatName	Unit of measurement
	 */
	public String getFormatName() {
		return formatName;
	}
	/**
	 * Return the distance value
	 * @return	value	distance value
	 */
	
	public double getValue() {
		return value;
	}

	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formatName == null) ? 0 : formatName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(value);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distance other = (Distance) obj;
		if (formatName == null) {
			if (other.formatName != null)
				return false;
		} else if (!formatName.equals(other.formatName))
			return false;
		if (Double.doubleToLongBits(value) != Double.doubleToLongBits(other.value))
			return false;
		return true;
	}

	@Override
	/**
	 * Return the formated distance which include the value and unit of measurement
	 */
	public String toString() {
		return "Distance [formatName=" + formatName + ", value=" + value + "]";
	}
	
	/**
	 * Increase the distance amount with some value.
	 * @param value		distance value to increase the current amount.
	 */

	public void add(double value) {
		this.value += value;
	}
	
	

}
