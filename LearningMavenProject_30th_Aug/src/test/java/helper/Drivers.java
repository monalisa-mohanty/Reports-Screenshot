package helper;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
	WebDriver Driver;
	
public WebDriver GetChromeDriver() {
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	Driver = new ChromeDriver();
	return Driver;
}
}

