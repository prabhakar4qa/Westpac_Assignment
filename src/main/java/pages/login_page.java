package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import utilities.Base;
import utilities.Utility;


public class login_page extends Base {	
	Utility utl = new Utility();
	
	//Objects
	private static By obj_login_username_txf = By.name("login");
	private static By obj_login_password_txf = By.name("password");
	private static By obj_btn_login = By.xpath("//button[text()='Login']");
	private static By obj_lbl_invalid_logins = By.xpath("//span[text()='Invalid username/password']");
	private static By obj_Profile_link = By.linkText("Profile");
	private static By obj_profile_logout = By.linkText("Logout");
	private static By obj_link_Buggy_Rating = By.linkText("Buggy Rating");
	
	
	//Methods
	//Enter user fname, lastname -> click on login
	public void enter_details(String username, String password)
	{
		Utility.explicitWait_VisibilityOfElement(obj_link_Buggy_Rating);
		Utility.type_text(obj_login_username_txf, username);
		Utility.type_text(obj_login_password_txf, password);
		Utility.click(obj_btn_login);
	}

	public void validate_user_login(boolean visible)
	{
		if (visible == true)
		{
			Utility.explicitWait_VisibilityOfElement(By.xpath("//span[contains(text(), 'Hi')]"));
			Utility.explicitWait_VisibilityOfElement(obj_Profile_link);
			Utility.explicitWait_VisibilityOfElement(obj_profile_logout);
			Utility.pause(5); //to slow down execution purpose
			validate_user_logout();
		}
		else if(visible == false)
		{
			Utility.explicitWait_VisibilityOfElement(obj_lbl_invalid_logins);
			Assert.assertEquals("Invalid username/password", Utility.getText(obj_lbl_invalid_logins));
		}
	
	}
	
	//User Logout
	public void validate_user_logout()
	{
		Utility.explicitWait_VisibilityOfElement(obj_profile_logout);
		Utility.click(obj_profile_logout);
	    Utility.explicitWait_VisibilityOfElement(obj_login_username_txf);
	}
	
		
}