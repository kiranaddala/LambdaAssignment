package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScenario3 {

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
		@When("Fill the Form and submit")
		public void Fill_the_Form() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement SubmitButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"seleniumform\"]/div[6]/button")));
			
				
			SubmitButton.click();
			
			String message = driver.findElement(By.name("name")).getAttribute("validationMessage"); 
			System.out.println(message);
			
			Thread.sleep(60);
			String FirstName ="Kiran";
			String Email ="Kiranaddala99@gmail.com";
			String Pass ="Password";
			String Company ="Wipro";
			String Website ="Website";
			String City ="NY";
			String Address1 ="Bank Streat";
			String Address2 ="Near AIG";
			String State ="New york";
			String ZipCode = "500089";
			
			
			driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys(FirstName);
			driver.findElement(By.xpath("//*[@id=\"inputEmail4\"]")).sendKeys(Email);
			driver.findElement(By.xpath("//*[@id=\"inputPassword4\"]")).sendKeys(Pass);
			driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys(Company);
			driver.findElement(By.xpath("//*[@id=\"websitename\"]")).sendKeys(Website);
		//	driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[3]/div[1]/select")).click();
			Select Country = new Select(driver.findElement(By.xpath("//*[@id=\"seleniumform\"]/div[3]/div[1]/select")));
			Country.selectByVisibleText("United States");
			
			driver.findElement(By.xpath("//*[@id=\"inputCity\"]")).sendKeys(City);
			driver.findElement(By.xpath("//*[@id=\"inputAddress1\"]")).sendKeys(Address1);
			driver.findElement(By.xpath("//*[@id=\"inputAddress2\"]")).sendKeys(Address2);
			driver.findElement(By.xpath("//*[@id=\"inputState\"]")).sendKeys(State);
			driver.findElement(By.xpath("//*[@id=\"inputZip\"]")).sendKeys(ZipCode);
			
			SubmitButton.click();
			
			String T = "Thanks for contacting us, we will get back to you shortly.t";
			
			 if ( driver.getPageSource().contains("Thanks for contacting us, we will get back to you shortly.")){
		         System.out.println("Text: " + T + " is present. ");
		      } else {
		         System.out.println("Text: " + T + " is not present. ");
		      }
			
		}
}
