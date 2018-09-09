package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class RegistrationPage {
SoftAssert softAssrt= new SoftAssert();
WebDriver Driver;

By Register = By.cssSelector("a[href^='mercuryregister.php?osCsid']");
By FirstName = By.cssSelector("input[name='firstName']");
By LastName = By.cssSelector("input[name='lastName']");
By Phone = By.cssSelector("input[name='phone']");
By Email = By.cssSelector("input[id='userName']");
By Address = By.cssSelector("input[name='address1']");
By City = By.cssSelector("input[name='city']");
By State = By.cssSelector("input[name='state']");
By PostalCode = By.cssSelector("input[name='postalCode']");
By Country = By.cssSelector("select[name='country']");
By Uname = By.cssSelector("input[name='email']");
By PWD = By.cssSelector("input[name='password']");
By CPWD = By.cssSelector("input[name='confirmPassword']");
By Submit = By.cssSelector("input[type='image']");
By Message = By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > p:nth-child(2) > font");


public void Registration(WebDriver Driver) {
		this.Driver = Driver;
	}

public void ExplicitWait(By Element, int timeout) {
	WebDriverWait Wt = new WebDriverWait(Driver,timeout);
	Wt.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Element));
}


public void ContactInformation_method1() {	
this.ExplicitWait(Register, 10000);	
Driver.findElement(Register).click();
Driver.findElement(FirstName).sendKeys("Krittika123");
Driver.findElement(LastName).sendKeys("Samanta");
Driver.findElement(Phone).sendKeys("604454678");
Driver.findElement(Email).sendKeys("rush2mona@gmail.com");
}

public void mailinginformation_method2() {
Driver.findElement(Address).sendKeys("Unit24Preston");
Driver.findElement(City).sendKeys("Melbourne");
Driver.findElement(State).sendKeys("Victoria");
Driver.findElement(PostalCode).sendKeys("3072");
Driver.findElement(Country).click();
WebElement List1 = Driver.findElement(Country);
Select SL = new Select(List1);
SL.selectByValue("1");	
		}


public void Userinformation_method3() throws InterruptedException {
Driver.findElement(Uname).sendKeys("Ashi123");
Driver.findElement(PWD).sendKeys("12345");
Driver.findElement(CPWD).sendKeys("12345");
Driver.findElement(Submit).click();

}

public void validateMessage() {
	this.ExplicitWait(Message, 1000);
	softAssrt.assertEquals(Driver.findElement(Message).getText(), "Thank you for registering. You may now sign-in using the user name and password you've just entered","Message Not Matching");
	softAssrt.assertAll();
	//assertEquals(Driver.findElement(Message).getText(), "Thank you for registering. You may now sign-in using the user name and password you've just entered","Message Not Matching");
}





}
	
	
	
