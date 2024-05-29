package LambdaTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario_1 {
	public static WebDriver driver;
	@BeforeMethod
	  public void Open_Application() {
      System.setProperty("WebDriver.chrome.driver", "C:\\Users\\TEJA MORA\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.lambdatest.com/selenium-playground");
	  }
     @Test
  public void Scenario_1() throws IOException {
	  
	  driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();
		  File S1 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.jpg");
		  FileHandler.copy(S1, T);
	  System.out.println(driver.findElement(By.xpath("//h1")).getText()); 
	  
	  String S = "Welcome to LambdaTest";
	  
	  driver.findElement(By.id("user-message")).sendKeys(S);
	  driver.findElement(By.xpath("//button[@id = 'showInput']")).click();
	  File S2 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  File T2 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\After_LT.jpg");
	  FileHandler.copy(S2, T2);
	  System.out.println("Validated same text message is displayed in the right-hand panel that message is: "+driver.findElement(By.xpath("//p[@id = 'message']")).getText());
	 }
      @AfterMethod
      public void Quit() {
        driver.quit();
      }
}
