
/**
 * The MetricDistanceCalculator determines the total distance in a specified unit of measurement from a string.
 * @author Bora Andrei
 *
 */
public class MetricDistanceCalculator {
	private MetricDistanceExpressionParser parser;
	private MetricDistanceConverter converter;
	
	public MetricDistanceCalculator() {
		this(new MetricDistanceExpressionParser(), new MetricDistanceConverter());
	}
	
	MetricDistanceCalculator(MetricDistanceExpressionParser parser, MetricDistanceConverter converter) {
		this.parser = parser;
		this.converter = converter;
	}
	
	/**
	 * Computes the total distance in a specify unit of measurement from a string expresion
	 * @param expression	a string with different values of distance that are added or subtracted
	 * @param resultDistanceFormat	the unit of measurement in which the distances are transformed.
	 * @return	the total distance in specified format.
	 * @throws UnknownDistanceFormatException	if the format result is not found.
	 */
	public Distance computeDistance(String expression, String resultDistanceFormat) throws UnknownDistanceFormatException {
		Distance[] distances = parser.parse(expression);
		Distance result = new Distance(resultDistanceFormat, 0);
		for (Distance distance : distances) {
			Distance converted = converter.convert(distance, resultDistanceFormat);
			result.add(converted.getValue());
		}
		return result;
	}
}
