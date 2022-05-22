package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Utility extends Base{
	private static final String char_list="a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,w,x,w,z";
	private static final int char_length= 10;

	//wait till element to visible in webpage
	public static void explicitWait_VisibilityOfElement(By by)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);

		}
	}

	
	//click method
	public static void click(By by)
	{
		try
		{
			Utility.explicitWait_VisibilityOfElement(by);
			driver.findElement(by).click();
			
		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);
		}
	}
	
	//type text
	public static void type_text(By by, String text)
	{
		try
		{
			Utility.explicitWait_VisibilityOfElement(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(text);;
			
		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);
			
		}
	}
	
	//wait till element is enabled
	public static void explicitWait_elementenabled(By by)
	{
		try
		{
			driver.findElement(by).isEnabled();
		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);
		}
	}
	
	//getText of element
	public static String getText(By by)
	{
		String text = null;
		
		try
		{
			text = driver.findElement(by).getText();
		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);
		}
		return text;
	}
	
	//wait till element is clicable
	public static void explicitWait_ClickableofElement(By by)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.elementToBeClickable(by));
		}
		catch(Exception e)
		{
			System.out.println("Element is not clickable with in time");
		}
	}

	//wait till text appears on screen
	public static void explicitWait_WaitforTexttobePresent(By by, String text)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));
		}
		catch(Exception e)
		{
			System.out.println("Text not found with in time");
		}
	}
	
	//dropdown handling using select class
	public static void select_drpdwn_by_visible_text(By by, String text)
	{
		try
		{
			explicitWait_VisibilityOfElement(by);
			Select slctdrdown = new Select(driver.findElement(by));
			slctdrdown.selectByVisibleText(text);
		}
		catch(Exception e)
		{
			Assert.fail("element not found:" +by);
		}
	}

	//generate current date and time
	public static String getCurrentDateAndTime() {
		DateFormat dateformat = new SimpleDateFormat("_yyyy-mm-dd_HH-mm-ss");
		Calendar cal = Calendar.getInstance();
		String time ="" + dateformat.format(cal.getTime());
		return time;
	}

	//generate current date
	public static String getCurrentDate() {
		return getCurrentDateAndTime().substring(0, 11);
	}

	
	public static String getRandom_alphanumberic(int number) {
		
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(number);

		for (int i = 0; i < number ; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int)(AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}


	//generate a random number
	public static int getRandomNumber() {
		int randomInt =0;
		Random randomnumber = new Random();
		randomInt =randomnumber.nextInt(char_list.length());
		System.out.println("randomnumber:" + randomnumber + "randomInt:" + randomInt);

		if(randomInt -1 == -1) 
		{
			return randomInt -1;
		} else {
			return randomInt;	 	
		}	
	}
	
	//generate random UUID
	public static String uuid()
	{
		return UUID.randomUUID().toString();
	}
	
	//get Title
	public static String getTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
	
	//Thread.sleep
	public static void pause(double d)
	{
		try {
			
			Thread.sleep((long) (d*1000));
		  }
		catch (Exception e)
		{
          System.out.println(e.getMessage());
		}
	}
	
	//scroll the page
	public static void scrollToElement(By by)
	 {
		try{
			pause(0.5);

			WebElement element = driver.findElement(by);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	 }

	//click using java script
	public static void click_JavaScript(By by,String desc){
		WebElement element = driver.findElement(by);

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

	}




}
