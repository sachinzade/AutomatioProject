package com.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import com.pages.CatlogPage;
import com.pages.CheckoutPage;
import com.utilities.MethodsUtility;

public class CheckoutPageTest extends BaseClass {

	CatlogPage catlogPage;
	CheckoutPage checkoutPage;
	String product = "zara coat 3";
	String country = "India";
	String successMsg = "THANKYOU FOR THE ORDER.";

	@BeforeClass
	public void setUp() throws Exception {
		intialization();
		checkoutPage = loadlogInPage()
				.navigateToCatlogPage(MethodsUtility.readProperty("userName"), MethodsUtility.readProperty("password"))
				.navigateToCheckoutPage(driver);
		catlogPage = new CatlogPage(driver);
	}

	@Test
	public void userShouldBuytheProduct() {
		Assert.assertTrue(checkoutPage.clickOnBuyNow(country, successMsg));
	}

	@AfterClass
	public void tearDown() {
		MethodsUtility.closeBrowser();
	}
}
