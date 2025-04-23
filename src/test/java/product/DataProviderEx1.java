package product;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEx1 {
	@Test(dataProvider = "readData")
	public void bookTickets(String src, String dest) {
		System.out.println("Book Tickets from" + src + "to" + dest);
	}

	@DataProvider
	public Object[][] readData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "Bangalore";
		obj[0][1] = "goa";

		obj[1][0] = "Bangalore";
		obj[1][1] = "hyd";

		obj[2][0] = "Bangalore";
		obj[2][1] = "pune";

		return obj;

	}
}
