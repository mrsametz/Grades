package edu.westga.cs.schoolgrades.model;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompositeGradeTestCreate {

	@Test
	public void testCreateCompositeGrade() {
		CompositeGrade grade = new CompositeGrade();
		assertEquals(grade.toString(), "");
	}
}
