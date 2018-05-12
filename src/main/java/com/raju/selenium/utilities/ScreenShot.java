package com.raju.selenium.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface ScreenShot {
	public static void screenShotUse(WebDriver driver,String tcName) throws IOException {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File image=ts.getScreenshotAs(OutputType.FILE);
		String proPath=System.getProperty("user.dir");
		FileUtils.copyFile(image, new File(proPath+"\\failureScreenShts\\"+tcName+".jpeg"));
	}

}
