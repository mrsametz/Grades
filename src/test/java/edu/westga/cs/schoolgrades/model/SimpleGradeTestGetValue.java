package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains tests for getValue.
 * 
 * @author Ashley Metz
 * @version 10/22/2019
 */
public class SimpleGradeTestGetValue {
	@Test
	public void testSimpleGradeGetValue() {
		SimpleGrade grade = new SimpleGrade(75.5);
		double simpleGrade = grade.getValue();
		assertEquals(simpleGrade, 75.5, 0);
	}
	
	@Test
	public void testSimpleGradeGetValueTestTwo() {
		SimpleGrade grade = new SimpleGrade(85.50);
		double simpleGrade = grade.getValue();
		assertEquals(simpleGrade, 85.50, 0);
	}
}
