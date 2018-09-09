package testcases;



import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeTest;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;

import helper.Drivers;
import helper.Screenshot;
import jdk.incubator.http.internal.common.Log;
import pages.FlightFinder;
import pages.Homepage;
import pages.RegistrationPage;


public class TC1  extends Drivers{
WebDriver Driver;
ExtentReports report;
ExtentTest    test;
String Uname = "Dsamanta";
String Pwd = "mypuchu";
Homepage Home = new Homepage();
FlightFinder Flight = new FlightFinder();
RegistrationPage Register = new RegistrationPage();
Screenshot Screen = new Screenshot();



@BeforeTest
public void IniateDrive() throws InterruptedException, IOException  {
	Driver = GetChromeDriver();
	System.out.println("I am the driver" +Driver);
	report = new ExtentReports (System.getProperty("user.dir") +"/Reports/Report.html", true);
	Driver.manage().window().maximize();
	Home.Homepage(Driver);
	Flight.FightFinder(Driver);
	Register.Registration(Driver);
	Screen.TakeScreenshot(Driver);
	//comment
	
}
@Test(priority = 1)
 public void Usersignin() throws IOException {
	 Home.Navigateto();
	 Home.UserSignin(Uname, Pwd);
	 Screen.TakeScreenshot(Driver);
	
	 
    if(	 Flight.successloginValidation() == true ) {
    } else {
    }
	
	 }

@Test(priority = 2)
 public void Flightfinder() throws IOException {
	Flight.FightDetails_Method1();	
	Screen.TakeScreenshot(Driver);
 }

@Test(priority = 3)
 public void UserRegistration() throws InterruptedException, IOException {
	
	 Register.ContactInformation_method1();
	 Screen.TakeScreenshot(Driver);
	 Register.mailinginformation_method2();
	 Screen.TakeScreenshot(Driver);
	 Register.Userinformation_method3();
	 Screen.TakeScreenshot(Driver);
	 
 } 

@Test(priority = 4)
public void Validate_SuccessMessage() {
	Register.validateMessage();
}

@AfterTest
  public void AfterMethod(){
	report.flush();
	Driver.close();
	report.close();
}

@AfterMethod
public void method(ITestResult result) {
	if(result.getStatus()==ITestResult.STARTED) {
	
	}else if(result.getStatus()==ITestResult.SUCCESS) {
		test = report.startTest(result.getName());
		test.log(LogStatus.PASS, "Started");
		report.endTest(test);
		
	}else if(result.getStatus()==ITestResult.FAILURE) {
		
		test = report.startTest(result.getName());
		test.log(LogStatus.FAIL,"Error Message is : ===> "+result.getThrowable());
//		test.log(LogStatus.FAIL,test.addScreenCapture(Screen.Sceenshot(Driver)));		
		report.endTest(test);
	
	}
}
}
 



