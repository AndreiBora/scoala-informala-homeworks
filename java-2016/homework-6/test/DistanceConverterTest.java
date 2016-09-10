import org.junit.Assert;
import org.junit.Test;

public class DistanceConverterTest {
	@Test
	public void metersToKilometersConvertion() throws UnknownDistanceFormatException{
		Distance d1000 = new Distance(Distance.METERS, 1000);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(d1000, Distance.KILO_METERS);
		Distance expected = new Distance(Distance.KILO_METERS, 1);
		
		Assert.assertEquals("Convertion from meters to kilometers is incorrect.", expected,  result);
	}
	
	@Test
	public void kilometersTometersConvertion() throws UnknownDistanceFormatException{
		Distance km1 = new Distance(Distance.KILO_METERS, 1);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(km1, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1000);
		
		Assert.assertEquals("Convertion from meters to kilometers is incorrect.", expected,  result);
	}
	
	@Test
	public void milesTometersConvertion() throws UnknownDistanceFormatException{
		Distance miles1 = new Distance(Distance.MILES, 1);
		MetricDistanceConverter distanceConverter = new MetricDistanceConverter();
		
		Distance result = distanceConverter.convert(miles1, Distance.METERS);
		Distance expected = new Distance(Distance.METERS, 1609.344);
		
		Assert.assertEquals("Convertion from meters to kilometers is incorrect.", expected,  result);
	}
}