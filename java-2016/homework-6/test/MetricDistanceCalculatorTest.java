
import org.junit.Test;
import static org.junit.Assert.*;

public class MetricDistanceCalculatorTest {
	
	@Test
	public void simpleExpressionIsCalculated() throws UnknownDistanceFormatException{
		// given
		MetricDistanceExpressionParser mockParser = new MetricDistanceExpressionParser(){
			@Override
			public Distance[] parse(String expression) throws UnknownDistanceFormatException {
				return new Distance[]{new Distance(Distance.METERS, 1), new Distance(Distance.MILI_METERS, 1)};
			}	
		};
		MetricDistanceConverter mockConverter = new MetricDistanceConverter(){
			@Override
			public Distance convert(Distance distance, String toFormat) throws UnknownDistanceFormatException {
				if(distance.getFormatName().equals(Distance.METERS)){
					return new Distance(Distance.MILI_METERS, 1000);
				} else {
					return distance;
				}
			}
		};
		MetricDistanceCalculator calc = new MetricDistanceCalculator(mockParser, mockConverter);
		
		// when
		Distance actual = calc.computeDistance("1m+1mm", Distance.MILI_METERS);
		
		// then
		Distance expected = new Distance(Distance.MILI_METERS, 1001);
		assertEquals(expected, actual);
	}

}
