package edu.westga.cs.schoolgrades.model;

/**
 * This class is a simple grade that implements the Grade interface.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class SimpleGrade implements Grade  {
	private double grade;
	
	public SimpleGrade(double grade) {
		this.grade = grade;
	}
	
	@Override
	public double getValue() {

		return grade;
	}

	@Override
	public String toString() {
		return "" + this.grade;
		
	}
	
}
