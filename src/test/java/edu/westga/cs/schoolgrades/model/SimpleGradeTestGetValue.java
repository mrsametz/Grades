package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SimpleGradeTestGetValue {
	@Test
	public void testSimpleGradeGetValue() {
		SimpleGrade grade = new SimpleGrade(75.5);
		double simpleGrade = grade.getValue();
		assertEquals(simpleGrade, 75.5, 0);
	}
}
