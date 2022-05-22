package stepDefinitions;

import io.cucumber.java.en.*;
import pages.login_page;
import pages.registeration_page;
import pages.user_profile_page;
import utilities.Base;

public class User_Profile_StepDef extends Base{
	login_page loginpage = new login_page();
	registeration_page buggypage = new registeration_page();
	user_profile_page uprfile = new user_profile_page();
	
	@Given("^I Click on \"([^\"]*)\" from menu screen$")
	public void i_Click_on_from_menu_screen(String arg1)  {
		uprfile.click_button("Profile");
	}


	@When("^I am on the edit profile page$")
	public void i_am_on_the_edit_profile_page() {
		uprfile.is_visilbe("Basic");
		uprfile.is_visilbe("Additional_Info1");
		uprfile.is_visilbe("Additional_Info2");
	}

	@Then("^I update additional info fields gender, age, address, phone and hobby$")
	public void i_update_additional_info_fields_gender_age_address_phone_and_hobby() {
		uprfile.update_additional_info1();
	}

	@Then("^I validate changes are saved or not$")
	public void i_validate_changes_are_saved_or_not() {
		uprfile.validate_user_profile();
	}
		
}
