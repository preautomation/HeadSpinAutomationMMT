package HeadSpinAutomationMMT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.KeysRelatedAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMMT1 extends ConfigureSetup {

	@BeforeClass
	public static void setupenvironment() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(liveEnv);
		System.out.println("===== Setup environment done=====");
		System.out.println("You are about to hit the url   : " + liveEnv);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	}

	public void Login() throws InterruptedException {

		//Login to the make my trip web-site with login details
		driver.findElement(By.xpath("//p[contains(text(),'Login or Create Account')]")).click();
		
		//Enter User-name field on the Login pop-up
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("prempandit4@gmail.com");
		
		//Click on Continue button
		new WebDriverWait(driver, 2000).until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[text()='Continue']"))).click();
		
		//Enter Password field on the Login pop-up
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys("30May2020@");
	}

	@Test
	public void searchHotel() throws InterruptedException {

		
		//Select Hotels Tab
		driver.findElement(By.cssSelector("span.chNavIcon.appendBottom2.chSprite.chHotels")).click();

		//Click on the City/Hotel/Area/Building drop-down
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(text(),'City / Hotel / Area / Building')]"))).click();

		//Enter Delhi in the City Selection drop down
		driver.findElement(By.xpath("//input[contains(@placeholder,'Enter city/ Hotel/ Area/ Building')]"))
				.sendKeys("Delhi");

		//Select the first element from the search
		driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();

		//Select a checking date from the date panel
		WebElement checking = driver.findElement(By.cssSelector("div[class='DayPicker-Day'][aria-label='Wed Jun 03 2020']"));
		WebElement webElement = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(checking));
		webElement.click();
		
		
		WebElement checkoutdate = driver.findElement(By.cssSelector("div[class='DayPicker-DayDayPicker-Day--selected'][aria-label='Sat Jun 06 2020']"));
		WebElement checkout = new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(checkoutdate));
		checkout.click();


	}

}
