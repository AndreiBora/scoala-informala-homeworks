
/**
 * Implements the user interaction with the metric calculator
 * @author Bora Andrei
 *
 */
public class Main {
	public static void main(String[] args) throws UnknownDistanceFormatException {
		String s = "1km + 750m - 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		System.out.println(calc.computeDistance(s, Distance.METERS));
	}

}
