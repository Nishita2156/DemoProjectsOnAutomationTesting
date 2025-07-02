package com.etsy.utils;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.etsy.hooks.ExtentReporter;




public class StepsLogger {
	 public static void logPass(String stepText) {
	        ExtentReporter.getExtentTest().get().log(Status.PASS, "✅ " + stepText);
	    }
	 public static void logFail(String stepText, Exception e, WebDriver driver) {
	        String screenshotPath = ScreenShotUtils.captureScreenshot(driver, stepText.replaceAll("[^a-zA-Z0-9]", "_"));
	        ExtentReporter.getExtentTest().get()
	            .fail("❌ " + stepText + " — Failed: " + e.getMessage())
	            .addScreenCaptureFromPath(screenshotPath);
	    }

}
