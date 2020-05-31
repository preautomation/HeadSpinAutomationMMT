package HeadSpinAutomationMMT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigureSetup {

	public static WebDriver driver;

	  static String liveEnv = "https://www.makemytrip.com/";
	
	 public static void setupenvironment()
	  {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(liveEnv);
	    System.out.println("===== Setup environment done=====");
	    System.out.println("You are about to hit the url   : " + liveEnv);
	    driver.manage().window().maximize();
	  }

	 
	 
}
