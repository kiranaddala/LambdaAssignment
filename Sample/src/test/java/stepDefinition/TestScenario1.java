package stepDefinition;


import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.util.Xls_Reader;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario1 {
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
		driver.get("https://www.lambdatest.com/selenium-playground");
		Thread.sleep(30);
	}
	@Test (priority = 2)
	@When("click on simple form")
	public void click_on_simple_form() throws InterruptedException {
		
		WebElement SimpleForm  = driver.findElement(By.xpath("//a[@href='https://www.lambdatest.com/selenium-playground/simple-form-demo']"));
		
		SimpleForm.click();
		System.out.println(SimpleForm.getText());
		Thread.sleep(30);
	}
	
	@Test (priority = 3)
	@Then("Enter Message")
	public void Enter_Message() throws InterruptedException{
		
		WebElement EnterText =	driver.findElement(By.xpath("//input[@id='user-message']"));
		String Val = "Welcome to LambdaTest" ;
		
		EnterText.sendKeys(Val);
		Thread.sleep(30);
	}
	
	@Test(priority = 4)
	@Then("Click on Get Checked Value")
		public void Click_on_Get_Checked_Value() {
		
		WebElement Clickbutton =	driver.findElement(By.xpath("//button[@id='showInput']"));
		
		Clickbutton.click();
		
		String T = "Welcome to LambdaTest";
		
		 if ( driver.getPageSource().contains("Welcome to LambdaTest")){
	         System.out.println("Text: " + T + " is present. ");
	      } else {
	         System.out.println("Text: " + T + " is not present. ");
	      }
		
	}
}