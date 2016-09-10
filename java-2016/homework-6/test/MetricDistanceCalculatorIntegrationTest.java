import org.junit.Assert;
import org.junit.Test;

public class MetricDistanceCalculatorIntegrationTest {
	@Test
	public void distanceCalculatorWorksWithCorrectInput() throws UnknownDistanceFormatException {
		// given
		String s = "1km + 750m - 0.5miles + 25cm - 2mm";
		MetricDistanceCalculator calc = new MetricDistanceCalculator();
		// when
		Distance result = calc.computeDistance(s, Distance.METERS);
		// then
		Distance expected = new Distance(Distance.METERS,945.576);
		Assert.assertEquals(expected, result);
	}
}
