package com.Qa.Tutorialsninja.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class NewListenerforTestCase implements ITestListener {
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("This is implements from Listener from onTestStart Method" + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("This is implements from Listener from onTestSuccess Method" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("This is implements from Listener from onTestFailure Method" + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("This is implements from Listener from onTestSkipped Method" + result.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("This is implements from Listener from onTestFailedButWithinSuccessPercentage Method"
				+ result.getName());
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("This is implements from Listener from onTestFailedWithTimeout Method" + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("This is implements from Listener from onTestFailedWithTimeout Method" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("This is implements from Listener from onFinish Method" + context.getName());
	}
}
