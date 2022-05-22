package pages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utilities.Base;
import utilities.Utility;


public class user_profile_page extends Base {	
	Utility utl = new Utility();


	//Objects
	private static By obj_login_username_txf = By.name("login");
	private static By obj_Profile_link = By.linkText("Profile");
	private static By obj_profile_logout = By.linkText("Logout");
	private static By obj_lbl_profile_basic = By.xpath("//h3[text()='Basic']");
	private static By obj_lbl_profile_addinfo1 = By.xpath("(//h3[text()='Additional Info'])[1]");
	private static By obj_lbl_profile_addinfo2 = By.xpath("(//h3[text()='Additional Info'])[2]");
	private static By obj_lbl_basic_login = By.xpath("//label[text()='Login']");
	private static By obj_lbl_basic_first_name = By.xpath("//label[text()='First Name']");
	private static By obj_lbl_basic_last_name = By.xpath("//label[text()='Last Name']");
	private static By obj_lbl_adtninfo_gender = By.xpath("//label[text()='Gender']");
	private static By obj_lbl_adtninfo_age = By.xpath("//label[text()='Age']");
	private static By obj_lbl_adtninfo_address = By.xpath("//label[text()='Address']");
	private static By obj_lbl_adtninfo_phone = By.xpath("//label[text()='Phone']");
	private static By obj_lbl_adtninfo_hobby = By.xpath("//label[text()='Hobby']");
	private static By obj_adtninfo_header_chngepwd = By.xpath("//h4[text()='Change Password']");
	private static By obj_lbl_adtninfo_crntpwd = By.xpath("//label[text()='Current Password']");
	private static By obj_lbl_adtninfo_newpwd = By.xpath("//label[text()='New Pasword']");
	private static By obj_lbl_adtninfo_cnfmpwd = By.xpath("//label[text()='Confirm Password']");
	private static By obj_adtn_info_gender_drpdown = By.id("gender");
	private static By obj_gender_options = By.xpath("//datalist[@id='genders']/option");
	private static By obj_age_txf = By.id("age");
	private static By obj_address_txf = By.id("address");
	private static By obj_phone_txf = By.id("phone");
	private static By obj_hobby_drpdown = By.id("hobby");
	private static By obj_profile_btn_save = By.xpath("//button[text()='Save']");
	private static By obj_lbl_profile_update_success_msg = By.xpath("//div[contains(text(),'The profile has been saved successful')]");
	
	
	//Methods
	//Click button based on input
		public void click_button(String option)
		{
			switch(option) {
			  case "Profile":
				  Utility.click(obj_Profile_link);
				  Utility.explicitWait_VisibilityOfElement(obj_lbl_profile_basic);
				  Utility.explicitWait_VisibilityOfElement(obj_lbl_profile_addinfo1);
				  Utility.explicitWait_VisibilityOfElement(obj_lbl_profile_addinfo2);
				 break;
			  
			  case "Logout":
				  Utility.click(obj_profile_logout);
				  Utility.explicitWait_VisibilityOfElement(obj_login_username_txf);
			    break;
			    
			  case "Save":
				  Utility.click(obj_profile_btn_save);
				  Utility.explicitWait_VisibilityOfElement(obj_lbl_profile_update_success_msg);
			    break;
			  
			  default:
			 
			}

		}
		
		//wait till are visible on page
		public void is_visilbe(String input)
		{
			switch(input) {
			  case "Basic":
				  	Utility.explicitWait_VisibilityOfElement(obj_lbl_basic_login);
					Utility.explicitWait_VisibilityOfElement(obj_lbl_basic_first_name);
					Utility.explicitWait_VisibilityOfElement(obj_lbl_basic_last_name);
				 break;
			  
			  case "Additional_Info1":
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_gender);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_age);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_address);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_phone);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_hobby);
			    break;
			  case "Additional_Info2":
				    Utility.explicitWait_VisibilityOfElement(obj_adtninfo_header_chngepwd);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_crntpwd);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_newpwd);
				    Utility.explicitWait_VisibilityOfElement(obj_lbl_adtninfo_cnfmpwd);
			    break;
			  
			  default:
			}
			 
		}
		
		// Enter details all fields under Addition_info1 
		public void update_additional_info1()
		{
			String gender = prop.getProperty("gender");
			String age = prop.getProperty("age");
			String address = prop.getProperty("address");
			String phone = prop.getProperty("phone");
			String hobby = prop.getProperty("hobby");
			
			Utility.click(obj_adtn_info_gender_drpdown);
			Utility.type_text(obj_adtn_info_gender_drpdown, gender);
			Utility.pause(2);
			
			List<WebElement> lst = driver.findElements(obj_gender_options);
			for (int i=0; i<lst.size(); i++)
			{
				if (lst.get(i).getAttribute("value") == "Female")
				{
					lst.get(i).click();
					break;
					// It will click Female and termiante loop
				}
			}
			
			Utility.type_text(obj_age_txf, age);
			Utility.type_text(obj_address_txf, address);
			Utility.type_text(obj_phone_txf, phone);
			Utility.select_drpdwn_by_visible_text(obj_hobby_drpdown,hobby);
			click_button("Save");
		}
		
		//Validate profile success message
		public void validate_user_profile()
		{
			Assert.assertEquals("The profile has been saved successful", Utility.getText(obj_lbl_profile_update_success_msg));
		}
		
		
		
		
}