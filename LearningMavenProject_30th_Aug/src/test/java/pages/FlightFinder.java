package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightFinder {
WebDriver Driver;

By Home = By.linkText("Home");
By FlightFinderImage= By.cssSelector("img[src='/images/masts/mast_flightfinder.gif']");

			
public void FightFinder(WebDriver Driver) {
	this.Driver = Driver;
}

public void ExplicitWait(By Element, int timeout) {
	WebDriverWait Wt = new WebDriverWait(Driver,timeout);
	Wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Element));
}


public boolean successloginValidation() {
	this.ExplicitWait(FlightFinderImage, 10000);
	return Driver.findElement(FlightFinderImage).isDisplayed();
}

public void FightDetails_Method1() {
Driver.findElement(Home).click();
}
}

