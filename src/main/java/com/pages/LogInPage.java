package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	WebDriver driver;

	public LogInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement pass;

	@FindBy(id = "login")
	WebElement logIn;

	public CatlogPage navigateToCatlogPage(String userNAme, String password) {
		email.sendKeys(userNAme);
		pass.sendKeys(password);
		logIn.click();
		return new CatlogPage(driver);
	}
}
