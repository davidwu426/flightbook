package flightbook.dao.fare;

public interface IFareDao {
	public double getFare(String airlineId, int flightNo, String fareType, String flightClass);
}
