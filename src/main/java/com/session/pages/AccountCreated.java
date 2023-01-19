package com.session.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreated extends BasePage {
	
	private By logoutBtn = By.xpath("//ul[@class='side_account_list']/li/a[@href='https://automationteststore.com/index.php?rt=account/logout']");
	private By continueBtn = By.xpath("//a[@title='Continue']");
	private By errorMessage = By.xpath("//div[@class='alert alert-error alert-danger']");
	
	public String getErrorText() {
		return getElement(errorMessage).getText();
	}
	
	public AccountCreated(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		if (!driver.getTitle().equals("Your Account Has Been Created!")) {
			throw new IllegalStateException(
					"Account is not created " );
		}
	

	}
	
	public  void logout() {
		getElement(logoutBtn).click();
		getElement(continueBtn).click();
	}

	
	
}
