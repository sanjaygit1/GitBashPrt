package Generic_Utilities;

import java.util.Random;

public class Java_Utility {

	/**
	 * This method is used to avoid Duplicate values
	 * @return
	 * @author Shobha
	 */
	public int getRandom()
	{
		Random ran = new Random();
		int ranNum = ran.nextInt(1000);
		return ranNum;
	}
}
