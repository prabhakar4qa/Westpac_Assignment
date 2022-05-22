package stepDefinitions;
import io.cucumber.java.en.*;
import pages.login_page;
import pages.registeration_page;
import utilities.Base;

public class Registeration_StepDef extends Base{
	

	registeration_page buggypage = new registeration_page();
	
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	
	
	@Given("^I launch the buggy application in a browser$")
	public void launch_application()
	{
		Base.launch_Browser(); 
	}
	@When("^I am on buggy rating screen$")
	public void buggy_rating_screen()
	{
		buggypage.is_visilbe("buggy_dashboard_page") ;
	}
	
	@Then ("^I click \"([^\"]*)\" from the buggy rating screen$")
	public void click_options(String option)
	{
		buggypage.click_button(option);
	}
	
	@When ("^I am on buggy rating registration screen$")
	public void buggy_rating_registeration_screen()
	{
		buggypage.is_visilbe("buggy_registeration_page") ;
	}
	
	@And ("^I enter the valid details and complete the sign up$")
	public void complete_registration()
	{
		buggypage.new_user_registration();
	}
	
	@Then ("^I validate the registration success message for new user$")
	public void validate_user_registeration()
	{
		buggypage.validate_user_registeration_success();
	}
	
}
