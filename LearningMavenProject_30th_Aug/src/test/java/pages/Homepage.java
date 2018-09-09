package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
WebDriver Driver;

By Username = By.cssSelector("input[name='userName']");
By Password = By.cssSelector("input[name='password']");
By Signin = By.cssSelector("input[name='login']");

By TripType = By.cssSelector("input[name='tripType']");
By Signoff = By.linkText("SIGN-OFF");
	
	public void Homepage(WebDriver Driver) {
		this.Driver = Driver;
	}
	
	public void Navigateto() {
		Driver.get("http://www.demoaut.com/");
	}
	
	public void UserSignin(String Uname,String Pwd) {
		Driver.findElement(Username).sendKeys(Uname);
		Driver.findElement(Password).sendKeys(Pwd);
		Driver.findElement(Signin).click();
	}
	
	public boolean TripType() {
		boolean result = Driver.findElement(TripType).isDisplayed();
		return result;
	}
}
