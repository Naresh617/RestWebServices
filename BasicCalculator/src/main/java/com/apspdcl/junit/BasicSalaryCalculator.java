package com.apspdcl.junit;

//Normal Java Class for testing 
public class BasicSalaryCalculator {
	private double basicSalary;

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		if (basicSalary < 0) {
			throw new IllegalArgumentException();
		}
		this.basicSalary=basicSalary;
	}
	
	public double getGrossSalary()
	{
		return this.basicSalary+getSocialInsurance()+getAdditionalBouns();
	}

	public double getAdditionalBouns() {
		
		return this.basicSalary*25/100;
	}

	public double getSocialInsurance() {
		
		return  basicSalary/10;
	}

}
