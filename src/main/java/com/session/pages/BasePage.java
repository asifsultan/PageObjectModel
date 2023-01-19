package com.session.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	}

	public String getTitle() {

		return driver.getTitle();

	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public void waitForWebElementPresent(By loctor) {
		wait.until(ExpectedConditions.presenceOfElementLocated(loctor));

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			waitForWebElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception ex) {

			System.out.println("Not able to find element" + locator.toString());
			return element;

		}

	}

	public Select selectElement(By locator) {
		Select item = null;
		try {
			// waitForWebElementPresent(locator);
			item = new Select(getElement(locator));
			return item;
		} catch (Exception ex) {

			System.out.println("Not able to find element" + locator.toString());
			return item;

		}

	}

	public boolean getElements(By locator) {
		if (driver.findElements(locator).size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
	//!driver.findElements(By.id("...")).isEmpty()

}
