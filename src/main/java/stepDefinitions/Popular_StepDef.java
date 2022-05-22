package stepDefinitions;

import io.cucumber.java.en.*;
import pages.login_page;
import pages.popular_page;
import pages.registeration_page;
import utilities.Base;


public class Popular_StepDef extends Base{
	
	login_page loginpage = new login_page();
	registeration_page regstpage = new registeration_page();
	popular_page ppage = new popular_page();
	
	
	String USERNAME = prop.getProperty("username");
	String PASSWORD = prop.getProperty("password");
	int votes_before = 0;
	
	@Given("^I click on the item under \"([^\"]*)\"$")
	public void i_click_on_the_item_under(String string) {
		votes_before = ppage.get_votes("Popular Model");
		ppage.click_button(string);
	}
	
	@When("I am on popular model screen")
	public void i_am_on_popular_model_screen() {
	  ppage.validate_details_for_model();  
	}
	
	@Then("I vote for the model")
	public void i_vote_for_the_model() {
		ppage.vote_for_model();	
	}
	
	@Then("I validate the vote count updated for the model")
	public void i_validate_the_vote_count_updated_for_the_model() {
		ppage.validate_votes(votes_before);
	}
	
	@When("I am on Overall Rating screen")
	public void i_am_on_overall_rating_screen() {
		ppage.validate_details_for_rating();  
	}
	
	@Then("I validate the user is able to navigate each model and make from rating screen")
	public void i_validate_the_user_is_able_to_navigate_each_model_and_make_from_rating_screen() {
	  
		ppage.validate_screen_navigations(); 
	}
}
