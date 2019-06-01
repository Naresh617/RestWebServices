package com.apspdcl.junit;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicSalaryCalculatorTest {
	
	private BasicSalaryCalculator basicSalaryCalculator;
	
	@BeforeEach
	void init()
	{
		//creating object for your  custome class
		basicSalaryCalculator=new BasicSalaryCalculator();
	}
	
	@Test
	void testBasicSalaryWithValidSalary()
	{
		double basicSalary=5000;
		basicSalaryCalculator.setBasicSalary(basicSalary);
		
		double exceptedSocialInsurance=basicSalary/10;
		
		assertEquals(exceptedSocialInsurance, basicSalaryCalculator.getSocialInsurance());
		
		double expectedAddionalBonus=basicSalary/4;
		assertEquals(expectedAddionalBonus, basicSalaryCalculator.getAdditionalBouns());
		
		double expectedGross=basicSalary+exceptedSocialInsurance+expectedAddionalBonus;
		assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());
	}
	
	
	 @AfterEach
	  void tearDown() {
	    basicSalaryCalculator = null;
	  }
	
	

}
