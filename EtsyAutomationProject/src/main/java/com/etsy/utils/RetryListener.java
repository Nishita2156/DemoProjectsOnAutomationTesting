package com.etsy.utils;

import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;



public class RetryListener implements IAnnotationTransformer {
	public void transform(ITestAnnotation annotation, Method testMethod) {

        if (annotation.getRetryAnalyzerClass() == null) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }

}
