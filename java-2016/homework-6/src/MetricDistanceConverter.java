/**
 * The class MetricDistanceConverter converts a distance from one unit of measurement to a specified one.
 * @author Bora Andrei
 *
 */

public class MetricDistanceConverter {
	
	private static final Convertion [] CONVERTIONS = new Convertion[]{
		new Convertion(Distance.KILO_METERS, Distance.METERS, 1000),
		new Convertion(Distance.METERS, Distance.KILO_METERS, 0.001),
		new Convertion(Distance.KILO_METERS, Distance.DECI_METERS, 10000),
		new Convertion(Distance.DECI_METERS, Distance.KILO_METERS, 0.0001),
		new Convertion(Distance.KILO_METERS, Distance.CENTI_METERS, 100000),
		new Convertion(Distance.CENTI_METERS, Distance.KILO_METERS, 0.00001),
		new Convertion(Distance.KILO_METERS, Distance.MILI_METERS, 1E6),
		new Convertion(Distance.MILI_METERS, Distance.KILO_METERS, 1E-6),
		new Convertion(Distance.METERS, Distance.DECI_METERS, 10),
		new Convertion(Distance.DECI_METERS, Distance.METERS, 0.1),
		new Convertion(Distance.METERS, Distance.CENTI_METERS, 100),
		new Convertion(Distance.CENTI_METERS, Distance.METERS, 0.01),
		new Convertion(Distance.METERS, Distance.MILI_METERS, 1000),
		new Convertion(Distance.MILI_METERS, Distance.METERS, 0.001),
		new Convertion(Distance.DECI_METERS, Distance.CENTI_METERS, 10),
		new Convertion(Distance.CENTI_METERS, Distance.DECI_METERS, 0.1),
		new Convertion(Distance.DECI_METERS, Distance.MILI_METERS, 100),
		new Convertion(Distance.MILI_METERS, Distance.DECI_METERS, 0.001),
		new Convertion(Distance.CENTI_METERS, Distance.MILI_METERS, 10),
		new Convertion(Distance.MILI_METERS, Distance.CENTI_METERS, 0.1),
		
		new Convertion(Distance.MILES, Distance.KILO_METERS, 1.609344),
		new Convertion(Distance.KILO_METERS, Distance.MILES, 0.621371192),
		new Convertion(Distance.MILES, Distance.METERS, 1609.344),
		new Convertion(Distance.METERS, Distance.MILES, 0.000621371192),
		new Convertion(Distance.MILES, Distance.DECI_METERS, 16093.44),
		new Convertion(Distance.DECI_METERS, Distance.MILES, 0.0000621371192),
		new Convertion(Distance.MILES, Distance.CENTI_METERS, 160934.4),
		new Convertion(Distance.CENTI_METERS, Distance.MILES, 0.00000621371192),
		new Convertion(Distance.MILES, Distance.MILI_METERS, 1609344),
		new Convertion(Distance.MILI_METERS, Distance.MILES, 0.000000621371192),
		
		new Convertion(Distance.FEETS, Distance.KILO_METERS,  3.2808399e-3),
		new Convertion(Distance.KILO_METERS, Distance.FEETS, 3.280839895e3),
		new Convertion(Distance.FEETS, Distance.METERS,  3.2808399),
		new Convertion(Distance.METERS, Distance.FEETS, 3.280839895),
		new Convertion(Distance.FEETS, Distance.DECI_METERS,  32.808399),
		new Convertion(Distance.DECI_METERS, Distance.FEETS, 0.3280839895),
		new Convertion(Distance.FEETS, Distance.CENTI_METERS,  328.08399),
		new Convertion(Distance.CENTI_METERS, Distance.FEETS, 0.03280839895),
		new Convertion(Distance.FEETS, Distance.MILI_METERS,  3280.8399),
		new Convertion(Distance.MILI_METERS, Distance.FEETS, 3.280839895e-3),
		
		new Convertion(Distance.INCHES, Distance.KILO_METERS,  2.54e-5),
		new Convertion(Distance.KILO_METERS, Distance.INCHES, 39370.07874016),
		new Convertion(Distance.INCHES, Distance.METERS,  2.54e-2),
		new Convertion(Distance.METERS, Distance.INCHES, 39.37007874016),
		new Convertion(Distance.INCHES, Distance.DECI_METERS,  2.54E-1),
		new Convertion(Distance.DECI_METERS, Distance.INCHES, 3.937007874016),
		new Convertion(Distance.INCHES, Distance.CENTI_METERS,  2.54),
		new Convertion(Distance.CENTI_METERS, Distance.INCHES, 0.39370079),
		new Convertion(Distance.INCHES, Distance.MILI_METERS,  25.4),
		new Convertion(Distance.MILI_METERS, Distance.INCHES, 0.039370079),
	};
	/**
	 * If the distance value is in the specified format the method return back the distance else it make a conversion.
	 * @param distance	distance value extracted from the distance expresion
	 * @param toFormat	the specified format in which all distances are converted
	 * @return	return the converted distance
	 * @throws UnknownDistanceFormatException If the format measurement is not found.
	 */
	public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException{
		if(distance.getFormatName().equals(toFormat)){
			return distance;
		}
		Convertion convertion = null;
		for(Convertion c : CONVERTIONS){
			if(c.fromFormat.equals(distance.getFormatName()) && c.toFormat.equals(toFormat)){
				convertion = c;
				break;
			}
		}
		if(convertion==null){
			throw new IllegalArgumentException("No rate found for "+distance.getFormatName()+" - "+toFormat);
		}
		return new Distance(toFormat, distance.getValue()*convertion.rate);
	}
	
	private static class Convertion {
		double rate;
		String fromFormat;
		String toFormat;
		
		public Convertion(String fromFormat, String toFormat, double rate) {
			super();
			this.rate = rate;
			this.fromFormat = fromFormat;
			this.toFormat = toFormat;
		}
		
		
		
	}

}
