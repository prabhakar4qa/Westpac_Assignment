package stepDefinitions;

import io.cucumber.java.en.*;
import pages.login_page;
import pages.registeration_page;
import utilities.Base;

public class Login_StepDef extends Base{

	login_page loginpage = new login_page();
	registeration_page regstpage = new registeration_page();
	
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	
	
	@When("^I enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void buggy_application_login(String username, String password){
		loginpage.enter_details(username, password);
	   
	}
	
	@Then("^I validate that the user \"([^\"]*)\" able to login$")
	public void i_validate_that_the_user_able_to_login(String input) {
		
		boolean visible = (input.equals("is")) ? true : false;
		loginpage.validate_user_login(visible);  
	}
	
	@Then("^I log into buggy application with valid credentials$")
	public void i_log_into_buggy_application_with_valid_credentials() {
		String username = USERNAME;
		String password = PASSWORD;
		loginpage.enter_details(username, password);
		regstpage.click_button("Login");
	    
	}
	
	@Then("^I log into buggy application with new user every time$")
	public void login_with_new_user()
	{
		regstpage.click_button("Register");
		regstpage.new_user_registration();
		regstpage.click_button("Cancel");
		
		String username = regstpage.user_name;
		String password = regstpage.password;
		loginpage.enter_details(username, password);
		regstpage.click_button("Login");
	}
	
	@And("^I Logout from the application$")
	public void logout_app()
	{
		loginpage.validate_user_logout();
	}
	
}
