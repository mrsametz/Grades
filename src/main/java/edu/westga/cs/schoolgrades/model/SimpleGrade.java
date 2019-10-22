package edu.westga.cs.schoolgrades.model;

public class SimpleGrade extends Object implements Grade  {
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
