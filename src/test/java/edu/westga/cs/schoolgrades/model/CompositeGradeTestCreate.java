package edu.westga.cs.schoolgrades.model;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeGradeTestCreate {

	@Test
	public void testCreateCompositeGrade() {
		CompositeGradeAverage average = new CompositeGradeAverage();
		CompositeGrade grade = new CompositeGrade(average);
		assertEquals(grade.toString(), "");
	}
}
