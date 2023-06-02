package CymousBankGenerics;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{

	/**
	 * This method is used to get random numbers 
	 * @return
	 */
	public int get_Random_Number()
	{
		Random ran=new Random();
		int randomnumber = ran.nextInt(1000);
		return randomnumber;
	}
	/**
	 * This method is used to get Day 
	 * @return
	 */
	public String get_Day()
	{
		 Format f = new SimpleDateFormat("dd");
		 String Day=f.format(new Date());
		 return Day;
	}
	/**
	 * This method is used to get Month 
	 * @return
	 */
	public String get_Month()
	{
		 Format f = new SimpleDateFormat("MM");
		 String Mon=f.format(new Date());
		 return Mon;
	}
	/**
	 * This method is used to get Year 
	 * @return
	 */
	public String get_Year()
	{
		Format f = new SimpleDateFormat("yyyy");
		String yyyy=f.format(new Date());
		return yyyy;
	}


}
