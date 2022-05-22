package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Base;
import utilities.Utility;

public class registeration_page extends Base {	
	Utility utl = new Utility();
	
	//Objects
	private static By obj_lbl_buggy_ratig = By.linkText("Buggy Rating");
	private static By obj_btn_login = By.xpath("//button[text()='Login']");
	private static By obj_btn_registerer = By.xpath("//a[@href='/register']");
	private static By obj_lbl_header = By.className("display-4");
	private static By obj_img_car = By.xpath("//img[@src='/img/header-car.gif']");
	private static By obj_lbl_make = By.xpath("//h2[text()='Popular Make']");
	private static By obj_lbl_model = By.xpath("//h2[text()='Popular Model']");
	private static By obj_lbl_rating = By.xpath("//h2[text()='Overall Rating']");
	private static By obj_labl_registeration_header = By.xpath("//h2[text()='Register with Buggy Cars Rating']");
	private static By obj_register_login_username_txf = By.cssSelector("#username");
	private static By obj_register_fname_txf = By.cssSelector("#firstName");
	private static By obj_register_lname_txf = By.cssSelector("#lastName");
	private static By obj_register_pwd_txf = By.id("password");
	private static By obj_register_confirm_pwd_txf = By.id("confirmPassword");
	private static By obj_btn_registerform = By.xpath("//button[text()='Register']");
	private static By obj_lbl_registerform_success = By.xpath("//*[@class='result alert alert-success']");
	private static By obj_btn_cancel = By.linkText("Cancel");
	
	
	//variables Initalisation
	public String user_name = "Buggy_User_" + Utility.getRandom_alphanumberic(6);
	public String firs_tname = "Buggy" + Utility.getRandom_alphanumberic(5);
	public String last_name = "User" + Utility.getRandom_alphanumberic(5);
	public String password = "Testtest123!";
	
	//Methods
	
	//Verify all elements visible in buggy screen
	public void is_visilbe(String input)
	{
		switch(input) {
		  case "buggy_dashboard_page":
			  	Utility.explicitWait_VisibilityOfElement(obj_lbl_buggy_ratig);
				Utility.explicitWait_VisibilityOfElement(obj_btn_login);
				Utility.explicitWait_VisibilityOfElement(obj_btn_registerer);
				Utility.explicitWait_VisibilityOfElement(obj_lbl_header);
				Utility.explicitWait_VisibilityOfElement(obj_img_car);
				Utility.explicitWait_VisibilityOfElement(obj_lbl_make);
				Utility.explicitWait_VisibilityOfElement(obj_lbl_model);
				Utility.explicitWait_VisibilityOfElement(obj_lbl_rating);
			 break;
		  
		  case "buggy_registeration_page":
			    Utility.explicitWait_VisibilityOfElement(obj_labl_registeration_header);
			    Utility.explicitWait_VisibilityOfElement(obj_register_login_username_txf);
			    Utility.explicitWait_VisibilityOfElement(obj_register_fname_txf);
			    Utility.explicitWait_VisibilityOfElement(obj_register_lname_txf);
			    Utility.explicitWait_VisibilityOfElement(obj_register_pwd_txf);
			    Utility.explicitWait_VisibilityOfElement(obj_register_confirm_pwd_txf);
		    break;
		  
		  default:
		}
		 
	}
		
	
	//Click based on input
	public void click_button(String option)
	{
		switch(option) {
		  case "Login":
			  Utility.click(obj_btn_login);
			 break;
		  case "Register":
			  Utility.click(obj_btn_registerer);
		    break;
		    
		  case "Cancel":
			  Utility.click(obj_btn_cancel);
		    break;
		  default:
		 
		}
	}
	
	//New user registration
	public void new_user_registration()
	{	
		
		WebElement ele = driver.findElement(obj_register_login_username_txf);
		for(char uname : user_name.toCharArray()) {
			String name = new StringBuilder().append(uname).toString();
		    ele.sendKeys(name);
		}
		
		Utility.type_text(obj_register_fname_txf, firs_tname);
		Utility.type_text(obj_register_lname_txf, last_name);
		Utility.type_text(obj_register_pwd_txf, password);
		Utility.type_text(obj_register_confirm_pwd_txf, password);
		Utility.explicitWait_elementenabled(obj_btn_registerform);
		Utility.click(obj_btn_registerform);
		
		System.out.println("New user details:::user_name:" + user_name +" "+ "password:" + password);
		Utility.explicitWait_VisibilityOfElement(obj_lbl_registerform_success);
		
		String register_success = Utility.getText(obj_lbl_registerform_success);
		System.out.println("success message:" + register_success);
			
	}
	
	public void validate_user_registeration_success()
	{
		Assert.assertEquals("Registration is successful", Utility.getText(obj_lbl_registerform_success));
		click_button("Cancel");
	}
		
}