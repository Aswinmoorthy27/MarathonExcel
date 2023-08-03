package Marathon;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Baseclass {

	public ChromeDriver driver;

	@Parameters({ "URL", "UName", "PWD" })
	@BeforeMethod
	public void Url(String URL, String UName, String PWD) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(UName);
		driver.findElement(By.id("password")).sendKeys(PWD);
		driver.findElement(By.id("Login")).click();

	}

	public WebElement waitmethod(WebElement dotfield) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(dotfield));
	}

	public WebElement Action(WebElement intract) {
		Actions Action = new Actions(driver);
		Action.click(intract).perform();
		return intract;
	}

	public WebElement sendkeys(WebElement Sendkeys) {
		return sendkeys(Sendkeys);

	}
	
	public void verify(String current) 
	{
		String Actual="Home | Salesforce";
		if(Actual.equals(current)) 
		{
			System.out.println("Title Correct");
		}else 
		{
			System.out.println("Title not matched");
			
		}
	}
	
	@DataProvider
	public String[][] Excelsenddata() throws IOException 
	{
		return Excel.ReadExcel();
	}

	@AfterMethod
	public void closedriver() {
		driver.close();
		
	}
}
