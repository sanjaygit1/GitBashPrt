package product;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DemoTest {

	@Test(invocationCount = 3)
	public void createContact()
	{
		
		System.out.println("contactCreated");
	}
	
	
	@Test
	public void modifyContact()
	{
		System.out.println("contactModified");
	}
	
	@Test
	public void deleteContact()
	{
		System.out.println("Contactdeleted");
	}
}
