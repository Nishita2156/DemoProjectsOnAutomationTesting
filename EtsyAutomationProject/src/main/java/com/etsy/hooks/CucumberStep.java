package com.etsy.hooks;

public class CucumberStep {
	private static final ThreadLocal<String> currentstep=new ThreadLocal<String>();
	
	public static void setCurrentStep(String step) {
		currentstep.set(step);
	}
   
	public static String getCurrentstep() {
		return currentstep.get();
	}
}
