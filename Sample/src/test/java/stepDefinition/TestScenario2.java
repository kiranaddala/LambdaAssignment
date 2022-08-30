package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

public class TestScenario2 {

	static WebDriver driver;
	@Parameters("browser")
	@Test (priority = 1)
	@Given("The user launch the browser and url {string}")
	public void the_user_launch_the_browser_and_url(String browser) throws InterruptedException {
	    
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new FirefoxDriver();
		
			System.out.println("Please pass correct browser value:" + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.lambdatest.com/selenium-playground/input-form-demo");
		Thread.sleep(30);
	}
	
	@Test (priority = 2)
	@When("click on Drag and Drop")
	public void click_on_Drag_and_Drop() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ProgressBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[1]/div[4]/p")));
		
			
		ProgressBar.click();
		Thread.sleep(60);
		
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div/section[3]/div/div/div[1]/div[4]/ul/li[3]/a")).click();
		
	}
	
	@Test (priority = 3)
	@When("Increase the Bar")
	public void Increase_the_Bar() throws InterruptedException {
        
		WebElement Drag  = driver.findElement(By.xpath("//*[@id=\"slider3\"]/div/input"));
		Thread.sleep(1000);
		for (int i = 15; i <= 94 ; i++) {
			Drag.sendKeys(Keys.ARROW_RIGHT);
        }
	}
}
