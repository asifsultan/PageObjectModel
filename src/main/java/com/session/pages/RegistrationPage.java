package com.session.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By loginLink = By.xpath("//a[text()='Login or register']");
	private By continueBtn = By.xpath("//button[@title ='Continue']");

	////////////////////// Sign up page locators//////////////////
	private By firstName = By.id("AccountFrm_firstname");
	private By lastName = By.id("AccountFrm_lastname");
	private By email = By.id("AccountFrm_email");
	private By telephone = By.id("AccountFrm_telephone");
	private By fax = By.id("AccountFrm_fax");
	private By company = By.id("AccountFrm_company");
	private By address1 = By.id("AccountFrm_address_1");
	private By city = By.id("AccountFrm_city");
	private By zip = By.id("AccountFrm_postcode");
	private By state = By.id("AccountFrm_zone_id");
	private By country = By.id("AccountFrm_country_id");
	private By loginName = By.id("AccountFrm_loginname");
	private By password = By.id("AccountFrm_password");
	private By confimPass = By.id("AccountFrm_confirm");
	private By check = By.xpath("//input[@name='agree']");
	private By errorMessage = By.xpath("//div[@class='alert alert-error alert-danger']");
	private By homePageSignup = By.xpath("//a[text()='Home']");

	public WebElement getLoginLink() {
		return getElement(loginLink);
	}

	public WebElement getHomePage() {
		return getElement(homePageSignup);
	}
	public WebElement getContinueBtn() {
		return getElement(continueBtn);
	}

	public WebElement getFirstName() {
		return getElement(firstName);
	}

	public WebElement getLastName() {
		return getElement(lastName);
	}

	public WebElement getEmail() {
		return getElement(email);
	}

	public WebElement getTelephone() {
		return getElement(telephone);
	}

	public WebElement getFax() {
		return getElement(fax);
	}

	public WebElement getCompany() {
		return getElement(company);
	}

	public WebElement getAddress1() {
		return getElement(address1);
	}

	public WebElement getCity() {
		return getElement(city);
	}

	public WebElement getZip() {
		return getElement(zip);
	}

	public Select getState() {
		return selectElement(state);
	}

	public Select getCountry() {
		return selectElement(country);
	}

	public WebElement getLoginName() {
		return getElement(loginName);
	}

	public WebElement getPassword() {
		return getElement(password);
	}

	public WebElement getConfimPass() {
		return getElement(confimPass);
	}

	public WebElement getCheck() {
		return getElement(check);
	}

	public String getErrorMessage() {
		return getElement(errorMessage).getText();
	}

	public boolean checkErrorMessage() {
		return getElements(errorMessage);
	}
	public AccountCreated fillRegistrationForm(String fName, String lName, String emailD, String telephoneD,
			String faxD, String companyD, String addressD, String zipD, String cityD, String countryD, String stateD,
			String loginND, String passD, String confirmD) {

		getLoginLink().click();
		getContinueBtn().click();

		getFirstName().sendKeys(fName);
		getLastName().sendKeys(lName);
		getEmail().sendKeys(emailD);
		getTelephone().sendKeys(telephoneD);
		getFax().sendKeys(faxD);
		getCompany().sendKeys(companyD);
		getAddress1().sendKeys(addressD);
		getZip().sendKeys(zipD);
		getCity().sendKeys(cityD);
		getState().selectByVisibleText(stateD);
		getCountry().selectByVisibleText(countryD);
		getLoginName().sendKeys(loginND);
		getPassword().sendKeys(passD);
		getConfimPass().sendKeys(confirmD);

		getCheck().click();
		getContinueBtn().click();

//		if (!driver.getTitle().equals("Your Account Has Been Created!")) {
//			throw new IllegalStateException("Account is not created " + getErrorMessage());
//		} else {
//			return new AccountCreated(driver);
//		}
		if (checkErrorMessage()) {
			throw new IllegalStateException("Account is not created " + getErrorMessage());
		} else {
			return new AccountCreated(driver);
		}
		

	}

}
