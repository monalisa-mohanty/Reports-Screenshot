package helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
WebDriver Driver;

	public String TakeScreenshot(WebDriver Driver) throws IOException {
		this.Driver =Driver;
		double number = Math.random();
		File Source = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
		File Destination = new File(System.getProperty("user.dir")+"\\Screenshots\\"+number+"_"+"Screenshot.png");
		FileUtils.copyFile(Source, Destination);
		String path = Destination.toString();
		return path;
	}
	
}
