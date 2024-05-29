package LambdaTest;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestScenario_3 {
	public static WebDriver driver;
	 @BeforeMethod
	  public void Open_Application() {
		 System.setProperty("WebDriver.chrome.driver", "C:\\Users\\TEJA MORA\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  
		  driver.get("https://www.lambdatest.com/selenium-playground");
	  }
    @Test
     public void Scenario_3() throws InterruptedException, IOException {
	    driver.findElement(By.xpath("//a[text()='Input Form Submit']")).click();
	    Thread.sleep(2000);
 	    driver.findElement(By.xpath("//button[text()='Submit']")).click();
 	      
 	    File S1 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T1 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.BeforeSliding.jpg");
		  FileHandler.copy(S1, T1);
		  
	    Thread.sleep(3000);
        driver.findElement(By.name("name")).sendKeys("Harsha");
        driver.findElement(By.id("inputEmail4")).sendKeys("harsha01254@gmail.com");
        driver.findElement(By.id("inputPassword4")).sendKeys("LambdaTest");
        driver.findElement(By.xpath("//input[@id='company']")).sendKeys("LambdaTest");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='websitename']")).sendKeys("Lambdatest.com");
        
       WebElement DropDown =driver.findElement(By.xpath("//select[@name='country']"));
        Select S = new Select(DropDown);
        Thread.sleep(3000);
        S.selectByVisibleText("India");
        
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Hyderbad");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='address_line1']")).sendKeys("1-63");
        driver.findElement(By.xpath("//input[@name='address_line2']")).sendKeys("Hyderbad");
        driver.findElement(By.xpath("//input[@id='inputState']")).sendKeys("Telegana");
        driver.findElement(By.xpath("//input[@id='inputZip']")).sendKeys("505528");
          File S2 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T2 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.BeforeSliding.jpg");
		  FileHandler.copy(S2, T2);
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
          File S3 = (( TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File T3 = new File("C:\\Users\\TEJA MORA\\Desktop\\Manual and automation classes\\ScreenShots_LT.BeforeSliding.jpg");
		  FileHandler.copy(S3, T3);
        
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//p[@class= 'success-msg hidden']")).getText());
        Thread.sleep(3000);
    } 
  
     @AfterMethod
      public void Quit() {
	  driver.quit();
         }

}
