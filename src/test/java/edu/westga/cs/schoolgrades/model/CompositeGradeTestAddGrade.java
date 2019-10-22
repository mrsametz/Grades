package edu.westga.cs.schoolgrades.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeGradeTestAddGrade {

	@Test
	public void testAddGrade() {
		CompositeGrade grade = new CompositeGrade();
		Grade g = new SimpleGrade(50);
		grade.add(g);
		assertEquals(grade.toString(), "50.0");
	}
}
