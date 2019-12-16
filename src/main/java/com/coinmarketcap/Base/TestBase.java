package com.coinmarketcap.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.coinmarketcap.Utils.Testutils;

public class TestBase 
{

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() 
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream( "src\\main\\java\\com\\coinmarketcap\\config\\Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  public static void Initialization ()
  {
	 String browserName = prop.getProperty("browser");
	 if (browserName.equals("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver","src\\drivers\\chromedriver.exe");
	     driver = new ChromeDriver();
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(Testutils.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(Testutils.IMPLICIT_WAIT , TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));
  }
  public static String getTitle() {
      return driver.getTitle();
  }

  public static void waitforElementThenClick(WebDriver driver, WebElement element) throws InterruptedException {
      try {
          WebDriverWait wait = new WebDriverWait(driver, 20);
          wait.until(ExpectedConditions.elementToBeClickable(element));
          element.click();
      } catch (Exception e) {
      }

  }

  public static void waitforElementToBeVisible(WebDriver driver, String element) throws InterruptedException {
      try {
          WebDriverWait wait = new WebDriverWait(driver, 20);
          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
      } catch (Exception e) {
      }

  }
}

