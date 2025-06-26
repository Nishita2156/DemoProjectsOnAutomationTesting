package com.osa.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void runBeforeScenario() {
		System.out.println("==========+Before============");
	}
	@After
	public void runAfterScenario() {
		System.out.println("==========After============");
	}
	
	@Before("@smoke")
	public void runBeforeTagScenario() {
		System.out.println("==========+Before Tag============");
	}
	@After("@smoke")
	public void runAfterTagScenario() {
		System.out.println("==========After Tag============");
	}

}
