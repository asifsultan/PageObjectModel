package com.session.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.session.constants.AppConstants;
import com.session.pages.AccountCreated;
import com.session.pages.RegistrationPage;
import com.session.utilities.ExcelHelper;

public class MainTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		ExcelHelper excel = new ExcelHelper("D:\\Automation scripts\\data.xlsx");

		int rowCount = excel.getTotalRows("login");
		System.out.println("Row count: " + rowCount);
		int columns = excel.getTotalColumns("login", 1);
		System.out.println("column count: " + columns);

		RegistrationPage register = new RegistrationPage(driver);

		for (int i = 1; i <= rowCount; i++) {
			try {
				driver.get("https://automationteststore.com/");
				System.out.println("Registration Page url: "+register.getUrl());
				System.out.println("Registration Page title: "+ register.getTitle());
				AccountCreated  created = register.fillRegistrationForm(excel.getStringData("login", i, 0), excel.getStringData("login", i, 1),
						excel.getStringData("login", i, 2), excel.getStringData("login", i, 3),
						excel.getStringData("login", i, 4), excel.getStringData("login", i, 5),
						excel.getStringData("login", i, 6), excel.getStringData("login", i, 7),
						excel.getStringData("login", i, 8), excel.getStringData("login", i, 9),
						excel.getStringData("login", i, 10), excel.getStringData("login", i, 11),
						excel.getStringData("login", i, 12), excel.getStringData("login", i, 13)
						
						);
				System.out.println("Acccount created Page url: "+created.getUrl());
				System.out.println("Account created Page title: "+ created.getTitle());
					
				created.logout();
				excel.writeData("login", i, 14, "Pass");
				excel.writeData("login", i, 15, AppConstants.REGISTERED_SUCCESS_PAGE_TITLE );
			
				
				System.out.println("Test execution for user " + excel.getStringData("login", i, 0) + " is sucessful");

			} catch (Exception e) {
				excel.writeData("login", i, 14, "Fail");
				excel.writeData("login", i, 15, AppConstants.ERROR_IN_ACOUNT_CREATION );
				e.printStackTrace();
			}
		}

	}

}

//driver.findElement(Locators.firstName).sendKeys(excel.getStringData("login", i, 0));
//driver.findElement(Locators.lastName).sendKeys(excel.getStringData("login", i, 1));
//driver.findElement(Locators.email).sendKeys(excel.getStringData("login", i, 2));
//driver.findElement(Locators.telephone).sendKeys(excel.getStringData("login", i, 3));
//driver.findElement(Locators.fax).sendKeys(excel.getStringData("login", i, 4));
//driver.findElement(Locators.company).sendKeys(excel.getStringData("login", i, 5));
//driver.findElement(Locators.address1).sendKeys(excel.getStringData("login", i, 6));
//driver.findElement(Locators.zip).sendKeys(excel.getStringData("login", i, 7));
//driver.findElement(Locators.city).sendKeys(excel.getStringData("login", i, 8));
//Select countryFill = new Select(driver.findElement(Locators.country));
//countryFill.selectByVisibleText(excel.getStringData("login", i, 9));
//
//
//driver.findElement(Locators.loginName).sendKeys(excel.getStringData("login", i, 11));
//driver.findElement(Locators.password).sendKeys(excel.getStringData("login", i, 12));
//Select stateFill = new Select(driver.findElement(Locators.state));
//stateFill.selectByVisibleText(excel.getStringData("login", i, 10));
//driver.findElement(Locators.confimPass).sendKeys(excel.getStringData("login", i, 13));
//driver.findElement(Locators.check).click();
//driver.findElement(Locators.continueBtn).click();
