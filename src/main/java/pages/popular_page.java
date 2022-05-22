package pages;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.Base;
import utilities.Utility;

public class popular_page extends Base {	
	Utility utl = new Utility();
	
	//Objects
	private static By obj_lbl_popular_model = By.xpath("//h2[text()='Popular Model']");
	private static By obj_img_model = By.xpath("//a[contains(@href,'model')]/img");
	private static By obj_lbl_popular_make = By.xpath("//h2[text()='Popular Make']");
	private static By obj_img_make = By.xpath("//a[contains(@href,'make')]/img");
	private static By obj_lbl_overall_rating = By.xpath("//h2[text()='Overall Rating']");
	private static By obj_img_rating = By.xpath("//a[contains(@href,'overall')]/img");
	private static By obj_link_Buggy_Rating = By.linkText("Buggy Rating");
	
	private static By obj_votes_make = By.xpath("//*[text()='Popular Make']/following:: small[contains(text(),'votes')]");
	private static By obj_votes_model = By.xpath("//*[text()='Popular Model']/following:: small[contains(text(),'votes')]");
	private static By obj_model_speciation = By.xpath("//h4[text()='Specification']/following::ul/li");
	private static By obj_img_model_type = By.xpath("//div[@class='card-block']/a/img");
	private static By obj_model_title_in_detailedview = By.xpath("//div/h4[text()='Lamborghini']");
	private static By obj_txf_your_comments = By.id("comment");
	private static By obj_btn_vote = By.xpath("//button[text()='Vote!']");
	private static By obj_header_thanks_for_vote = By.xpath("//p[text()='Thank you for your vote!']");
	private static By obj_votes_after_voting = By.xpath("//div/h4/strong");
	
	private static By obj_rating_link_make = By.linkText("Make");
	private static By obj_rating_link_model = By.linkText("Model");
	private static By obj_rating_link_rank = By.linkText("Rank");
	private static By obj_rating_link_votes = By.linkText("Votes");
	private static By obj_rating_link_engine = By.linkText("Engine");
	private static By obj_rating_header_comments = By.xpath("//th[text()='Comments']");
	private static By obj_all_make_links = By.xpath("//a[contains(@href, '/make')]");
	private static By obj_imge_model = By.xpath("//td[@class='thumbnail']/a/img");
	
	
	
	public int total_model_votes = 0;
	public int total_make_votes = 0;
	String comment_text = prop.getProperty("popular_model_comment");
	
	//Click based on input
	public void click_button(String option)
	{
		Utility.click(obj_link_Buggy_Rating);
		switch(option) {
		  case "Popular Model":
			  	Utility.click(obj_img_model);
			 break;
		  
		  case "Popular Make":
			  	Utility.click(obj_img_make);
		    break;
		    
		  case "Overall Rating":
			  	Utility.click(obj_img_rating);
		    break;
		  default:
		 
		}
	}
	
	//It will retun votes based on item
	public int get_votes(String input)
	{
		int total_votes = 0;
		if (input.equals("Popular Model"))
		{
			Utility.explicitWait_VisibilityOfElement(obj_lbl_popular_model);
			String model_votes = Utility.getText(obj_votes_model).replaceAll("\\D+", "");   
			total_votes = Integer.parseInt(model_votes);
			  
		}
		else if (input.equals("Popular Make"))
		{
			Utility.explicitWait_VisibilityOfElement(obj_lbl_popular_make);
			String make_votes = Utility.getText(obj_votes_make).replaceAll("\\D+", ""); 
			total_votes = Integer.parseInt(make_votes);
		}
		System.out.println("Total Votes for" + input +":::" +total_votes);
		
		return total_votes;
	}
	
	public void validate_details_for_model()
	{
		Utility.explicitWait_VisibilityOfElement(obj_model_speciation);
		Utility.explicitWait_VisibilityOfElement(obj_img_model_type);
		Utility.explicitWait_VisibilityOfElement(obj_model_title_in_detailedview);
		List<WebElement> ls = driver.findElements(obj_model_speciation);
		
		ArrayList<String> arrlist=new ArrayList<String>();
		
		for (int i=0; i<ls.size();i++)
		{
			arrlist.add(ls.get(i).getText());
		}
		System.out.println("List is:" + arrlist);
		
		Iterator<String> itr=arrlist.iterator();//getting the Iterator  
		  while(itr.hasNext()){//check if iterator has the elements  
		   String option = itr.next();
		    if (option.contains("Engine"))
		    {
		    	Assert.assertTrue(option.contains("Engine"));
		    }
		    else
		    {
		    	Assert.assertTrue(option.contains("Max Speed"));
		    }
		  }		 	  
	}
	
	public void validate_details_for_rating()
	{
		Utility.explicitWait_VisibilityOfElement(obj_rating_link_make);
		Utility.explicitWait_VisibilityOfElement(obj_rating_link_model);
		Utility.explicitWait_VisibilityOfElement(obj_rating_link_rank);
		Utility.explicitWait_VisibilityOfElement(obj_rating_link_votes);
		Utility.explicitWait_VisibilityOfElement(obj_rating_link_engine);
		Utility.explicitWait_VisibilityOfElement(obj_rating_header_comments);
	}
	
	public void vote_for_model()
	{
		  Utility.type_text(obj_txf_your_comments, comment_text);
		  Utility.click(obj_btn_vote);
		  Utility.explicitWait_VisibilityOfElement(obj_header_thanks_for_vote);
	}
	
	public void validate_votes(int votes_before)
	{
		String votes_after = Utility.getText(obj_votes_after_voting);
		System.out.println("votes Before:" + votes_before + "After:"+ votes_after);
		
		Assert.assertEquals(votes_before + 1, Integer.parseInt(votes_after));
		Utility.pause(2);
	}
	
	public void validate_screen_navigations()
	{
		List<WebElement> all_model = driver.findElements(obj_all_make_links);
		ArrayList<String> models = new ArrayList<String>();
		for(int i = 0; i<all_model.size(); i++)
		{
			models.add(all_model.get(i).getText());
		}
		
		System.out.println(models);
		for (int i=0; i < models.size(); i++)
		{
			 Utility.explicitWait_VisibilityOfElement(By.linkText(models.get(i)));
			 driver.findElement(By.linkText(models.get(i))).click();
			 Utility.explicitWait_VisibilityOfElement(By.xpath("//h3[text()= '"+ models.get(i) +"' ]"));
			 driver.navigate().back();
			 
		}
	}
	
		
}