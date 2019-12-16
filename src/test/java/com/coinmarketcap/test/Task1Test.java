package com.coinmarketcap.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.coinmarketcap.Base.TestBase;
import com.coinmarketcap.pages.Task1;

public class Task1Test extends TestBase {

	static Task1 task1;

	public Task1Test() {
		super();
	}

	@BeforeMethod
	public void setup() {
		Initialization();
		task1 = new Task1();
	}

	@Test(priority = 1)
	public void clickOnViewAllLinkTest() throws InterruptedException {
		task1.clickOnViewAllLink();
		task1.clickOnBack_toTop100();
		 

	}

 

}
