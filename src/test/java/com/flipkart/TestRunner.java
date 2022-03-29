package com.flipkart;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
//@Suite.SuiteClasses({GameBuyValidation.class,LaptopValidation.class})
public class TestRunner {
   public static void main(String[] args) {
	

	Result res = JUnitCore.runClasses(GameBuyValidation.class,LaptopValidation.class);
	
	System.out.println(res.getRunCount());
	System.out.println(res.getRunTime());
	
	
}
}
