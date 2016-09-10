/**
 * The MetricDistanceExpressionParser class constructs an array of distances  by parsing the distance expression.
 * @author Bora Andrei
 *
 */
public class MetricDistanceExpressionParser {
	private static final String MINUS = "-";
	private static final String PLUS = "\\+";
	/**
	 * The method return an array of distances obtain by parsing the distance expression.
	 * @param expression	a string of distances added or subtracted
	 * @return	An array of distances
	 * @throws UnknownDistanceFormatException if the user enters a format result not known by the method
	 */
	public Distance[] parse(String expression) throws UnknownDistanceFormatException {
		// count the operands
		int operandCount = countSubStringOccurrences(expression, PLUS) + countSubStringOccurrences(expression, MINUS)
				+ 1;
		if (expression.startsWith("-")) {
			operandCount--;
		}
		Distance distances[] = new Distance[operandCount];
		int index = 0;
		expression = expression.trim().replaceAll(" ", "").replaceAll("\t", ""); // loose
																					// the
																					// whitespaces
		while (expression.length() > 0) {
			int sign = 1;
			if (expression.startsWith(MINUS)) {
				expression = expression.replaceFirst(MINUS, "");
				sign = -1;
			} else if (expression.startsWith("+")) {
				expression = expression.replaceFirst(PLUS, "");
			}
			int nextOpPos = nextOperatorPos(expression);
			String operator = null;
			if (nextOpPos == -1) {// last operand
				operator = expression;
			} else {
				operator = expression.substring(0, nextOpPos);
			}
			expression = expression.replaceFirst(operator, "");
			distances[index++] = convertToDistance(operator, sign);
		}
		return distances;
	}
	/**
	 * Returns the next operator position
	 * @param expression	a string of distances added or subtracted
	 * @return	the next operator position
	 */

	int nextOperatorPos(String expression) {
		int plusPos = expression.indexOf("+");
		int minusPos = expression.indexOf("-");
		if (plusPos == -1) {
			return minusPos;
		}
		if (minusPos == -1) {
			return plusPos;
		}
		return plusPos < minusPos ? plusPos : minusPos;
	}
	/**
	 * The method calls the corect method to convert to the specified unit of measurement
	 * @param e	a distance containing the value and the unit of measurement
	 * @param sign	the sign of the distance value
	 * @return	the distance in the specified unit of measurement
	 * @throws UnknownDistanceFormatException If the format measurement is not found.
	 */

	private Distance convertToDistance(String e, int sign) throws UnknownDistanceFormatException {

		if (e.endsWith(Distance.KILO_METERS)) {
			return convertToDistance(e, sign, Distance.KILO_METERS);
		} else if (e.endsWith(Distance.DECI_METERS)) {
			return convertToDistance(e, sign, Distance.DECI_METERS);
		} else if (e.endsWith(Distance.CENTI_METERS)) {
			return convertToDistance(e, sign, Distance.CENTI_METERS);
		} else if (e.endsWith(Distance.MILI_METERS)) {
			return convertToDistance(e, sign, Distance.MILI_METERS);
		} else if (e.endsWith(Distance.METERS)) {
			return convertToDistance(e, sign, Distance.METERS);
		} else if (e.endsWith(Distance.MILES)) {
			return convertToDistance(e, sign, Distance.MILES);
		} else if (e.endsWith(Distance.FEETS)) {
			return convertToDistance(e, sign, Distance.FEETS);
		} else if (e.endsWith(Distance.INCHES)){
			return convertToDistance(e, sign, Distance.INCHES);
		}
		throw new UnknownDistanceFormatException("Can not parse ["+e+"] as a valid weight.");		
	}
	/**
	 * Converts the string into distance object
	 * @param e 	distance with value and unit of measurement in string format
	 * @param sign	the sign of the distance 
	 * @param distanceFormat	the specified format for measurement
	 * @return	a distance object
	 */
	private Distance convertToDistance(String e, int sign, String distanceFormat) {
		return new Distance(distanceFormat, sign * Double.parseDouble(e.replace(distanceFormat, "")));
	}
	
	/**
	 * Counts the number of substring distances in the distance expression.
	 * @param s	String expresion of distances
	 * @param sub	the plus or minus sign that separates the distances substrings.
	 * @return	the difference between the full string and the string without the plus minus sign.
	 */
	private int countSubStringOccurrences(String s, String sub) {
		return s.length() - s.replaceAll(sub, "").length();
	}
}
