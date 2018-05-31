import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.ResourceUtils;

public class SimpleTest {
	WebDriver driver;
	@Before
	public void LaunchBrowser()
	{
		
		try 
		{
			File chromedriverFile=ResourceUtils.getFile("classpath:chromedriver");			
			chromedriverFile.setExecutable(true);
			
			System.setProperty("webdriver.chrome.driver", ResourceUtils.getFile("classpath:chromedriver").getAbsolutePath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.driver= new ChromeDriver();
		
	}
	@Test
	public void SimpleTestScenario()
	{
		driver.get("https://www.pimco.com");
		WebDriverWait wait= new WebDriverWait(driver, 10, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='Individual']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='View All Product']"))).click();
		
		//table[@id='performance']/tbody/tr/td[@data-attr-name='AssetClass']/p/a[text()='Dividend and Income Fund']
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='performance']/tbody/tr/td[@data-attr-name='AssetClass']/p/a[text()='Dividend and Income Fund']"))).click();
		
		System.out.println(driver.getCurrentUrl());
	}
	
	@After
	public void CloseBrowser()
	{
		driver.quit();
	}
	
}
