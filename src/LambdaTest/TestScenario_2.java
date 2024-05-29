package LambdaTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScenario_2 {
	public static WebDriver driver;
	 @BeforeMethod
	 public void Open_Application() {
	     System.setProperty("WebDriver.chrome.driver", "C:\\Users\\TEJA MORA\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		  driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://www.lambdatest.com/selenium-playground");
		 }
	  @Test
	  public void Scenario_2() throws InterruptedException, IOException {
		  driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();
		  File S1 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T1 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.Homepage.jpg");
		  FileHandler.copy(S1, T1);
		  WebElement slider = driver.findElement(By.xpath("//input[@type='range' and @value='15']"));
	      
		  Thread.sleep(3000);

	      JavascriptExecutor js = (JavascriptExecutor) driver;
	      
	      js.executeScript("arguments[0].value = arguments[1];", slider, "95");
	      
	      File S2 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T2 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.Homepage.jpg");
		  FileHandler.copy(S2, T2);
	      
	      int finalValue = Integer.parseInt(slider.getAttribute("value"));
	      Assert.assertEquals(finalValue, 95);
	      Thread.sleep(3000);
	  }
	     @AfterMethod
	      public void Quit() {
		  driver.quit();
	         }
	}



