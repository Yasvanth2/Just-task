package com.raju.selenium.base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.record.pivottable.ExtendedPivotTableViewFieldsRecord;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.raju.selenium.utilities.ScreenShot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseEngine implements ScreenShot{
	private static WebDriver webdriver;
	private String reportdir=System.getProperty("user.dir")+"\\target\\report.html";
   
	@Parameters("browser")
	@BeforeSuite
	public void openBrowser(@Optional("chrome")String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\HOME\\Balu\\mavenfw\\drivers\\chromedriver.exe");
			webdriver = new ChromeDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "‪C:\\Users\\HOME\\Balu\\mavenfw\\drivers\\geckodriver.exe");
			webdriver = new FirefoxDriver();
			init();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "‪C:\\Users\\HOME\\Balu\\mavenfw\\drivers\\IEDriverServer.exe");
			webdriver = new InternetExplorerDriver();
			init();
		}
		else {
			System.out.println("pass proper parameters");
		}
	}
	public void init() {
	webdriver.manage().deleteAllCookies();
	webdriver.manage().window().maximize();
	webdriver.manage().timeouts().implicitlyWait(89,TimeUnit.SECONDS);
	
	}
	@AfterSuite
	public void closeBrowser() {
		if (webdriver!=null) {
			webdriver.close();
		}
		else {
			System.out.println("WEBDRIVER POINTING TO NULL......");
		}
	}
	@BeforeMethod
	public void	beforeExecution(Method method) {
		System.out.println("NOW EXECUTING..."+method.getName()+"TEST CASE");
	}
	@AfterMethod
	public void afterExcution(ITestResult result) throws IOException {
		if (result.getStatus()==ITestResult.FAILURE) {
			ScreenShot.screenShotUse(getWebdriver(), result.getName());
		}
		else if(result.getStatus()== ITestResult.SUCCESS) {
			ScreenShot.screenShotUse(getWebdriver(), result.getName());
		}
	}
	
	public void initReport() {
		ExtentReports extentReports = new ExtentReports(reportdir);
	}
	
public static WebDriver getWebdriver() {
	return webdriver;
}
}




