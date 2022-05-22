package utilities;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {

    public static WebDriver driver = null;
    public static Properties prop;
    public static FileInputStream fis, fis1;
    static int PAGE_LOAD_TIMEOUT = 60;
	static int IMPLICIT_WAIT = 30;
    
    public static void load_properties()
    {
    	  try
    	  {
    	      prop = new Properties();
    		  fis = new FileInputStream("properties/config.properties");
    		  fis1 = new FileInputStream("properties/testdata.properties");
    		  prop.load(fis);
    		  prop.load(fis1);
    		 
    	  } catch (Exception e)
    	  {
    		  System.out.println(e.getMessage());
    	  }
    }

  public static void launch_Browser(){
    		
	  String browserName = prop.getProperty("browser");
	  System.out.println("browserName:" + browserName);
	  String root_directory = System.getProperty("user.dir");
	  
	  if (browserName.equalsIgnoreCase("chrome")) 
	  {
		  
		  System.setProperty("webdriver.chrome.driver", root_directory+"//libs//chromedriver.exe");
		  
		  Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("profile.default_content_setting_values.notifications", 2);
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", prefs);
		  options.addArguments("--disable-extensions");
		  options.addArguments("--disable-infobars");

		  driver = new ChromeDriver(options);
		  
		  System.out.println("Browser set to: "+browserName);
	  }
	  else if(browserName.equalsIgnoreCase("ie"))
	  {	
		  System.setProperty("webdriver.ie.driver", root_directory+"//libs//");
		  
		  driver=new InternetExplorerDriver();
		  System.out.println("BRowser set to: "+browserName);

	  }
	  else if (browserName.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", root_directory+ "//libs//geckodriver");
		  driver = new FirefoxDriver();
		  System.out.println("BRowser set to: "+browserName);
	  }
	  else
	  {
         System.setProperty("webdriver.chrome.driver", root_directory + "//libs//chromedriver");
		  
		  Map<String, Object> prefs = new HashMap<String, Object>();
		  prefs.put("profile.default_content_setting_values.notifications", 2);
		  prefs.put("credentials_enable_service", false);
		  prefs.put("profile.password_manager_enabled", false);
		  ChromeOptions options = new ChromeOptions();
		  options.setExperimentalOption("prefs", prefs);
		  options.addArguments("--disable-extensions");
		  options.addArguments("--disable-infobars");

		  driver = new ChromeDriver(options);
		  

		  System.out.println("Browser name is either incorrect or not present in Directory- Launching default browser: "+browserName);
	  }
	  driver.manage().deleteAllCookies();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	  driver.get(prop.getProperty("url"));
	  System.out.println("Launched URL over browser is:" + prop.getProperty("url"));
    }
    
    public static void close_Browser() {
    	driver.quit();
    }
}
