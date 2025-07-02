package com.etsy.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	private int attempt = 0;
    private final int maxRetry = 3;

	@Override
	public boolean retry(ITestResult result) {
		if (attempt < maxRetry) {
            attempt++;
            return true;
        }
        return false;
    }
	}
	


