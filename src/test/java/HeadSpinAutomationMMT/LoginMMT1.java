package HeadSpinAutomationMMT;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
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
	}

	@Test
	public void Login() throws InterruptedException {

		// p[contains(text(),'Login or Create Account')]
		driver.findElement(By.xpath("//p[contains(text(),'Login or Create Account')]")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("prempandit4@gmail.com");
		new WebDriverWait(driver, 2000)
		 .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Continue']"))).click();

		
		
		driver.findElement(By.xpath("//span[text()='Continue']")).click();
		//driver.findElement(By.cssSelector("button.capText")).click();
		// new WebDriverWait(driver,
		// 20).until(ExpectedConditions.invisibilityOf(element)(By.xpath("//span[text()='Continue']"))).click();
		
		// driver.findElement(By.xpath("//button[@data-cy='continueBtn']")).click();
		driver.findElement(By.name("pwd")).clear();
		driver.findElement(By.name("pwd")).sendKeys("30May2020@");
	}

	@Test
	public void searchHotel() throws InterruptedException {

		driver.findElement(By.cssSelector("span.chNavIcon.appendBottom2.chSprite.chHotels")).click();
		Thread.sleep(2000);
		String from = "Goa";
		String to = "Bangalore";
		driver.findElement(By.xpath("(//li[@aria-label='Top Cities : " + from + ", India '])[1]")).click();
		driver.findElement(By.xpath("(//li[@aria-label='Top Cities : " + to + ", India '])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("26")).click();
		driver.findElement(By.cssSelector("input[id='hp-widget__return']")).click();
		driver.findElement(By.linkText("29")).click();
		driver.findElement(By.id("hp-widget__paxCounter_pot")).click();
		driver.findElement(By.id("business")).click();
		driver.findElement(By.xpath("//a[@class='close_pax pull-right']")).click();
		driver.findElement(By.xpath("//button[@id='searchBtn']")).click();
		System.out.println(driver.getTitle());
	}

}
