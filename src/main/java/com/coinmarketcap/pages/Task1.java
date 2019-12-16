package com.coinmarketcap.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.coinmarketcap.Base.TestBase;

public class Task1 extends TestBase {

	//page Factory or object repository 
	
	 @FindBy(how = How.LINK_TEXT, using = "View All")
	    private WebElement lnk_ViewAll;
	
	 @FindBy( xpath =("//a[contains(text(),'← Back to Top 100')]"))
	    private WebElement  Back_toTop100;
	
	//initialization page object
	public Task1()
	{
		PageFactory.initElements(driver, this);
	}
	public String VerifyHomePageTitle ()
	{
		return driver.getTitle();
	}
 
    public void clickOnViewAllLink() throws InterruptedException {
    	lnk_ViewAll.click();
        waitforElementThenClick(driver,lnk_ViewAll);
    }
	 
    public void clickOnBack_toTop100() throws InterruptedException {
    	Back_toTop100.click();
        waitforElementThenClick(driver,Back_toTop100);
    }
	
	
}
